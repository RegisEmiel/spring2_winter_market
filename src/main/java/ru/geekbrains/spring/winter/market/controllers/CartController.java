package ru.geekbrains.spring.winter.market.controllers;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import ru.geekbrains.spring.winter.market.entities.Product;
import ru.geekbrains.spring.winter.market.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Product> findAllInCart() {
        return cartService.findAllProductsInCart();
    }

    @GetMapping("/additem/{productId}")
    public List<Product> addToCart(@PathVariable Long productId) {
        cartService.addProductToCart(productId);
        return cartService.findAllProductsInCart();
    }

    @DeleteMapping("/deleteitem/{productId}")
    public void deleteFromCart(@PathVariable Long productId) {
        cartService.deleteProductFromCart(productId);
    }
}
