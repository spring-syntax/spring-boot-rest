package com.bytechnology.rest.restlearning.user;

import com.bytechnology.rest.restlearning.post.Post;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

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
