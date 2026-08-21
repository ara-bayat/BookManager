package com.ara.BookManager.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    EDITOR_READ("editor:read"),
    EDITOR_UPDATE("editor:update"),
    EDITOR_CREATE("editor:create"),
    EDITOR_DELETE("editor:delete");

    private final String permission;
    
}
