package com.pabloporto.workshopmongo.resourses;

import com.pabloporto.workshopmongo.domain.Post;
import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.dto.UserDTO;
import com.pabloporto.workshopmongo.services.PostService;
import com.pabloporto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/posts")
public class PostResourse {

    @Autowired
    private PostService service;

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
