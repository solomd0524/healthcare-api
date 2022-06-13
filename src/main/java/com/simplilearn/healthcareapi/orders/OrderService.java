package com.simplilearn.healthcareapi.orders;

import com.simplilearn.healthcareapi.orders.exceptions.OrderNotFoundForUserException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    OrderMapper orderMapper;

    public List<Order> findOrdersByUserId(Long userId) {
        List<Order> orderList = OrderMapper.MAPPER.map(orderRepository.findOrdersByUserId(userId));
        if (ObjectUtils.isEmpty(orderList)) throw new OrderNotFoundForUserException(userId);
        return orderList;
    }
}
