package com.example.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private double balance;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",foreignKey = @ForeignKey(name="user_id"))
    private List<String> authorities;

}
