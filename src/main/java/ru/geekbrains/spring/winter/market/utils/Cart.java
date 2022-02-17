package ru.geekbrains.spring.winter.market.utils;

import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.NoArgsConstructor;
import javax.annotation.PostConstruct;

import java.util.List;
import ru.geekbrains.spring.winter.market.entities.Product;
import java.util.ArrayList;

@Component
@Data
@NoArgsConstructor
public class Cart {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        products.add(product);
    }

    public void deleteProductFromCart(Product product) {
        products.remove(product);
    }
}
