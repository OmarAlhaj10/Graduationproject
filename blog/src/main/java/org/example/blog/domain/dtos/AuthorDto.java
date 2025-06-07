package org.example.blog.domain.dtos;

import lombok.*;
import org.example.blog.domain.PostStatus;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private UUID id;
    private String name;
}
