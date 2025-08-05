package com.juliofhernandez.fullstackorder.repo;

import com.juliofhernandez.fullstackorder.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {
    // This interface will automatically provide CRUD operations for the Order entity
    // No additional methods are needed unless specific queries are required
}
