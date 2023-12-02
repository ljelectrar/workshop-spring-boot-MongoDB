package com.ljelectrar.demospringmongodb.resources;

import com.ljelectrar.demospringmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET) // or @getMapping
    public ResponseEntity<List<User>> findAll() {
         User maria = new User("1", "Maria Silva", "maria@email.com");
         User leandro = new User("1", "Leandro Junior", "leandro@email.com");
         List<User> list = new ArrayList<>();
         list.addAll(Arrays.asList(maria, leandro));
         return ResponseEntity.ok().body(list);
    }
}
