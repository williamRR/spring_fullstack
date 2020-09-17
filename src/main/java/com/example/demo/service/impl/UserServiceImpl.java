package com.example.demo.service.impl;

import com.example.demo.exceptions.AlumnoServiceException;
import com.example.demo.model.security.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.jpa.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

//  @Override
//  public void update(UserDTO userDTO) {
//    userRepository.save(DTOMapper.toEntity(userDTO));
//  }
//
//  @Override
//  public List<UserDTO> findAll() {
//    return
//            userRepository.findAll().stream().map(User::toDTO).collect(Collectors.toList());
//  }
//
//  @Override
//  public UserDTO findById(Long id) {
//    return userRepository.findById(id).orElse(new User()).toDTO();
//  }
//
//  @Override
//  public void delete(UserDTO userDTO) {
//    userRepository.delete(DTOMapper.toEntity(userDTO));
//  }

    public String signin(Usuario usuario) {
        try {
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
            return jwtTokenProvider.createToken(
                        usuario.getUsername(),
                        userRepository.findByUsername(usuario.getUsername()).getRoles());
        } catch (AuthenticationException e) {
            throw new AlumnoServiceException("username o password invalido",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(Usuario usuario) {
        if (!userRepository.existsByUsername(usuario.getUsername())) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            userRepository.save(usuario);
            return jwtTokenProvider.createToken(usuario.getUsername(),
                    usuario.getRoles());
        } else {
            throw new AlumnoServiceException("Username ya está en uso",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        final Usuario usuario = userRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
        }
        return org.springframework.security.core.userdetails.User//
                .withUsername(username)
                .password(usuario.getPassword())
                .authorities(usuario.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
