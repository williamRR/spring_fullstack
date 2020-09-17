package com.example.demo.controller;

import com.example.demo.model.security.Usuario;
import com.example.demo.service.jpa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public String login(@RequestBody Usuario usuario) {
        return userService.signin(usuario);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String signup(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        return userService.signup(usuario);
    }

//  @GetMapping
//  @ResponseStatus(HttpStatus.OK)
//  public List<UserDTO> findAll() {
//    return userService.findAll();
//  }
//
//  @GetMapping("/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  public UserDTO findOne(@PathVariable Long id) {
//    return userService.findById(id);
//  }
//
//  @PutMapping
//  @ResponseStatus(HttpStatus.OK)
//  public void update(@RequestBody UserDTO userDTO) {
//    userService.update(userDTO);
//  }
//
//  @DeleteMapping
//  @ResponseStatus(HttpStatus.OK)
//  public void delete(@RequestBody UserDTO userDTO) {
//    userService.delete(userDTO);
//  }
}