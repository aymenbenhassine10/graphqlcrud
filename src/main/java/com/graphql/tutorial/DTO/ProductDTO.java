package com.graphql.tutorial.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class ProductDTO implements Serializable {

//    @JsonIgnore
    private String id;
    private String name;
    private int quantity;
    private double price;
}
