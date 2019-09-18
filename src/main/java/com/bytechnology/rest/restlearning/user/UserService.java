package com.bytechnology.rest.restlearning.user;

import com.bytechnology.rest.restlearning.config.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return  user.get();
        throw new RestException("User not exists!");
    }

    public boolean save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser!=null;
    }
}
