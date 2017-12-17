package com.order.order.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findAll();
    OrderEntity findById(String id);

    List<OrderEntity> findByUser(String id);


    OrderDTO findAllItems();

}