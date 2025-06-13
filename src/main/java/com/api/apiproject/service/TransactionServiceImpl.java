package com.api.apiproject.service;

import com.api.apiproject.dao.TransactionDao;
import com.api.apiproject.exception.CommonException;
import com.api.apiproject.model.BatchUpdateReq;
import com.api.apiproject.model.Transaction;
import com.api.apiproject.model.FilteredTransactionReq;
import com.api.apiproject.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDao transactionDao;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDao.selectTransactions(null, null, null);
    }

    @Override
    public List<Transaction> getAllTransactionsByPaging(Integer paginationLimit, Integer paginationOffset) {
        return transactionDao.selectTransactions(null, paginationLimit, paginationOffset);
    }

    @Override
    public List<Transaction> getFilteredTransactions(FilteredTransactionReq filteredTransactionReq) {
        String customerId = filteredTransactionReq.getCustomerId();
        String accountNumber = filteredTransactionReq.getAccountNumber();
        String description = filteredTransactionReq.getDescription();
        Integer paginationLimit = CommonUtil.getIntegerIfValid(filteredTransactionReq.getPaginationLimit());
        Integer paginationOffset = CommonUtil.getIntegerIfValid(filteredTransactionReq.getPaginationOffset());

        if (StringUtils.isAllBlank(customerId, accountNumber, description)) {
            log.info("No filters found, returning empty list");
            return Collections.emptyList();
        }

        Transaction transaction = Transaction.builder()
                .setCustomerId(customerId)
                .setAccountNumber(accountNumber)
                .setDescription(description)
                .build();
        return transactionDao.selectTransactions(transaction, paginationLimit, paginationOffset);
    }

    @Override
    public String updateTransactionById(String id, String description) {
        Integer idInt = CommonUtil.getIntegerIfValid(id);
        if (idInt == null || StringUtils.isBlank(description)) {
            throw new CommonException("Invalid parameters", HttpStatus.BAD_REQUEST);
        }

        Transaction transaction = Transaction.builder()
                .setId(idInt)
                .setDescription(description)
                .build();

        int updated = transactionDao.updateTransactionById(transaction);
        return updated > 0 ? "Update successful" : "Update failed";
    }

    @Override
    public String updateTransactionByBatchIds(List<BatchUpdateReq> batchUpdateReqList) {
        int updatedRows = 0;

        for (var batchUpdateReq : batchUpdateReqList) {
            Integer idInt = CommonUtil.getIntegerIfValid(batchUpdateReq.getId());
            String description = batchUpdateReq.getDescription();
            if (idInt == null || StringUtils.isBlank(description)) {
                continue;
            }

            Transaction transaction = Transaction.builder()
                    .setId(idInt)
                    .setDescription(description)
                    .build();

            int updated = transactionDao.updateTransactionById(transaction);
            updatedRows += updated;
        }

        return "Updated " + updatedRows + " rows";
    }
}
