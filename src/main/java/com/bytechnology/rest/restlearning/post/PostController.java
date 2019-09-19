package com.bytechnology.rest.restlearning.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllUserPosts(@PathVariable int id){
        return postService.retrieveAllUserPosts(id);
    }
}
