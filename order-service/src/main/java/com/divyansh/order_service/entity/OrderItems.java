package com.divyansh.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items_list")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id" , referencedColumnName ="id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private String productId;
    private BigDecimal price;
    private Integer quantity;
}
