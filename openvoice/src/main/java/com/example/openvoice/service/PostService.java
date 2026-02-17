package com.example.openvoice.service;

import com.example.openvoice.entity.Post;
import com.example.openvoice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    // CREATE POST
    public Post createPost(Post post) {

        if (post.isAnonymous()) {
            post.setAuthorName("Anonymous");
        }

        return repository.save(post);
    }

    // GET ALL POSTS
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    // GET POST BY ID
    public Post getPostById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // LIKE POST
    public Post likePost(Long id) {
        Post post = getPostById(id);
        post.setLikes(post.getLikes() + 1);
        return repository.save(post);
    }

}
