package com.example.demo.service.jpa;

import com.example.demo.model.security.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

//  void update(User user);
//
//  List<User> findAll();
//
//  User findById(Long id);
//
//  void delete(User user);

    String signin(Usuario usuario);

    String signup(Usuario usuario);

    UserDetails loadUserByUsername(String username);
}
