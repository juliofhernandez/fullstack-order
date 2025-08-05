package com.juliofhernandez.fullstackorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDTO> foodItemsList;
    private int userId;
    private RestaurantDTO restaurant;
}

