package com.example.service.impl;

import com.example.dtos.UserDto;
import com.example.dtos.convertor.UserDtoConvertor;
import com.example.dtos.request.UserRequest;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.inter.UserServiceInter;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.utilities.results.SuccessDataResult;
import com.example.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserServiceInter {

   private final UserRepository userRepository;
   private final UserDtoConvertor userDtoConvertor;

    public UserServiceImpl(UserRepository userRepository, UserDtoConvertor userDtoConvertor) {
        this.userRepository = userRepository;
        this.userDtoConvertor = userDtoConvertor;
    }

    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("Kullanici ekledi");
    }

    @Override
    public Result update(int id, UserRequest user) {
        User u = userRepository.findById(id)
                .orElseThrow(
                        ()->new UserNotFoundException("Kulanici Bulunamadi"));
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return new SuccessResult("Kullanici bilgileri basari ile guncellendi");
    }

    @Override
    public Result delete(int id) {
        User u = userRepository.findById(id)
                .orElseThrow(
                        ()->new UserNotFoundException("Kulanici Bulunamadi"));
        userRepository.delete(u);
        return new SuccessResult("Kullanici basari ile silindi");
    }



    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(
                userRepository.findByEmail(email),
                "Email Bulundu"
        );
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email , password);
    }



    @Override
    public List<UserDto> getAllUsers() {
        return  userRepository.findAll()
                .stream()
                .map(n->userDtoConvertor.convertToUserDto(n))
                .collect(Collectors.toList());
    }


}
