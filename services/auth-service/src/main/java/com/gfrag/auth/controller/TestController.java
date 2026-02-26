package com.gfrag.auth.controller;

import com.gfrag.auth.db.entity.Goods;
import com.gfrag.auth.db.repository.GoodsRepository;
import com.gfrag.auth.dto.Accounts;
import com.gfrag.auth.dto.BankInfo;
import com.gfrag.auth.dto.Supplier;
import com.gfrag.auth.enums.GoodCategoryEnum;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @PostConstruct
    public void init() {
        log.info("==========================================================================================================Here we go==================================================================================");
    }

    private final GoodsRepository goodsRepository;

    @GetMapping("/getGoods")
    public List<Goods> getGoods() {
        return goodsRepository.findAll();
    }

    @GetMapping("/init")
    public void insertOneGoods() {
        Goods goods = new Goods();
        goods.setId(UUID.randomUUID().toString());
        goods.setCost(BigDecimal.valueOf(666));
        goods.setCategory(GoodCategoryEnum.MILK);
        Supplier supplier = new Supplier();
        supplier.setAddress("bleeker st. 656");
        BankInfo bankInfo = new BankInfo();
        Accounts accounts = new Accounts();
        accounts.setAccount(4909999992949992L);
        accounts.setBankName("WTF bank");
        bankInfo.setAccounts(List.of(accounts));
        supplier.setBankInfo(bankInfo);
        goods.setSupplier(supplier);
        goods.setStock(400_000L);
        goodsRepository.insert(goods);
    }
}
