package notebook.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import notebook.dto.NoteBookDto;
import notebook.entity.NoteBookEntity;
import notebook.mapper.NoteBookMapper;
import notebook.repository.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class NoteBookService {

    @Autowired
    NoteBookRepository repository;

    @Autowired
    NoteBookMapper noteBookMapper;

    public List<NoteBookDto> findAll(){
        return repository.findAll().stream()
                .map(noteBookMapper::fromNoteBookEntity).collect(Collectors.toList());

    }

    public NoteBookEntity findById(String id){
        return repository.findById(id).orElse(null);
    }

    public NoteBookEntity update(NoteBookDto dto ){
        NoteBookEntity entity = noteBookMapper.toNoteBookEntity(dto);
        return repository.save(entity);
    }

    public boolean delete(NoteBookDto dto){
        try{
            NoteBookEntity entity = noteBookMapper.toNoteBookEntity(dto);
            repository.delete(entity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public NoteBookEntity create(NoteBookDto dto ){
        NoteBookEntity entity = noteBookMapper.toNoteBookEntity(dto);
        return repository.save(entity);
    }
}
