package notebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("data4234")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class NoteBookEntity extends AuditingEntity {
    @Id
    private String id;
    private String author;
    private String warp_colour;
    private NotionsEntity notionsEntity;


}
