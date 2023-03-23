package com.example.fishingshop.controllers;

import com.example.fishingshop.models.ItemModel;
import com.example.fishingshop.models.ItemsCart;
import com.example.fishingshop.models.OrderModel;
import com.example.fishingshop.repositories.OrderRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/itemscart")
public class ItemsCartController {

    private OrderRepository orderRepository;
    private final ItemsCart itemsCart;
    private List<ItemModel> items;

    public ItemsCartController(OrderRepository repository, ItemsCart cart) {
        this.orderRepository = repository;
        this.itemsCart = cart;
    }

    @GetMapping
    public String getCartPage(Model model) {

        items = itemsCart.getItemsList();
        model.addAttribute("items", items);

        return "itemscart";
    }

    @PostMapping
    public RedirectView processOrder(@RequestParam String name, @RequestParam String contact, HttpSession session) {

        OrderModel order = new OrderModel();
        order.setName(name);
        order.setContact(contact);
        order.setItems(items);

        orderRepository.save(order);
        session.invalidate();
        return new RedirectView("/");
    }
}
