package com.example.demo;

import com.example.demo.entities.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.demo.*")
public class DemoApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(DemoApplication.class, args);
    }
    
//    @Bean
//    CommandLineRunner initDatabase(PostRepository repository) 
//    {
//        return args -> {
//            repository.save(new Post("Post 01", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
//            repository.save(new Post("Post 02", "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."));
//            repository.save(new Post("Post 03", "It has survived not only five centuries."));
//            repository.save(new Post("Post 04", "Contrary to popular belief, Lorem Ipsum is not simply random text."));
//        };
//    }
}
