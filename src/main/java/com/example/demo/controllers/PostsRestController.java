/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Post;
import com.example.demo.services.PostsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tesa
 */
@RestController
public class PostsRestController extends BaseRestController
{
    /**
     * Post service.
     */
    @Autowired
    protected PostsService service;

    /**
     * Get all posts.
     * 
     * @return List <Post>
     */
    @GetMapping("/posts")
    public List <Post> index()
    {
        return this.service.all();
    }
    
    /**
     * Create a post.
     * 
     * @param post
     * 
     * @return Post
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/posts")
    public Post create(@RequestBody Post post)
    {
        return this.service.create(post);
    }
    
    /**
     * Show a post.
     * 
     * @param id
     * 
     * @return Post
     */
    @GetMapping("/posts/{id}")
    public Post show(@PathVariable Long id)
    {
        return this.service.show(id);
    }
    
    /**
     * Update a post.
     * 
     * @param post
     * 
     * @return Post
     */
    @PutMapping("/posts")
    public Post update(@RequestBody Post post)
    {
        return this.service.update(post);
    }
    
    /**
     * Delete a post.
     * 
     * @param id 
     */
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id)
    {
        this.service.delete(id);
    }
}
