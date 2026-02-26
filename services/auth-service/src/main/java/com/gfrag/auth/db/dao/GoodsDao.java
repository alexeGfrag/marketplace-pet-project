package com.gfrag.auth.db.dao;

import com.gfrag.auth.db.entity.Goods;
import com.gfrag.auth.db.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoodsDao {

    private final GoodsRepository goodsRepository;

    public List<Goods> findByName(String name) {
        return goodsRepository.findByName(name);
    }
}
