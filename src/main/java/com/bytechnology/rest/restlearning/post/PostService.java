package com.bytechnology.rest.restlearning.post;

import com.bytechnology.rest.restlearning.config.RestException;
import com.bytechnology.rest.restlearning.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    List<Post> retrieveAllUserPosts(int user_id){
        if(!userRepository.findById(user_id).isPresent())
            throw new RestException("User does not exists!");
        return postRepository.findAllNotes(user_id);
    }
}
