package com.example.openvoice.controller;

import com.example.openvoice.entity.Post;
import com.example.openvoice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    // CREATE POST
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post);
    }

    // GET ALL POSTS
    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    // LIKE POST
    @PutMapping("/{id}/like")
    public Post likePost(@PathVariable Long id) {
        return service.likePost(id);
    }
}
