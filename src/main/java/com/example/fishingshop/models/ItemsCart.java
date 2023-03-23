package com.example.fishingshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@SessionScope
@NoArgsConstructor
@AllArgsConstructor
public class ItemsCart {

    private int counter = 0;
    private List<ItemModel> itemsList = new ArrayList<>();

    public void addItemToCart(ItemModel item) {
        itemsList.add(item);
        counter++;
    }

    public void clearCart() {
        itemsList.clear();
    }

}
