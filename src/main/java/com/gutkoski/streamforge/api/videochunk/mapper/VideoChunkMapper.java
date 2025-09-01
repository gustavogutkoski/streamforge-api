package com.gutkoski.streamforge.api.videochunk.mapper;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import com.gutkoski.streamforge.api.videochunk.model.VideoChunk;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoChunkMapper {

    VideoChunkMapper INSTANCE = Mappers.getMapper(VideoChunkMapper.class);

    @Mapping(target = "video.id", source = "videoId")
    VideoChunk toEntity(VideoChunkRequestDTO dto);

    @Mapping(target = "videoId", source = "video.id")
    VideoChunkResponseDTO toDTO(VideoChunk chunk);
}
