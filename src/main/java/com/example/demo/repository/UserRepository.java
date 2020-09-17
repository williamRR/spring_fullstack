package com.example.demo.repository;

import com.example.demo.model.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    boolean existsByUsername(String username);

    Usuario findByUsername(String username);

}
