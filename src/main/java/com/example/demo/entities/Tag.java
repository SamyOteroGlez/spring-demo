/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author tesa
 */
@Entity
@Table(name = "tags")
@Data
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Post post;

    protected String name;
    
    protected String description;
    
    public Tag()
    {
        //
    }
    
    public Tag(String name, String description)
    {
        this.setName(name);
        this.setDescription(description);
    }
}
