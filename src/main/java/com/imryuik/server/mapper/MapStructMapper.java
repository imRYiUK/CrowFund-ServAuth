package com.imryuik.server.mapper;

import com.imryuik.server.dto.UserDTO;
import com.imryuik.server.entity.User;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    UserDTO userToUserDTO(User user);
}
