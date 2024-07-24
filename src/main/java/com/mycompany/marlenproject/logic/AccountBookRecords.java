/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class AccountBookRecords {
    @ManyToOne
    @Column(name = "AccountBookId", nullable = false, length = 200)
    private AccountBook accountBookId;
    @Column(name = "Description", nullable = false, length = 200)
    private String description;
    @Column(name = "CashInflow", nullable = false)
    private int cashInflow;
    @Column(name = "CashExpenses", nullable = false)
    private int cashExpenses;

    public AccountBookRecords() {
    }

    public AccountBookRecords(AccountBook accountBookId, String description, int cashInflow, int cashExpenses) {
        this.accountBookId = accountBookId;
        this.description = description;
        this.cashInflow = cashInflow;
        this.cashExpenses = cashExpenses;
    }

    public AccountBook getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(AccountBook accountBookId) {
        this.accountBookId = accountBookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCashInflow() {
        return cashInflow;
    }

    public void setCashInflow(int cashInflow) {
        this.cashInflow = cashInflow;
    }

    public int getCashExpenses() {
        return cashExpenses;
    }

    public void setCashExpenses(int cashExpenses) {
        this.cashExpenses = cashExpenses;
    }
}
