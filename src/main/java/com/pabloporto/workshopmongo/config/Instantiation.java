package com.pabloporto.workshopmongo.config;

import com.pabloporto.workshopmongo.domain.Post;
import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.dto.AuthorDTO;
import com.pabloporto.workshopmongo.repository.PostRepository;
import com.pabloporto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User pablo = new User( null,"Pablo","pablo@gmail.com");
        User lucas = new User(null,"Lucas","Lucas@gmail.com");
        User amanda = new User(null,"Amanda","amanda@gmail.com");

        userRepository.saveAll(Arrays.asList(pablo,lucas,amanda));

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu SP","Viajando sp",new AuthorDTO(pablo));
        Post post2 = new Post(null,sdf.parse("27/03/2019"),"Sei lá","Realmente não sei",new AuthorDTO(pablo));

        postRepository.saveAll(Arrays.asList(post1,post2));

        pablo.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(pablo);
    }
}
