package com.pabloporto.workshopmongo.services;

import com.pabloporto.workshopmongo.domain.User;
import com.pabloporto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    private UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll(){
       return repo.findAll();
    }
}
