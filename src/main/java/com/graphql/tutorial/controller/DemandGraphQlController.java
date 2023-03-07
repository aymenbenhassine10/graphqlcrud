package com.graphql.tutorial.controller;


import com.graphql.tutorial.DAO.entity.Demand;
import com.graphql.tutorial.DAO.entity.Product;
import com.graphql.tutorial.service.IDemandService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class DemandGraphQlController {

    private  final IDemandService demandService;

    public DemandGraphQlController(IDemandService demandService) {
        this.demandService = demandService;
    }

    @QueryMapping
    public Flux<Demand> getAllDemands(){
        return demandService.getAll();
    }
    @QueryMapping
    public Mono<Demand> getDemandById(@Argument("id") String id){
        return demandService.getDemandById(id) ;
    }



    @MutationMapping
    public Mono<Demand> addDemand(@Argument String description, @Argument String productId){

        Demand demand = Demand.builder()
                .description(description).build();
        return demandService.addDemand(Mono.just(demand),productId);

    }
/*
    @MutationMapping
    public Mono<Product> updateProduct(@Argument String id, @Argument String name, @Argument int quantity,@Argument Double price){

        Product p = Product.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();

        return productService.updateProduct(Mono.just(p),id);

    }
    */

    @MutationMapping
    public Mono<Void> deleteDemand(@Argument String id){
        return  demandService.deleteDemand(id);
    }

}
