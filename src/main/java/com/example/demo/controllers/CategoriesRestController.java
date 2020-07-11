/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tesa
 */
@RestController
public class CategoriesRestController extends BaseRestController
{
    /**
     * Categories service.
     */
    @Autowired
    protected CategoriesService service;
    
    /**
     * Get all categories.
     * 
     * @return List <Category>
     */
    @GetMapping("/categories")
    public List <Category> index()
    {
        return this.service.all();
    }
}
