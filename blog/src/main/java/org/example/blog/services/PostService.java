package org.example.blog.services;

import org.example.blog.domain.CreatePostRequest;
import org.example.blog.domain.UpdatePostRequest;
import org.example.blog.domain.entities.Post;
import org.example.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    Post getPost(UUID id);
    void deletePost(UUID id);
}
