package org.example.blog.mappers;

import javax.annotation.processing.Generated;
import org.example.blog.domain.dtos.CategoryDto;
import org.example.blog.domain.dtos.CreateCategoryRequest;
import org.example.blog.domain.entities.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T23:14:47+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();

        if ( category.getPosts() != null ) {
            categoryDto.postCount( (int) calculatePostCount( category.getPosts() ) );
        }
        categoryDto.id( category.getId() );
        categoryDto.name( category.getName() );

        return categoryDto.build();
    }

    @Override
    public Category toEntity(CreateCategoryRequest createCategoryRequest) {
        if ( createCategoryRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( createCategoryRequest.getName() );

        return category.build();
    }
}
