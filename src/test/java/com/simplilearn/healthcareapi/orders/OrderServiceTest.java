package com.simplilearn.healthcareapi.orders;

import com.simplilearn.healthcareapi.orders.exceptions.OrderNotFoundForUserException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {OrderService.class})
@Tag("UnitTest")
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderMapper orderMapper;

    private static final Long USER_ID = 1L;
    private static final Order order = new OrderStub();
    private static final List<Order> orderList = Collections.singletonList(order);
    private static final OrderProjection orderProjection = new OrderProjectionStub();
    private static final List<OrderProjection> orderProjectionList = Collections.singletonList(orderProjection);


    @Test
    void whenFindOrdersByUserId_thenReturnOrders() {

        given(orderRepository.findOrdersByUserId(anyLong())).willReturn(orderProjectionList);
        given(orderMapper.map(orderProjectionList)).willReturn(orderList);
        List<Order> result = orderService.findOrdersByUserId(USER_ID);

        assertThat(result).isNotNull();
        assertThat(result.get(0)).isNotNull();
        assertThat(result.get(0).getOrderId()).isEqualTo(1L);

        verify(orderRepository, times(1)).findOrdersByUserId(anyLong());
    }

    @Test
    void whenGetOrdersByUserId_whereNoOrderIsFound_thenThrowEntityNotFoundException() {
        given(orderRepository.findOrdersByUserId(anyLong())).willReturn(Collections.emptyList());
        assertThrows(OrderNotFoundForUserException.class, () -> orderService.findOrdersByUserId(USER_ID));
    }
}