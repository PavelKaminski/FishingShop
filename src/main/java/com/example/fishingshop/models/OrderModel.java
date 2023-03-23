package com.example.fishingshop.models;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;

    @ManyToMany (cascade = CascadeType.REFRESH)
    private List<ItemModel> items = new ArrayList<>();

    private Date placedAt = new Date();
}
