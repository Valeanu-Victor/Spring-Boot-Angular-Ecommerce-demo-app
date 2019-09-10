package com.ecommerce.app.securedapp.dtoMapper;

import com.ecommerce.app.securedapp.dto.UserDto;
import com.ecommerce.app.securedapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        User entity = new User();

        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.getActive());

        if (dto.getRoles() == null || dto.getRoles().equals("")) {
            entity.setRoles("USER");
        } else {
            entity.setRoles(dto.getRoles());
        }

        if (dto.getPermissions() == null) {
            entity.setPermissions("");
        } else {
            entity.setPermissions(dto.getPermissions());
        }

        return entity;
    }
}