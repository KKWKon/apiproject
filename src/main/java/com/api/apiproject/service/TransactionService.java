package com.api.apiproject.service;

import com.api.apiproject.model.BatchUpdateReq;
import com.api.apiproject.model.Transaction;
import com.api.apiproject.model.FilteredTransactionReq;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByPaging(Integer paginationLimit, Integer paginationOffset);

    List<Transaction> getFilteredTransactions(FilteredTransactionReq filteredTransactionReq);

    String updateTransactionById(String id, String description);

    String updateTransactionByBatchIds(List<BatchUpdateReq> batchUpdateReqList);
}
