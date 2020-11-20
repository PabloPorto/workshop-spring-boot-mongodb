package com.pabloporto.workshopmongo.resourses;

import com.pabloporto.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value = "/users")
public class UserResourse {

    @RequestMapping(method = RequestMethod.GET)
    // It can be the notation @GetMapping. The answear will be the same;
    public ResponseEntity<List<User>> findAll(){
        User pablo = new User("109","Pablo","pablo@gmail.com");
        User lucas = new User("110","Lucas","Lucas@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(pablo,lucas));
        return ResponseEntity.ok().body(list);
    }
}
