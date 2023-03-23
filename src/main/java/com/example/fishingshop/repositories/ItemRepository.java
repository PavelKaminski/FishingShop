package com.example.fishingshop.repositories;

import com.example.fishingshop.models.ItemModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemModel, Long> {

}
