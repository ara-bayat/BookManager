package com.ara.BookManager.enums;

import com.ara.BookManager.model.SimpleGrantedAuthority;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ara.BookManager.enums.Permission.*;


@RequiredArgsConstructor
public enum Role {
    USER(Collections.EMPTY_SET),
    EDITOR(Set.of(EDITOR_READ, EDITOR_DELETE, EDITOR_CREATE, EDITOR_UPDATE)),
    ADMIN(Set.of(ADMIN_READ, ADMIN_DELETE, ADMIN_CREATE, ADMIN_UPDATE,
            EDITOR_READ, EDITOR_DELETE, EDITOR_CREATE, EDITOR_UPDATE));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;

    }
}
