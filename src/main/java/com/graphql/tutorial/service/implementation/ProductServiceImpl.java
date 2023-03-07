package com.graphql.tutorial.service.implementation;


import com.graphql.tutorial.DAO.entity.Product;
import com.graphql.tutorial.DAO.repository.ProductRepository;
import com.graphql.tutorial.mappers.ProductMapper;
import com.graphql.tutorial.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductServiceImpl  implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> addProduct(Mono<Product> productDtoMono) {
        log.info("entering save ..");
        return  productDtoMono
                .flatMap(productRepository::insert);
    }

    @Override
    public Mono<Product> updateProduct(Mono<Product> productDtoMono, String id) {
        return productRepository.findById(id)
                .doOnNext(e->e.setId(id))
                .flatMap(productRepository::save);
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
