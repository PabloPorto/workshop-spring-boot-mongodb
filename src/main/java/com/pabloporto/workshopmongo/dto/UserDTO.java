package com.pabloporto.workshopmongo.dto;

import com.pabloporto.workshopmongo.domain.User;

import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(Optional<User> user) {
    }

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
