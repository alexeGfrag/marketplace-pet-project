package com.gfrag.auth.db.entity;

import com.gfrag.auth.dto.Supplier;
import com.gfrag.auth.enums.GoodCategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection = Goods.GOODS_COLLECTION_NAME)
public class Goods {

    public static final String GOODS_COLLECTION_NAME = "goods";

    @Id
    private String id;

    private String name;
    private GoodCategoryEnum category;
    private BigDecimal cost;
    @Field("stock")
    private Long stock;
    private Supplier supplier;
}
