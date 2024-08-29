/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.persistence.AccountBookRecordsJpaController;
import java.util.List;

public class AccountBookRecordsController {
    AccountBookRecordsJpaController BookRecordJPAController = new AccountBookRecordsJpaController();

    public void saveBookRecordController(AccountBookRecords newAccountBookRecord){
        BookRecordJPAController.create(newAccountBookRecord);
    }

    public void editBookRecordController(AccountBookRecords newAccountBookRecord) throws Exception{
        BookRecordJPAController.edit(newAccountBookRecord);
    }

    public void deleteBookRecordController(int bookRecordId) throws Exception{
        BookRecordJPAController.destroy(bookRecordId);
    }
    
    public List<AccountBookRecords> getRecordsByBookIdController(AccountBook book_id){
        return BookRecordJPAController.findRecordsByBookId(book_id);
    }
}
