package com.geekster.Test5.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer orderSize;


    @OneToOne
    @JoinColumn(name = "frk_userId")
    User user;

    @OneToOne
    @JoinColumn(name = "frk_productId")
    Product product;

    @OneToOne
    @JoinColumn(name = "frk_addressId")
    Address address;

}