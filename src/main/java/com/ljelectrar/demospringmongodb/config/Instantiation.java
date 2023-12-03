package com.ljelectrar.demospringmongodb.config;

import com.ljelectrar.demospringmongodb.domain.Post;
import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.dto.AuthorDTO;
import com.ljelectrar.demospringmongodb.repository.PostRepository;
import com.ljelectrar.demospringmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        //userRepository.save(Arrays.asList(maria, alex, bob));


        Post post1 = new Post(null, sdf.parse("26/04/2015"),"Partiu viagem", "Vou viajar para Sampa!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("31/04/2015"),"Partiu volta", "Vou voltar para o Rio!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
