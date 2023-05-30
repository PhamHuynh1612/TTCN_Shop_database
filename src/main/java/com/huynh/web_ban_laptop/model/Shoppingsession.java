package com.huynh.web_ban_laptop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shoppingsession", schema = "ban_laptop")
public class Shoppingsession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private int user;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}