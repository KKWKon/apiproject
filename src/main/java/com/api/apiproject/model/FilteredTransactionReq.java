package com.api.apiproject.model;

import lombok.Data;

@Data
public class FilteredTransactionReq {
    private String customerId;
    private String accountNumber;
    private String description;
    private String paginationLimit;
    private String paginationOffset;
}
