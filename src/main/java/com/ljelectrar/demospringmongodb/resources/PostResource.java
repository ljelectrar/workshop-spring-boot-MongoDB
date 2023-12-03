package com.ljelectrar.demospringmongodb.resources;

import com.ljelectrar.demospringmongodb.domain.Post;
import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.dto.UserDTO;
import com.ljelectrar.demospringmongodb.resources.util.URL;
import com.ljelectrar.demospringmongodb.services.PostService;
import com.ljelectrar.demospringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired // Injection dependency using the framework
    private PostService service;

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET) // or @getMapping
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/searchtitle" ,method = RequestMethod.GET) // or @getMapping
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",  defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
