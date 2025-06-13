package com.api.apiproject.controller;

import com.api.apiproject.exception.CommonException;
import com.api.apiproject.model.BatchUpdateReq;
import com.api.apiproject.model.Transaction;
import com.api.apiproject.model.FilteredTransactionReq;
import com.api.apiproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/getAllTransactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/getAllTransactionsByPaging")
    public List<Transaction> getAllTransactionsByPaging(Integer paginationLimit, Integer paginationOffset) {
        return transactionService.getAllTransactionsByPaging(paginationLimit, paginationOffset);
    }

    @PostMapping("/getFilteredTransactions")
    public List<Transaction> getFilteredTransactions(@RequestBody(required = false) FilteredTransactionReq filteredTransactionReq) {
        return transactionService.getFilteredTransactions(filteredTransactionReq);
    }

    @PostMapping("/updateTransactionById")
    public ResponseEntity<String> updateTransactionById(String id, String description) {
        try {
            return new ResponseEntity<>(transactionService.updateTransactionById(id, description), HttpStatus.OK);
        } catch (CommonException e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }

    @PostMapping("/updateTransactionByBatchIds")
    public ResponseEntity<String> updateTransactionByBatchIds(@RequestBody(required = false) List<BatchUpdateReq> batchUpdateReqList) {
        return new ResponseEntity<>(transactionService.updateTransactionByBatchIds(batchUpdateReqList), HttpStatus.OK);
    }

}
