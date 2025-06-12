package org.example.blog.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.blog.domain.dtos.TagResponse;
import org.example.blog.domain.entities.Tag;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-12T13:50:16+0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagResponse toTagResponse(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagResponse.TagResponseBuilder tagResponse = TagResponse.builder();

        tagResponse.postCount( calculatePostCount( tag.getPosts() ) );
        tagResponse.id( tag.getId() );
        tagResponse.name( tag.getName() );

        return tagResponse.build();
    }

    @Override
    public List<TagResponse> toTagResponseList(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<TagResponse> list = new ArrayList<TagResponse>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( toTagResponse( tag ) );
        }

        return list;
    }
}
