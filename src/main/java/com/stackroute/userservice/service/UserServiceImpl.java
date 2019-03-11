package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
      User saveUser=userRepository.save(user);
      return saveUser;
    }


    public List<User> getAllUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getById(int id)
    {
        Optional<User> getUser= userRepository.findById(id);
        return getUser;

    }


    public void delete(int id)
    {
        userRepository.deleteById(id);
    }




    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
