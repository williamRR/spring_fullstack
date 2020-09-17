package com.example.demo.model.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, CLIENT;

    public String getAuthority() {
        return name();
    }
}

