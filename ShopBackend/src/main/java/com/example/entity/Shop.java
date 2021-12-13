package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shop")
@Data
public class Shop {

    @Id
    private int id;
    private String name;
    private double price;
    private String description;
    //Revee' added this for product images
    private String image_path;
    //Revee' added this for whether an item is still in stock or not
    private boolean is_available;

        public Shop(int id, String name, double price, String description, String image_path, boolean is_available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_path = image_path;
        this.is_available = is_available;
    }

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }



}
