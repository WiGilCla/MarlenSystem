/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class AccountBook {
    @Id
    @Column(name = "accountBookId")
    private int accountBookId;
    @Column(name = "FirstName", nullable = false)
    private Date creationDate;
    @Column(name = "FirstName", nullable = false, length = 150)
    private String titleBook;
    @OneToMany(mappedBy = "AccountBookId")
    private List<AccountBookRecords> listBookRecords;

    public AccountBook() {
        
    }

    public AccountBook(int accountBookId, Date creationDate, String titleBook, List<AccountBookRecords> listBookRecords) {
        this.accountBookId = accountBookId;
        this.creationDate = creationDate;
        this.titleBook = titleBook;
        this.listBookRecords = listBookRecords;
    }
    
    public int getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(int accountBookId) {
        this.accountBookId = accountBookId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public List<AccountBookRecords> getListBookRecords() {
        return listBookRecords;
    }

    public void setListBookRecords(List<AccountBookRecords> listBookRecords) {
        this.listBookRecords = listBookRecords;
    }
    
    public void addRecordToBook(AccountBookRecords AccountBookRecords){
        this.listBookRecords.add(AccountBookRecords);
    }
}
