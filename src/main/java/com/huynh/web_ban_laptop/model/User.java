package com.huynh.web_ban_laptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name = "user", schema = "ban_laptop")
public class User {
    @Id
    @Column(name = "id", nullable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Lob
    @Column(name = "email")
    private String email;


    @Lob
    @Column(name = "name")
    private String name;


    @Lob
    @JsonIgnore
    @Column(name = "password")
    private String password;


    @Lob
    @Column(name = "phone_number")
    private String phoneNumber;


    @Lob
    @Column(name = "address")
    private String address;

    @JsonRawValue
    @Column(name = "active")
    private Integer active = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}