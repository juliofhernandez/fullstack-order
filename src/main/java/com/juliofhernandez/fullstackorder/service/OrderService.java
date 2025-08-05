package com.juliofhernandez.fullstackorder.service;

import com.juliofhernandez.fullstackorder.dto.OrderDTO;
import com.juliofhernandez.fullstackorder.dto.OrderDTOFromFE;
import com.juliofhernandez.fullstackorder.dto.UserDTO;
import com.juliofhernandez.fullstackorder.entity.Order;
import com.juliofhernandez.fullstackorder.mapper.OrderMapper;
import com.juliofhernandez.fullstackorder.repo.OrderRepo;
import com.netflix.spectator.impl.PatternExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private OrderRepo orderRepo;
    private SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderService(OrderRepo orderRepo, SequenceGenerator sequenceGenerator) {
        this.orderRepo = orderRepo;
        this.sequenceGenerator = sequenceGenerator;
    }

    public OrderDTO saveOrder(OrderDTOFromFE orderDTOFromFE) {
        // newOrderId is generated using the sequence generator
        int newOrderId = sequenceGenerator.generateNextOrderId();
        // Create a new Order entity using the OrderDTOFromFE data
        Order orderToSave = new Order(
                newOrderId,
                orderDTOFromFE.getFoodItemsList(),
                fetchUserById(orderDTOFromFE.getUserId()), // Fetch the user by ID using the User service
                orderDTOFromFE.getRestaurant()
        );
        // Save the Order entity to the database
        Order orderSaved = orderRepo.save(orderToSave);
        // Map the saved Order entity to an OrderDTO and return it
        return OrderMapper.INSTANCE.orderToOrderDTO(orderSaved);
    }

    // Method to fetch user details by user ID from the User service
    private UserDTO fetchUserById(int userId) {
        String userServiceUrl = "http://fullstack-userInfo/user/getUserById/" + userId;
        UserDTO userDT = restTemplate.getForObject(userServiceUrl, UserDTO.class);
        if (userDT == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        return userDT;
    }
}
