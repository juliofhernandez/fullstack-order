package com.juliofhernandez.fullstackorder.controller;

import com.juliofhernandez.fullstackorder.dto.OrderDTO;
import com.juliofhernandez.fullstackorder.dto.OrderDTOFromFE;
import com.juliofhernandez.fullstackorder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE) {
        OrderDTO orderDTO = orderService.saveOrder(orderDTOFromFE);
        if (orderDTO == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request if the order creation fails
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }
}
