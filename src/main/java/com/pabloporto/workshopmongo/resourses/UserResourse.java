package com.pabloporto.workshopmongo.resourses;

import com.pabloporto.workshopmongo.domain.Post;
import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.dto.UserDTO;
import com.pabloporto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/users")
public class UserResourse {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    // It can be the notation @GetMapping. The answear will be the same;
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        //Each element of the list above it is now of the Type UserDTO using lambda function over here.
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
        User user = service.fromDto(userDto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }  @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDto){
        User user = service.fromDto(userDto);
        user.setId(id);
        user = service.update(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value= "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
