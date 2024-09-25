/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.persistence.controller.AccountBookController;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestAccountBook {
    private final AccountBookController accountBookController = new AccountBookController();
    private final CheckFields CHECKER = new CheckFields();
    
    public void saveBook(int accountBookId,Date creationDate, String titleBook, 
            List<AccountBookRecords> listBookRecords) throws Exception{
        
        int bookId = accountBookId;
        Timestamp creationBook = new Timestamp(creationDate.getTime());
        String bookTitle = CHECKER.capitalizedString(titleBook);
        List<AccountBookRecords> bookRecords = listBookRecords;
        
        AccountBook book = new AccountBook(bookId, creationBook, bookTitle, bookRecords);
        accountBookController.saveBookController(book);
    }
    
    public void editBook(AccountBook book) throws Exception{
        
        int bookId = book.getAccountBookId();
        Timestamp creationBook = new Timestamp(book.getCreationDate().getTime());
        String bookTitle = CHECKER.capitalizedString(book.getTitleBook());
        List<AccountBookRecords> bookRecords = book.getListBookRecords();
        
        AccountBook editedBook = new AccountBook(bookId, creationBook, bookTitle, bookRecords);
        accountBookController.editBookController(editedBook);
    }
    
    public void deleteBook(AccountBook book) throws Exception{
        accountBookController.deleteBookController(book.getAccountBookId());
    }
    
    public int countBook(){
        return accountBookController.getCountBookController();
    }
    
    public AccountBook getBookById(int bookId){
        return accountBookController.getBookByIdController(bookId);
    }
    
    public List<AccountBook> getBooks(){
        List<AccountBook> bookList = new ArrayList<>();
        List<AccountBook> bdBookList = accountBookController.getBooksController();
        return (bdBookList == null)? bookList : bdBookList;
    }
}
