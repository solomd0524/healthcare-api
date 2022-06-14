package com.simplilearn.healthcareapi.cart;

import com.simplilearn.healthcareapi.users.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class CartController {
    CartRepository cartRepository;
    CartService cartService;

    @GetMapping(value = "/api/admin/carts")
    public Iterable<CartEntity> findAllCarts() {
        return cartRepository.findAll();
    }

    @GetMapping(value = "/api/user/carts/{id}")
    public Optional<CartEntity> findCartById(@PathVariable("id") Long cartId) {
        return cartRepository.findById(cartId);
    }

    @GetMapping(value = "/api/user/{id}/carts")
    public Cart getCartByUserId(@PathVariable("id") Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PutMapping(value = "/api/user/carts")
    public CartEntity updateCart(@RequestBody CartEntity cart) {
        return cartRepository.save(cart);
    }

    @PostMapping(value = "/api/user/carts")
    public CartEntity createCart(@RequestBody CartEntity cart) {
        return cartRepository.save(cart);
    }

    @PostMapping(value = "/api/user/carts/users")
    public void initializeCart(@RequestBody User user) {
        cartService.initializeCart(user);
    }

    @DeleteMapping(value = "/api/admin/carts")
    public void deleteCart(@RequestBody CartEntity cart) {
        cartRepository.delete(cart);
    }
}
