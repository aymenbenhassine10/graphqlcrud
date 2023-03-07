package com.graphql.tutorial.service;


import com.graphql.tutorial.DAO.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IProductService {
    public Flux<Product> getAll();
    public Mono<Product> getProductById(String id);
    public Mono<Product> addProduct(Mono<Product> productDtoMono);
    public Mono<Product> updateProduct(Mono<Product> productDtoMono,String id);
    public Mono<Void> deleteProduct(String id);
}
