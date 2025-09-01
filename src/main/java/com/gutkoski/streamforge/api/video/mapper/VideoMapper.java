package com.gutkoski.streamforge.api.video.mapper;

import com.gutkoski.streamforge.api.video.dto.VideoRequestDTO;
import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import com.gutkoski.streamforge.api.video.model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoMapper {

    VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);

    @Mapping(target = "owner.id", source = "ownerId")
    Video toEntity(VideoRequestDTO dto);

    @Mapping(target = "ownerId", source = "owner.id")
    VideoResponseDTO toDTO(Video video);
}
