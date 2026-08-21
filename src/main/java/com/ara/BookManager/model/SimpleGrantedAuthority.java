package com.ara.BookManager.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;


public class SimpleGrantedAuthority implements GrantedAuthority {
    private String authority;

    public SimpleGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public SimpleGrantedAuthority() {
    }





    @Override
    public @Nullable String getAuthority() {
        return "";
    }
}
