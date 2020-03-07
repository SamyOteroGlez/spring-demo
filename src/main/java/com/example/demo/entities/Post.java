/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author tesa
 */
@Entity
@Table(name = "posts")
@Data
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String title;
    
    protected String body;
    
    public Post()
    {
        //
    }
    
    public Post(String title, String body)
    {
        this.setTitle(title);
        this.setBody(body);
    }
}
