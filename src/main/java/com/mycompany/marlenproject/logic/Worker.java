/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.util.Date;

/**
 *
 * @author willy
 */
public class Worker{
    
    private int workerId;
    private String bloodType;
    private String healthEntity;
    private Date dayLink;
    private String position;
    
    private Person refPerson;

    public Worker(String bloodType, String healthEntity, Date dayLink, String position, String firstName, String secondName, String firstLastName, String secondLastName, String identificationType, String identificationNumber, String age) {
        this.bloodType = bloodType;
        this.healthEntity = healthEntity;
        this.dayLink = dayLink;
        this.position = position;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHealthEntity() {
        return healthEntity;
    }

    public void setHealthEntity(String healthEntity) {
        this.healthEntity = healthEntity;
    }

    public Date getDayLink() {
        return dayLink;
    }

    public void setDayLink(Date dayLink) {
        this.dayLink = dayLink;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
