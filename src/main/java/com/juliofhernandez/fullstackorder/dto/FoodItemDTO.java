package com.juliofhernandez.fullstackorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private int id;
    private String name;
    private String description;
    private boolean isVegetarian;
    private Number price;
    private int restaurantId;
    private int quantity;
}
