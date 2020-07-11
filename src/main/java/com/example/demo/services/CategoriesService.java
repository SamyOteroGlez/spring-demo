/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tesa
 */
@Service
public class CategoriesService
{
    /**
     * Categories repository.
     */
    @Autowired
    protected CategoryRepository repository;
    
    /**
     * Get all categories.
     * 
     * @return List <Category>
     */
    public List <Category> all()
    {
        return this.repository.findAll();
    }
}
