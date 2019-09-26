package com.bytechnology.rest.restlearning.user;

import com.bytechnology.rest.restlearning.config.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UserService {

    @Autowired
    private UserRepository userRepository;

    List<User> findAll(){
        return userRepository.findAll();
    }

    User findUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return  user.get();
        throw new RestException("User not exists!");
    }

    boolean save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser!=null;
    }

    void deleteUserById(int id){
        if(!userRepository.findById(id).isPresent())
            throw new RestException("User not exists!");
        userRepository.deleteById(id);
    }

}
