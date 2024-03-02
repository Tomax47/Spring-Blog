package com.example.springtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// We just need to correctly write the model and Spring boot on its own will create the db work for us /No tables to create by us/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
// User table is alrdy taken, so we will need to pick another name
@Table(name = "account")
public class User {
    @Id
    // Auto generate the value to the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    @ManyToMany(mappedBy = "likes")
    private List<Article> likedArticles;
}
