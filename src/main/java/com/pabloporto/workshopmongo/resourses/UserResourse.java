package com.pabloporto.workshopmongo.resourses;

import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/users")
public class UserResourse {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    // It can be the notation @GetMapping. The answear will be the same;
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
