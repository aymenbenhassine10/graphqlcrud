package com.graphql.tutorial.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemandProductCount {

    private String product;
    private long demandCount;
}
