package com.juliofhernandez.fullstackorder.entity;

import com.juliofhernandez.fullstackorder.dto.FoodItemDTO;
import com.juliofhernandez.fullstackorder.dto.RestaurantDTO;
import com.juliofhernandez.fullstackorder.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private List<FoodItemDTO> foodItemsList;
    private UserDTO user;
    private RestaurantDTO restaurant;
}
