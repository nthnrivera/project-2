package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payments")
@Data
public class Payment {

    @Id
    private int id;
    private double amount;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="payment_types",foreignKey = @ForeignKey(name="payment_id"))
    private List<String> payments;
}
