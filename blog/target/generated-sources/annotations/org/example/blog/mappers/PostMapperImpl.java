package org.example.blog.mappers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.example.blog.domain.CreatePostRequest;
import org.example.blog.domain.UpdatePostRequest;
import org.example.blog.domain.dtos.AuthorDto;
import org.example.blog.domain.dtos.CategoryDto;
import org.example.blog.domain.dtos.CreatePostRequestDto;
import org.example.blog.domain.dtos.PostDto;
import org.example.blog.domain.dtos.TagResponse;
import org.example.blog.domain.dtos.UpdatePostRequestDto;
import org.example.blog.domain.entities.Category;
import org.example.blog.domain.entities.Post;
import org.example.blog.domain.entities.Tag;
import org.example.blog.domain.entities.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T00:24:17+0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto toDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto.PostDtoBuilder postDto = PostDto.builder();

        postDto.author( userToAuthorDto( post.getAuthor() ) );
        postDto.category( categoryToCategoryDto( post.getCategory() ) );
        postDto.tags( tagSetToTagResponseSet( post.getTags() ) );
        postDto.content( post.getContent() );
        postDto.createdAt( post.getCreatedAt() );
        postDto.id( post.getId() );
        postDto.readingTime( post.getReadingTime() );
        postDto.status( post.getStatus() );
        postDto.title( post.getTitle() );
        postDto.updatedAt( post.getUpdatedAt() );

        return postDto.build();
    }

    @Override
    public CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        CreatePostRequest.CreatePostRequestBuilder createPostRequest = CreatePostRequest.builder();

        createPostRequest.categoryId( dto.getCategoryId() );
        createPostRequest.content( dto.getContent() );
        createPostRequest.status( dto.getStatus() );
        Set<UUID> set = dto.getTagIds();
        if ( set != null ) {
            createPostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        createPostRequest.title( dto.getTitle() );

        return createPostRequest.build();
    }

    @Override
    public UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdatePostRequest.UpdatePostRequestBuilder updatePostRequest = UpdatePostRequest.builder();

        updatePostRequest.categoryId( dto.getCategoryId() );
        updatePostRequest.content( dto.getContent() );
        updatePostRequest.id( dto.getId() );
        updatePostRequest.status( dto.getStatus() );
        Set<UUID> set = dto.getTagIds();
        if ( set != null ) {
            updatePostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        updatePostRequest.title( dto.getTitle() );

        return updatePostRequest.build();
    }

    protected AuthorDto userToAuthorDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuthorDto.AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.id( user.getId() );
        authorDto.name( user.getName() );

        return authorDto.build();
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.id( category.getId() );
        categoryDto.name( category.getName() );

        return categoryDto.build();
    }

    protected TagResponse tagToTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponse.TagResponseBuilder tagResponse = TagResponse.builder();

        tagResponse.id( tag.getId() );
        tagResponse.name( tag.getName() );

        return tagResponse.build();
    }

    protected Set<TagResponse> tagSetToTagResponseSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagResponse> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Tag tag : set ) {
            set1.add( tagToTagResponse( tag ) );
        }

        return set1;
    }
}
