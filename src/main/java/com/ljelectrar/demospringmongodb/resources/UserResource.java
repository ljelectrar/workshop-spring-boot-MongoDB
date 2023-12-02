package com.ljelectrar.demospringmongodb.resources;

import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.dto.UserDTO;
import com.ljelectrar.demospringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
