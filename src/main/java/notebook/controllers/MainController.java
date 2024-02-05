package notebook.controllers;

import lombok.RequiredArgsConstructor;
import notebook.dto.NoteBookDto;
import notebook.entity.NoteBookEntity;
import notebook.mapper.NoteBookMapper;
import notebook.repository.NoteBookRepository;
import notebook.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {



    @Autowired
    private NoteBookService noteBookService;



    @GetMapping("/all")
    public  String allNoteBooks(Model model){
        List<NoteBookDto> allNoteBooks = noteBookService.findAll();
        model.addAttribute("notebooks" , allNoteBooks);
        return "notebook/main";

    }

    @GetMapping("/notebook/{id}" )
    public String notebookById(@PathVariable("id") String id , Model model){
        NoteBookEntity noteBook = noteBookService.findById(id);
        boolean b = noteBook.getNotionsEntity() == null;
        model.addAttribute("notebook" , noteBook);
        return "notebook/notebook" ;
    }


    @PostMapping("/notebook/{id}/update")
    public RedirectView update(@ModelAttribute NoteBookDto dto, RedirectView view ,
                               @PathVariable("id") String id){
        noteBookService.update(dto);
        return new RedirectView("/notebook/" + id);
    }

    @PostMapping("/notebook/{id}/delete")
    public RedirectView delete(@ModelAttribute NoteBookDto dto, RedirectView view ,
                               @PathVariable("id") String id){
        boolean isDeleted = noteBookService.delete(dto);

        if(!isDeleted){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new RedirectView("/all" );
    }




    @GetMapping("/create")
    String createPage(){
        return "notebook/createPage";
    }

}
