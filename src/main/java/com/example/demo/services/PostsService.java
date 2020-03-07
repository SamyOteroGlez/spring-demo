/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.repositories.PostRepository;
import com.example.demo.entities.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author tesa
 */
@Service
public class PostsService 
{
    @Autowired
    protected PostRepository repository;
    
    public List <Post> all()
    {
        return this.repository.findAll();
    }
    
    public Post create(Post post)
    {
        return this.repository.save(post);
    }
    
    public Post show(Long id) throws ResourceNotFoundException
    {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }
    
    public Post update(Post post) throws ResourceNotFoundException
    {
        Post record = this.repository.findById(post.getId()).orElseThrow(() -> new ResourceNotFoundException());
        
        record.setTitle(post.getTitle());
        record.setBody(post.getBody());
                
        return this.repository.save(record);
    }
    
    public void delete(Long id)
    {
        this.repository.deleteById(id);
    }
}
