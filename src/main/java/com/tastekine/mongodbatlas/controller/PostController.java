package com.tastekine.mongodbatlas.controller;


import javax.servlet.http.HttpServletResponse;

import com.tastekine.mongodbatlas.model.Post;
import com.tastekine.mongodbatlas.repository.PostRepository;
import com.tastekine.mongodbatlas.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;


// @CrossOrigin(origins = "http://localhost:3000") for using different applications like react app which is run in localhost:3000
@RestController
public class PostController {

    @Autowired
    PostRepository repository;

    @Autowired
    SearchRepository searchRepository;
    // This method for swagger
    // operations come default but we want to write them ourself so we mask it with this:
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
    return repository.findAll();
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {

        return searchRepository.findByText(text);
    }


    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post) {

       return repository.save(post);
    }
}