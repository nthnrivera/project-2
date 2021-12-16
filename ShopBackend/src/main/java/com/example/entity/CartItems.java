package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JacksonXmlRootElement
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(name = "cart_id"))
    @JsonIgnore
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "shop_id", foreignKey = @ForeignKey(name = "shop_id"))
    @JsonIgnore
    private Shop shops;
}
