package com.graphql.tutorial.controller;

;
import com.graphql.tutorial.DAO.entity.Product;
import com.graphql.tutorial.DTO.ProductDTO;
import com.graphql.tutorial.bookDetails.Book;
import com.graphql.tutorial.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class ProductGraghQlController {

    private final IProductService productService;

    public ProductGraghQlController(IProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public Flux<Product > getAllProducts(){
        return productService.getAll();
    }
    @QueryMapping
    public Mono<Product> getProductById(@Argument("id") String id){
        return productService.getProductById(id) ;
    }

    /* *
    addProduct(name :String, quantity: Int, price: Float): Product
    updateProduct(id: String, name :String, quantity: Int, price: Float): Product
    deleteProduct(id: String): Product
     */

    @MutationMapping
    public Mono<Product> addProduct(@Argument String name, @Argument int quantity,@Argument Double price){

        Product p = Product.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();

        return productService.addProduct(Mono.just(p));

    }

    @MutationMapping
    public Mono<Product> updateProduct(@Argument String id, @Argument String name, @Argument int quantity,@Argument Double price){

        Product p = Product.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();

        return productService.updateProduct(Mono.just(p),id);

    }

    @MutationMapping
    public Mono<Void> deleteProduct(@Argument String id){
        return  productService.deleteProduct(id);
    }




}
