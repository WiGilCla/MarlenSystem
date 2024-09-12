/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.persistence.controller.AccountBookRecordsController;
import java.util.List;

public class RequestAccountBookRecord {
    private final AccountBookRecordsController accountBookRecordsController = new AccountBookRecordsController();
    private final CheckFields CHECKER = new CheckFields();

    public void saveBookRecord(AccountBook accountBookId,String description,
            long cashInflow,long cashExpenses) throws Exception{

        AccountBook book = accountBookId;
        String recordDescription = CHECKER.capitalizedString(description);
        long income = cashInflow;
        long expense = cashExpenses;

        AccountBookRecords bookRecord = new AccountBookRecords(book,
                recordDescription, income, expense);

        accountBookRecordsController.saveBookRecordController(bookRecord);
    }
    
    public void editBookRecord(AccountBookRecords newBookRecord) throws Exception{
        AccountBook book = newBookRecord.getAccountBookId();
        String recordDescription = CHECKER.capitalizedString(newBookRecord.getDescription());
        long income = newBookRecord.getCashInflow();
        long expense = newBookRecord.getCashExpenses();
        
        AccountBookRecords bookRecord = new AccountBookRecords(book,
                recordDescription, income, expense);
        
        bookRecord.setRecordId(newBookRecord.getRecordId());
        
        accountBookRecordsController.editBookRecordController(bookRecord);
    }

    public void deleteBookRecord(AccountBookRecords record) throws Exception{
        accountBookRecordsController.deleteBookRecordController(record.getRecordId());
    }
    
    public List<AccountBookRecords> getRecordsByBookId(AccountBook bookId){
        return accountBookRecordsController.getRecordsByBookIdController(bookId);
    }
}
