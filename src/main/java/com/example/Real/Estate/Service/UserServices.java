package com.example.Real.Estate.Service;

import com.example.Real.Estate.Model.User;
import com.example.Real.Estate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private  final UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    //get user by id
    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }
    //get all User
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    //delete user
    public void deleteUser(Long userId){
//        log.info("Deleting user "+ userId+"to database");
        userRepository.deleteById(userId);
    }
//    public Optional<User> findUserByUsername(String username){
//        return userRepository.findByUsername(username);
//    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
