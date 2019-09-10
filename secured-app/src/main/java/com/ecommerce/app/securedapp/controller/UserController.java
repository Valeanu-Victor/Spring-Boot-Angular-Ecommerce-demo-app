package com.ecommerce.app.securedapp.controller;

import com.ecommerce.app.securedapp.dto.UserDto;
import com.ecommerce.app.securedapp.jpaRepository.UserRepository;
import com.ecommerce.app.securedapp.model.viewModels.RegisterViewModel;
import com.ecommerce.app.securedapp.model.User;
import com.ecommerce.app.securedapp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          UserService userService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/admin/all")
    public List<User> users(){
        return this.userRepository.findAll();
    }

    @PostMapping(
            value = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HttpStatus> registerUser(@RequestBody RegisterViewModel registerViewModel) {

        UserDto userDto = new UserDto();
        registerViewModel.setPassword(passwordEncoder.encode(registerViewModel.getPassword()));
        registerViewModel.setActive(1);
        BeanUtils.copyProperties(registerViewModel, userDto);

        return userService.createUser(userDto);
    }
}
