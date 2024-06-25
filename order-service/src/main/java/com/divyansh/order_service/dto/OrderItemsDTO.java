package com.divyansh.order_service.dto;

import com.divyansh.order_service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDTO {
    private Order order;
    private String productId;
    private BigDecimal price;
    private Integer quantity;
}
