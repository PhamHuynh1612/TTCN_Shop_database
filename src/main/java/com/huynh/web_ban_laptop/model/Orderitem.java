package com.huynh.web_ban_laptop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderitem", schema = "ban_laptop", indexes = {
        @Index(name = "color_id", columnList = "color_id"),
        @Index(name = "product_id", columnList = "product_id"),
        @Index(name = "size_id", columnList = "size_id"),
        @Index(name = "order_id", columnList = "order_id")
})
public class Orderitem {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Orderdetail order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Orderdetail getOrder() {
        return order;
    }

    public void setOrder(Orderdetail order) {
        this.order = order;
    }

}