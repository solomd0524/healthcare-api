package com.simplilearn.healthcareapi.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CartService.class})
@Tag("UnitTest")
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private CartMapper cartMapper;

    private static final Long USER_ID = 1L;
    private static final Cart cart = new CartStub();
    private final CartProjection cartProjection = new CartProjectionStub();

    @Test
    void whenGetCartByUserId_thenReturnCart() {

        given(cartRepository.getCartByUserId(anyLong())).willReturn(Optional.of(cartProjection));
        given(cartMapper.map(cartProjection)).willReturn(cart);
        Cart result = cartService.getCartByUserId(USER_ID);

        assertThat(result).isNotNull();
        assertThat(result)
                .isEqualTo(cart);

        verify(cartRepository, times(1)).getCartByUserId(anyLong());
    }

    @Test
    void whenGetCartByUserId_whereNoCartIsFound_thenReturnHttp200AndWithNullCart() {
        given(cartRepository.getCartByUserId(anyLong())).willReturn(Optional.empty());
        Cart result = cartService.getCartByUserId(USER_ID);
        assertThat(result).isNull();
    }
}