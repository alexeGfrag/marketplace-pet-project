package com.gfrag.auth.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Supplier {

    private String name;

    private String address;

    private BankInfo bankInfo;
}
