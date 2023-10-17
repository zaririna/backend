package com.zarina.zarinabackend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    private LocalDateTime commentedAt;

    @ManyToOne
    @JoinColumn
    @JsonProperty("postId")// display post id in json response
    private Post post;

    @ManyToOne
    @JoinColumn
    @JsonProperty("userId")  // display user id in json response
    private User user;

    @JsonGetter("userId") // fetch json getter
    public Long getUserId(){
        return user.getId();
    }

    @JsonGetter("postId")// fetch json getter
    public Long getPostId(){
        return post.getId();
    }
}


