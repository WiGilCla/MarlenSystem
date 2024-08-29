/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountBookRecords implements Serializable {
    
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    @Column(name = "Id", nullable = false, length = 200)
    private int recordId;
    @JoinColumn(name = "accountBookId",nullable = false)
    @ManyToOne
    private AccountBook accountBook;
    @Column(name = "Description", nullable = false, length = 200)
    private String description;
    @Column(name = "CashInflow", nullable = false)
    private long cashInflow;
    @Column(name = "CashExpenses", nullable = false)
    private long cashExpenses;

    public AccountBookRecords() {
    }

    public AccountBookRecords(AccountBook accountBook, String description, long cashInflow, long cashExpenses) {
        this.accountBook = accountBook;
        this.description = description;
        this.cashInflow = cashInflow;
        this.cashExpenses = cashExpenses;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public AccountBook getAccountBookId() {
        return accountBook;
    }

    public void setAccountBookId(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCashInflow() {
        return cashInflow;
    }

    public void setCashInflow(long cashInflow) {
        this.cashInflow = cashInflow;
    }

    public long getCashExpenses() {
        return cashExpenses;
    }

    public void setCashExpenses(long cashExpenses) {
        this.cashExpenses = cashExpenses;
    }

    @Override
    public String toString() {
        return "AccountBookRecords{" + "recordId=" + recordId + ", accountBookId=" + accountBook + ", description=" + description + ", cashInflow=" + cashInflow + ", cashExpenses=" + cashExpenses + '}';
    }
}
