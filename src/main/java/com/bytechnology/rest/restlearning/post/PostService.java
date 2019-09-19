package com.bytechnology.rest.restlearning.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    List<Post> retrieveAllUserPosts(int user_id){
        return postRepository.findAllNotes(user_id);
    }
}
