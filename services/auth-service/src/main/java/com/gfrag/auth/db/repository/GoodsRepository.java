package com.gfrag.auth.db.repository;

import com.gfrag.auth.db.entity.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends MongoRepository<Goods, String> {

    List<Goods> findByName(String name);
}
