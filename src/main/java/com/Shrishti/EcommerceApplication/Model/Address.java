package com.Shrishti.EcommerceApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String addressName;
    private String landmark;
    private String phoneNumber;
    private String zipcode;
    private String state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
