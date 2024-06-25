package com.divyansh.order_service.dto;

import com.divyansh.order_service.entity.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderItemsDTO> orderItemsDTOList;
}
