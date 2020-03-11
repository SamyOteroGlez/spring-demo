/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author tesa
 */
@Entity
@Table(name = "categories")
@Data
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class, 
    property = "id"
)
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String name;
    
    protected String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_posts", 
        joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}, 
        inverseJoinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")}
    )
    @JsonBackReference
    protected Set <Post> posts;
    
    public Category()
    {
        //
    }
    
    public Category(String name, String description)
    {
        this.setName(name);
        this.setDescription(description);
    }
}
