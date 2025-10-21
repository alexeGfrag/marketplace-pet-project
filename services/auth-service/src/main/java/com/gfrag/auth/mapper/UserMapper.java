package com.gfrag.auth.mapper;

import com.gfrag.auth.db.entity.User;
import com.gfrag.auth.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDto toDto(User user);
}
