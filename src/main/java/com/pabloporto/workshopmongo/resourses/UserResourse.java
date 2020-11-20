package com.pabloporto.workshopmongo.resourses;

import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.dto.UserDTO;
import com.pabloporto.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
