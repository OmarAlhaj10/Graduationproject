package org.example.blog.mappers;

import org.example.blog.domain.PostStatus;
import org.example.blog.domain.dtos.CategoryDto;
import org.example.blog.domain.dtos.CreateCategoryRequest;
import org.example.blog.domain.entities.Category;
import org.example.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus())).count();
    }
}
