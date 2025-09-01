package com.gutkoski.streamforge.api.user.mapper;

import com.gutkoski.streamforge.api.user.dto.UserRequestDTO;
import com.gutkoski.streamforge.api.user.dto.UserResponseDTO;
import com.gutkoski.streamforge.api.user.model.User;
import com.gutkoski.streamforge.api.video.mapper.VideoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = VideoMapper.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserRequestDTO dto);

    @Mapping(target = "videos", source = "videos")
    UserResponseDTO toDTO(User user);
}
