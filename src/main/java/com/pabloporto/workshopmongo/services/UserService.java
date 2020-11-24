package com.pabloporto.workshopmongo.services;

import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.dto.UserDTO;
import com.pabloporto.workshopmongo.repository.UserRepository;
import com.pabloporto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll(){
       return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public User insert(User user){
        return repo.insert(user);
    }

    public void delete(String id){
        this.findById(id);
        repo.deleteById(id);
    }

    public User fromDto(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
    }
}
