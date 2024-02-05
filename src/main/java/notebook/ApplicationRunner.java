package notebook;

import lombok.extern.slf4j.Slf4j;
import notebook.entity.NoteBookEntity;
import notebook.entity.NotionsEntity;
import notebook.repository.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication()
@Slf4j
@EnableMongoRepositories
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private NoteBookRepository repository;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(13);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
