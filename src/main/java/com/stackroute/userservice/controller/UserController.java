package com.stackroute.userservice.controller;


import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
       User saveduser  = userServiceImpl.saveUser(user);

       return new ResponseEntity<User>(saveduser , HttpStatus.OK);
    }

    @GetMapping ("/users")
    public ResponseEntity<?> getAll()
    {
     return new ResponseEntity<List<User>> ( userServiceImpl.getAllUsers(),  HttpStatus.OK);

    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> GetUser(@PathVariable int id)
    {
        Optional<User> getuser  = userServiceImpl.getById(id);

        return new ResponseEntity<User>(getuser.get() , HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        userServiceImpl.delete(id);
        return "data deleted";

    }

    @PutMapping("/update/{id}")
    public String upadte(@RequestBody User user, @PathVariable int id)
    {
        user.setId(id);
        userServiceImpl.saveUser(user);
        return "Updated successfully";

    }
}
