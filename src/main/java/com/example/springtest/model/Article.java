package com.example.springtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String name;

    @Column(length = 1000) // Cuz standard Spring creates a length of 255, so to edit that we use the @Column(length = lengthHere)
    private String text;

    //Relations
    @ManyToOne
    @JoinTable(name = "article_author")
    private User author;

    @ManyToMany
    @JoinTable(name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "article_id"), // First table joinColumns
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")) // Second table inverseJoinColumns "The user id"
    private List<User> likes; // In the inverseJoinColumns, it gets that it needs to get the id field from the User cuz in the private List<User> likes we specified a list of User objects
}
