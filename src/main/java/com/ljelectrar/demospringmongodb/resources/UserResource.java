package com.ljelectrar.demospringmongodb.resources;

import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.dto.UserDTO;
import com.ljelectrar.demospringmongodb.services.UserService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired // Injection dependency using the framework
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) // or @getMapping
    public ResponseEntity<List<UserDTO>> findAll() {
         List<User> list = service.findAll();
         List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
         return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET) // or @getMapping
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST) // or @postMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
