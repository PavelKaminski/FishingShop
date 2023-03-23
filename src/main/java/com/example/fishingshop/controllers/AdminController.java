package com.example.fishingshop.controllers;

import com.example.fishingshop.models.ItemModel;
import com.example.fishingshop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ItemRepository itemRepository;

    @Autowired
    public AdminController(ItemRepository repository) {
        this.itemRepository = repository;
    }

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping
    @RequestMapping("/add_item")
    public String getAddItemPage() {
        return "add_item";
    }

    @PostMapping("/add_item")
    public RedirectView addItem(@RequestParam String title, @RequestParam String type,
                                @RequestParam String price, @RequestParam String description,
                                @RequestParam String url) {

        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setType(type);
        itemModel.setPrice(price);
        itemModel.setDescription(description);
        itemModel.setPicUrl(url);

        itemRepository.save(itemModel);

        return new RedirectView("/admin");
    }
}
