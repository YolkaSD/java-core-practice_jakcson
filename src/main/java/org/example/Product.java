package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private List<Review> reviews;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Review{
    private int rating;
    private String comment;
}