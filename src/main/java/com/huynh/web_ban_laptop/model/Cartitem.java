package com.huynh.web_ban_laptop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartitem", schema = "ban_laptop")
public class Cartitem {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "session_id", nullable = false)
    private int sessionId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "size_id", nullable = false)
    private int sizeId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Column(name = "color_id", nullable = false)
    private int colorId;


}