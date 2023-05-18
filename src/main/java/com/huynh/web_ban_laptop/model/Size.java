package com.huynh.web_ban_laptop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "size", schema = "ban_laptop")
public class Size {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "size")
    private String size;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}