package com.graphql.tutorial.DAO.repository;

import com.graphql.tutorial.DAO.entity.Demand;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends ReactiveMongoRepository<Demand,String> {
}
