package com.juliofhernandez.fullstackorder.service;

import com.juliofhernandez.fullstackorder.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/*
    * This class is used to generate a sequence number for the order ID.
    * It uses MongoDB to store and retrieve the sequence number.
    * The sequence number is stored in a collection called "sequence".
    * The sequence number is incremented each time a new order is created.
    * The sequence number is used to generate a unique order ID.
 */
@Service
public class SequenceGenerator {

    /*
        * The sequence number is generated using the MongoOperations class.
        * The MongoOperations class is used to perform operations on the MongoDB database.
     */
    @Autowired
    MongoOperations mongoOperations;

    /*
        * This method generates the next order ID by incrementing the sequence number in the "sequence" collection.
        * It returns the new sequence number.
        * If the sequence number cannot be generated, it throws a RuntimeException.
        *
        * This ensures each order gets a unique, sequential ID, even in a distributed environment.
     */
    public int generateNextOrderId(){
        Sequence sequence = mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("sequence",1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        if (sequence == null) {
            throw new RuntimeException("Unable to generate sequence number");
        }
        return sequence.getSequence();
    }
}
