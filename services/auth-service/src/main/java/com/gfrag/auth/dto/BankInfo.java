package com.gfrag.auth.dto;

import lombok.Data;

import java.util.List;

@Data
public class BankInfo {

    private List<Accounts> accounts;
}
