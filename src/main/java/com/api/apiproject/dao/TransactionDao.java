package com.api.apiproject.dao;

import com.api.apiproject.mapper.TransactionMapper;
import com.api.apiproject.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TransactionDao {

    private final TransactionMapper transactionMapper;

    public int updateTransactionById(Transaction transaction) {
        return transactionMapper.updateTransactionById(transaction);
    }

    public List<Transaction> selectTransactions(Transaction transaction, Integer paginationLimit, Integer paginationOffset) {
        return transactionMapper.selectTransactions(transaction, paginationLimit, paginationOffset);
    }

}
