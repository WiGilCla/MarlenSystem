/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.persistence.controller.AccountBookController;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RequestAccountBook {
    private final AccountBookController accountBookController = new AccountBookController();
    private final CheckFields CHECKER = new CheckFields();
    
    public void saveBook(AccountBook newBook) throws Exception{
        
        Timestamp creationBook = new Timestamp(newBook.getCreationDate().getTime());
        String bookTitle = CHECKER.capitalizedString(newBook.getTitleBook());
        
        newBook.setCreationDate(creationBook);
        newBook.setTitleBook(bookTitle);
        
        accountBookController.saveBookController(newBook);
    }
    
    public void editBook(AccountBook editBook) throws Exception{
        
        
        Timestamp creationBook = new Timestamp(editBook.getCreationDate().getTime());
        String bookTitle = CHECKER.capitalizedString(editBook.getTitleBook());
        
        editBook.setCreationDate(creationBook);
        editBook.setTitleBook(bookTitle);
        
        accountBookController.editBookController(editBook);
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
