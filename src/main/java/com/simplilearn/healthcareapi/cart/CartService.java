package com.simplilearn.healthcareapi.cart;

import com.simplilearn.healthcareapi.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CartService {

    CartRepository cartRepository;
    CartMapper cartMapper;

    public Cart getCartByUserId(Long userId) {
        return cartMapper.map(cartRepository.getCartByUserId(userId).orElse(null));
    }

    public void initializeCart(User user) {
        Cart myCart = null;
        if (Objects.nonNull(user) && Objects.nonNull(user.getUserId())) {
            myCart = getCartByUserId(user.getUserId());
            if (Objects.isNull(myCart)) {
                CartEntity cart = new CartEntity();
                cart.setUserId(user.getUserId());
                cartRepository.save(cart);
            }
        }
    }
}
