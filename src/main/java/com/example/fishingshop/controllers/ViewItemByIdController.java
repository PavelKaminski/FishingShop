package com.example.fishingshop.controllers;

import com.example.fishingshop.models.ItemModel;
import com.example.fishingshop.models.ItemsCart;
import com.example.fishingshop.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/item{id}")
public class ViewItemByIdController {

    private ItemRepository itemRepository;
    private ItemModel item;
    private final ItemsCart itemsCart;

    public ViewItemByIdController(ItemRepository repository, ItemsCart itemsCart) {
        this.itemRepository = repository;
        this.itemsCart = itemsCart;
    }

    @GetMapping
    public String getItemPageById(@PathVariable("id") Long id, Model model) {

        item = itemRepository.findById(id).get();
        model.addAttribute("item", item);
        model.addAttribute("cart", itemsCart);

        return "item";
    }

    @PostMapping
    public RedirectView addItemToCart(@PathVariable("id") Long id) {

        itemsCart.addItemToCart(item);

        return new RedirectView("/");
    }
}
