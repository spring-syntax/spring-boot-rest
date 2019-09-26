package com.bytechnology.rest.restlearning.user;

import com.bytechnology.rest.restlearning.post.Post;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min=3,max=30,message = "Size should be between 4 and 30 characters")
    private String name;

    @Past
    private LocalDate birthday;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Post.class)
    private List<Post> posts;

    protected User() {
    }

    public User(String name, LocalDate birthday) {
        this.name=name;
        this.birthday=birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
}
