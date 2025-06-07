package org.example.blog.mappers;

import org.example.blog.domain.CreatePostRequest;
import org.example.blog.domain.UpdatePostRequest;
import org.example.blog.domain.dtos.CreatePostRequestDto;
import org.example.blog.domain.dtos.PostDto;
import org.example.blog.domain.dtos.UpdatePostRequestDto;
import org.example.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);
    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
