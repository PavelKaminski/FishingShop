package com.example.fishingshop.controllers;
import com.example.fishingshop.models.ItemModel;
import com.example.fishingshop.models.ItemsCart;
import com.example.fishingshop.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {


    private ItemRepository itemRepository;
    private final ItemsCart itemsCart;

    public MainPageController(ItemRepository repository, ItemsCart cart) {
        this.itemRepository = repository;
        this.itemsCart = cart;
    }

    @GetMapping
    public String getMainPage(Model model) {

        Iterable<ItemModel> items = itemRepository.findAll();
        List<ItemModel> itemsList = new ArrayList<>();
        items.forEach(itemsList::add);
        model.addAttribute("items", itemsList);
        model.addAttribute("cart", itemsCart);

        return "index";
    }

}
