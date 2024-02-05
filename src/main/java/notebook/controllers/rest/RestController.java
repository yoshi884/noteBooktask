package notebook.controllers.rest;


import lombok.RequiredArgsConstructor;
import notebook.dto.NoteBookDto;
import notebook.entity.NoteBookEntity;
import notebook.mapper.NoteBookMapper;
import notebook.repository.NoteBookRepository;
import notebook.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notebook")
public class RestController {



    @Autowired
    private NoteBookService noteBookService;


    @GetMapping("/all")
    public List<NoteBookDto> allNoteBooks(Model model){
       return noteBookService.findAll();

    }

    @GetMapping("/{id}" )
    public NoteBookEntity notebookById(@PathVariable("id") String id){
        return  noteBookService.findById(id);

    }


    @PostMapping("/{id}/update")
    public NoteBookEntity update(@RequestBody NoteBookDto dto,
                               @PathVariable("id") String id){
        return noteBookService.update(dto);
    }

    @PostMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody NoteBookDto dto,
                               @PathVariable("id") String id){
        boolean isDeleted = noteBookService.delete(dto);

        if(!isDeleted){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertNoteBook(@RequestBody NoteBookDto noteBookDto) {

        NoteBookEntity createdNoteBook = noteBookService.create(noteBookDto);
    }

}
