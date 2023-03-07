package com.graphql.tutorial.mappers;


import com.graphql.tutorial.DAO.entity.Demand;
import com.graphql.tutorial.DTO.DemandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DemandMapper {

    DemandMapper MAPPER = Mappers.getMapper(DemandMapper.class);

    Demand toDemand(DemandDTO demandDto);


    DemandDTO toDemandDTO(Demand demand);
}
