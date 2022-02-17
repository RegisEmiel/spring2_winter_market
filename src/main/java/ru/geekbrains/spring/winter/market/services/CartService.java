package ru.geekbrains.spring.winter.market.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.geekbrains.spring.winter.market.utils.Cart;
import ru.geekbrains.spring.winter.market.entities.Product;
import ru.geekbrains.spring.winter.market.repositories.ProductRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductRepository productRepository;

    private final Cart cart;

    public List<Product> findAllProductsInCart() {
        return cart.getProducts();
    }

    public void addProductToCart(Long productId){
        Product product = productRepository.findById(productId).get();
        cart.addProductToCart(product);
    }

    public void deleteProductFromCart(Long productId){
        Product product = productRepository.findById(productId).get();
        cart.deleteProductFromCart(product);
    }
}
