package com.tastekine.mongodbatlas.repository;

import com.tastekine.mongodbatlas.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {

    List<Post> findByText(String text);

}
