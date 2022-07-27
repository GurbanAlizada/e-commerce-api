package com.example.service.inter;

import com.example.dtos.UserDto;
import com.example.dtos.request.UserRequest;
import com.example.model.User;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;

import java.util.List;

public interface UserServiceInter {

    Result add(User user);

    Result update(int id , UserRequest user);

    Result delete(int id);

    DataResult<User> findByEmail(String email);

    User findByEmailAndPassword(String email , String password);

    List<UserDto>  getAllUsers();

}
