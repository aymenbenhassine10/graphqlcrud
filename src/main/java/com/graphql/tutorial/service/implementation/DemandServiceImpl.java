package com.graphql.tutorial.service.implementation;

import com.graphql.tutorial.DAO.entity.Demand;
import com.graphql.tutorial.DAO.entity.Product;
import com.graphql.tutorial.DAO.repository.DemandRepository;
import com.graphql.tutorial.DAO.repository.ProductRepository;
import com.graphql.tutorial.DTO.DemandProductCount;
import com.graphql.tutorial.service.IDemandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class DemandServiceImpl implements IDemandService {

    @Autowired
    private DemandRepository demandRepository;
    @Autowired
    private ProductRepository productRepository;


    private MongoOperations mongoOperations;


    @Override
    public Flux<Demand> getAll() {
        return demandRepository.findAll();
    }

    @Override
    public Mono<Demand> getDemandById(String id) {
        return demandRepository.findById(id);
    }

    @Override
    public Mono<Demand> addDemand(Mono<Demand> demandMono,String productId) {
        Product p = productRepository.findById(productId).block();
        demandMono.block().setProduct(p);
        log.info(String.valueOf(demandMono.block()));
        return demandMono
                .flatMap(demandRepository::insert);
    }

    @Override
    public Mono<Demand> updateDemand(Mono<Demand> demandMono, String id) {
        return demandMono
                .flatMap(demandRepository::save);
    }

    @Override
    public Mono<Void> deleteDemand(String id) {
        return demandRepository.deleteById(id);
    }

}
