package com.upgrad.EndtermFinal.service;

import com.upgrad.EndtermFinal.model.UserDetails;
import com.upgrad.EndtermFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Method to save user
   public void addUser(UserDetails userDetails){
       this.userRepository.save(userDetails);
   }

   // Method to get all the users
    public List<UserDetails> getAllUsers(){
         return (List<UserDetails>) this.userRepository.findAll();
    }

    // Method to delete a user
    public void deleteUser(Integer id){
       this.userRepository.deleteById(id);
    }

    //Method to get user by id
    public Optional<UserDetails> getUserByID(Integer id){
       return this.userRepository.findById(id);
    }

   // Method to get user by name
    public List<UserDetails> findByUserName(String name){
        return this.userRepository.findAllByName(name);
    }


}
