package com.juliofhernandez.fullstackorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int id;
    private List<FoodItemDTO> foodItemList;
    private UserDTO user;
    private RestaurantDTO restaurant;
}

