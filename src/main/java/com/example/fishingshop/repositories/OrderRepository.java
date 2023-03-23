package com.example.fishingshop.repositories;

import com.example.fishingshop.models.OrderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Long> {
}
