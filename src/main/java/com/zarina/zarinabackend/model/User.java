package com.zarina.zarinabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity // indicate that class need to stored in db
@Getter // generate getters for each field
@Setter // generate getters for each field
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private LocalDateTime registeredAt;
    @JsonIgnore // we do not need return to client here password
    private String password;



    @OneToMany(
            mappedBy = "user"
    )
    private List<Post> posts;

}
