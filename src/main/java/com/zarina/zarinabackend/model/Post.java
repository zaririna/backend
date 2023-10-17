package com.zarina.zarinabackend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity // indicate that class need to stored in db
@Getter // generate getters for each field
@Setter // generate getters for each field
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    private LocalDateTime publishedAt;

    @OneToMany(
            mappedBy = "post"
    )
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn
    @JsonProperty("userId") // display user id in json response
    private User user;

    @JsonGetter("userId") // fetch json getter
    public Long getUserId(){
        return user.getId();
    }
}
