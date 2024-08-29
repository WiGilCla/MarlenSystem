/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AccountBook implements Serializable {
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "CreationDate", nullable = false)
    private Date creationDate;
    @Column(name = "TitleBook", nullable = false, length = 150)
    private String titleBook;
    @OneToMany(mappedBy = "accountBook")
    private List<AccountBookRecords> listBookRecords;

    public AccountBook() {
        
    }

    public AccountBook(int id, Date creationDate, String titleBook, List<AccountBookRecords> listBookRecords) {
        this.id = id;
        this.creationDate = creationDate;
        this.titleBook = titleBook;
        this.listBookRecords = listBookRecords;
    }
    
    public int getAccountBookId() {
        return id;
    }

    public void setAccountBookId(int id) {
        this.id = id;
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
