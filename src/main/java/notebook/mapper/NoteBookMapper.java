package notebook.mapper;

import notebook.dto.NoteBookDto;
import notebook.entity.NoteBookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface NoteBookMapper {
    NoteBookEntity toNoteBookEntity(NoteBookDto noteBookDto);

    NoteBookDto fromNoteBookEntity(NoteBookEntity entity);
}
