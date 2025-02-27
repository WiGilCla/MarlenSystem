/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.persistence.controller.AccountBookRecordsController;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;

public class RequestAccountBookRecord {

    private final AccountBookRecordsController accountBookRecordsController = new AccountBookRecordsController();

    public void saveBookRecord(AccountBookRecords newRecordsBook) throws Exception {

        String recordDescription = InputValidator.capitalizedString(newRecordsBook.getDescription());
        newRecordsBook.setDescription(recordDescription);

        accountBookRecordsController.saveBookRecordController(newRecordsBook);
    }

    public void editBookRecord(AccountBookRecords editRecordsBook) throws Exception {

        String recordDescription = InputValidator.capitalizedString(editRecordsBook.getDescription());
        editRecordsBook.setDescription(recordDescription);

        accountBookRecordsController.editBookRecordController(editRecordsBook);
    }

    public void deleteBookRecord(AccountBookRecords record) throws Exception {
        accountBookRecordsController.deleteBookRecordController(record.getRecordId());
    }

    public List<AccountBookRecords> getRecordsByBookId(AccountBook bookId) {
        List<AccountBookRecords> bookRecordList = new ArrayList<>();
        List<AccountBookRecords> bdBookRecordList = accountBookRecordsController.getRecordsByBookIdController(bookId);
        return (bdBookRecordList == null) ? bookRecordList : bdBookRecordList;
    }
    
    public void deleteRecordByBook(AccountBook accountBook) throws NonexistentEntityException{
        accountBookRecordsController.deleteRecordByBookController(accountBook);
    }
}
