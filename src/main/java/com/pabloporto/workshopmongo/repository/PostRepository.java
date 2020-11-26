package com.pabloporto.workshopmongo.repository;

import com.pabloporto.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    //Look to the MongoDB's documentations is very important to understand this notation;
    @Query("{ 'title' : { $regex: ?0, &options: 'i'} }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
