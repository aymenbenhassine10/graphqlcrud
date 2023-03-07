package com.graphql.tutorial.mappers;


import com.graphql.tutorial.DAO.entity.Product;
import com.graphql.tutorial.DTO.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
     ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
}
