/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.persistence.AccountBookJpaController;
import java.util.List;

/**
 *
 * @author willy
 */
public class AccountBookController {
    AccountBookJpaController BookJPAController = new AccountBookJpaController();
    
    public void saveBookController(AccountBook newAccountBook) throws Exception{
        BookJPAController.create(newAccountBook);
    }
    
    public void editBookController(AccountBook newAccountBook) throws Exception{
        BookJPAController.edit(newAccountBook);
    }
    
    public void deleteBookController(int bookId) throws Exception {
        BookJPAController.destroy(bookId);
    }
    
    public int getCountBookController(){
        return BookJPAController.getAccountBookCount();
    }
    
    public AccountBook getBookByIdController(int bookId){
        return BookJPAController.findAccountBook(bookId);
    }
    
    public List<AccountBook> getBooksController(){
        return BookJPAController.findAccountBookEntities();
    }
}
