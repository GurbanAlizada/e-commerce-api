package com.example.controller;


import com.example.dtos.UserDto;
import com.example.dtos.request.UserRequest;
import com.example.model.User;
import com.example.service.inter.UserServiceInter;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.ErrorDataResult;
import com.example.utilities.results.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceInter userServiceInter;

    public UserController(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(userServiceInter.add(user));
    }


    @GetMapping("/findByEmail")
    public ResponseEntity<DataResult<User>> findByEmail(String email){
        return ResponseEntity.ok(userServiceInter.findByEmail(email));
    }


    @GetMapping("/findByEmailAndPassword")
    public ResponseEntity<User> findByEmailAndPassword
            (@RequestParam("email") String email,
             @RequestParam("password") String password){
        return ResponseEntity.ok(userServiceInter.findByEmailAndPassword(email, password));
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceInter.getAllUsers());
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(
            @RequestParam("id") int id,
            @Valid @RequestBody UserRequest user){
        return ResponseEntity.ok(userServiceInter.update(id, user));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(userServiceInter.delete(id));
    }


}
