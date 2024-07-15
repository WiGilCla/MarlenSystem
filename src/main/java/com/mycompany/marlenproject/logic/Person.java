/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {
    @Id
    @Column(name = "IdentificationNumber")
    private int identificationNumber;
    @Column(name = "FirstName", nullable = false, length = 150)
    private String firstName;
    @Column(name = "SecondName", nullable = true, length = 150)
    private String secondName;
    @Column(name = "FirstLastname", nullable = false, length = 150)
    private String firstLastName;
    @Column(name = "SecondLastname", nullable = true, length = 50)
    private String secondLastName;
    @Column(name = "IdentificationType", nullable = false, length = 50)
    private String identificationType;
    @Column(name = "Birthdate", nullable = false)
    private Date  birthdate;
    
    public Person(String firstName, String secondName, String firstLastName, String secondLastName, String identificationType, int identificationNumber, Date birthdate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.birthdate = birthdate;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" + "identificationNumber=" + identificationNumber + ", firstName=" + firstName + ", secondName=" + secondName + ", firstLastName=" + firstLastName + ", secondLastName=" + secondLastName + ", identificationType=" + identificationType + ", birthdate=" + birthdate + '}';
    }
}
