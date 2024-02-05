package notebook.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import notebook.entity.NotionsEntity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class NoteBookDto {
    private String id;
    private String author;
    private String warp_colour;
    private NotionsEntity notionsEntity;
}
