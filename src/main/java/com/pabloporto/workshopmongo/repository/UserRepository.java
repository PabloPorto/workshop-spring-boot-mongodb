package com.pabloporto.workshopmongo.repository;

import com.pabloporto.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
