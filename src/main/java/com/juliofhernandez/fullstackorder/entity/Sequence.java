package com.juliofhernandez.fullstackorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This class is used to represent a sequence in the MongoDB database.
// It is used to generate unique sequence numbers for order IDs.
// The @Document annotation indicates that this class is a MongoDB document.
@Document(collection = "sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {
    @Id
    private String id;
    private int sequence;
}
