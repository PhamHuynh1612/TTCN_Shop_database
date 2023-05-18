package com.huynh.web_ban_laptop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shoppingsession", schema = "ban_laptop", indexes = {
        @Index(name = "user_id", columnList = "user_id")
})
public class Shoppingsession {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}