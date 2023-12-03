 package com.ljelectrar.demospringmongodb.services;

import com.ljelectrar.demospringmongodb.domain.Post;
import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.dto.UserDTO;
import com.ljelectrar.demospringmongodb.repository.PostRepository;
import com.ljelectrar.demospringmongodb.repository.UserRepository;
import com.ljelectrar.demospringmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date min, Date max){
        max = new Date(max.getTime() + 24 * 60 *60 *1000);
        return repo.fullSearch(text, min, max);
    }

}
