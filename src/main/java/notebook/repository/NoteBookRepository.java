package notebook.repository;

import notebook.entity.NoteBookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoteBookRepository extends MongoRepository<NoteBookEntity, String> {

}
