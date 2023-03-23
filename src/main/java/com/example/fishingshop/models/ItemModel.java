package com.example.fishingshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity (name = "item_model")
@Data
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String type;
    private String price;
    private String description;
    private String picUrl;

}
