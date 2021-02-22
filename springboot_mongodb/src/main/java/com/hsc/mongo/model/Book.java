package com.hsc.mongo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "book")
public class Book {
    private int id;
    private String bookName;
    private String authorName;
}
