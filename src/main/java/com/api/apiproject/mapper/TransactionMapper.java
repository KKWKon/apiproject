package com.api.apiproject.mapper;

import com.api.apiproject.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {

    int updateTransactionById(Transaction transaction);

    List<Transaction> selectTransactions(Transaction transaction, Integer limit, Integer offset);

}
