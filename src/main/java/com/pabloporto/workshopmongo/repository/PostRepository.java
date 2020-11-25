package com.pabloporto.workshopmongo.repository;

import com.pabloporto.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
