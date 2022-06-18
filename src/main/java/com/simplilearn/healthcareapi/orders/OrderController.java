package com.simplilearn.healthcareapi.orders;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    OrderRepository orderRepository;
    OrderService orderService;

    @GetMapping(value = "/api/admin/orders")
    public Iterable<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping(value = "/api/user/orders")
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

    @PutMapping(value = "/api/user/orders")
    public OrderEntity updateOrders(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

    @DeleteMapping(value = "/api/user/orders")
    public void deleteOrder(@RequestBody OrderEntity order) {
        orderRepository.delete(order);
    }

    @GetMapping(value = "/api/user/orders/{id}")
    public List<Order> findOrdersByUserId(@PathVariable("id") Long userId) {
        return orderService.findOrdersByUserId(userId);
    }
}
