package com.api.apiproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Integer id;
    private String accountNumber;
    private String trxAmount;
    private String description;
    private String trxDate;
    private String trxTime;
    private String customerId;
}
