package com.divyansh.order_service.service;

import com.divyansh.order_service.dto.OrderItemsDTO;
import com.divyansh.order_service.dto.OrderRequest;
import com.divyansh.order_service.entity.Order;
import com.divyansh.order_service.entity.OrderItems;
import com.divyansh.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional()
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID());

        List<OrderItems> orderItemsList = orderRequest.getOrderItemsDTOList().stream().map(this::orderItemsDTOMapper).toList();
        order.setOrderItems(orderItemsList);
        BigDecimal totalAmount = calculateTotalAmount(order);
        order.setTotalAmount(totalAmount);

        orderRepository.save(order);
    }

    private OrderItems orderItemsDTOMapper(OrderItemsDTO orderItemsDTO){
        return  OrderItems.builder()
                .price(orderItemsDTO.getPrice())
                .quantity(orderItemsDTO.getQuantity())
                .productId(orderItemsDTO.getProductId())
                .build();
    }

    private BigDecimal calculateTotalAmount(Order order) {
        return  order.getOrderItems().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
