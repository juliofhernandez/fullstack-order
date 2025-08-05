package com.juliofhernandez.fullstackorder.mapper;


import com.juliofhernandez.fullstackorder.dto.OrderDTO;
import com.juliofhernandez.fullstackorder.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderDTOToOrder(Order orderDTO);
    OrderDTO orderToOrderDTO(Order order);
}
