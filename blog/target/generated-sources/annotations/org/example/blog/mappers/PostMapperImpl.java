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
    date = "2025-06-07T23:14:47+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
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
        postDto.id( post.getId() );
        postDto.title( post.getTitle() );
        postDto.content( post.getContent() );
        postDto.readingTime( post.getReadingTime() );
        postDto.createdAt( post.getCreatedAt() );
        postDto.updatedAt( post.getUpdatedAt() );
        postDto.status( post.getStatus() );

        return postDto.build();
    }

    @Override
    public CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        CreatePostRequest.CreatePostRequestBuilder createPostRequest = CreatePostRequest.builder();

        createPostRequest.title( dto.getTitle() );
        createPostRequest.content( dto.getContent() );
        createPostRequest.categoryId( dto.getCategoryId() );
        Set<UUID> set = dto.getTagIds();
        if ( set != null ) {
            createPostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        createPostRequest.status( dto.getStatus() );

        return createPostRequest.build();
    }

    @Override
    public UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdatePostRequest.UpdatePostRequestBuilder updatePostRequest = UpdatePostRequest.builder();

        updatePostRequest.id( dto.getId() );
        updatePostRequest.title( dto.getTitle() );
        updatePostRequest.content( dto.getContent() );
        updatePostRequest.categoryId( dto.getCategoryId() );
        Set<UUID> set = dto.getTagIds();
        if ( set != null ) {
            updatePostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        updatePostRequest.status( dto.getStatus() );

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
