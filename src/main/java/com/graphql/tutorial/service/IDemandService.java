package com.graphql.tutorial.service;

import com.graphql.tutorial.DAO.entity.Demand;
import com.graphql.tutorial.DAO.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDemandService {

    public Flux<Demand> getAll();
    public Mono<Demand> getDemandById(String id);
    public Mono<Demand> addDemand(Mono<Demand> demandMono, String productId);
    public Mono<Demand> updateDemand(Mono<Demand> demandMono,String id);
    public Mono<Void> deleteDemand(String id);

}
