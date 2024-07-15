/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author willy
 */
@Entity
public class Worker implements Serializable{
    
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    @Column(name = "Id")
    private int workerId;
    @Column(name = "BloodType", nullable = false, length = 50)
    private String bloodType;
    @Column(name = "HealtEntity", nullable = false, length = 150)
    private String healthEntity;
    @Column(name = "VinculationDate", nullable = false)
    private Date dayLink;
    @Column(name = "Position", nullable = false, length = 150)
    private String position;
    @Column(name = "Is_active", nullable = false)
    private boolean state;
    @OneToOne
    @JoinColumn(name = "Person_IdentificationNumber")
    private Person person;

    public Worker(String bloodType, String healthEntity, Date dayLink, String position,boolean state, Person person) {
        this.bloodType = bloodType;
        this.healthEntity = healthEntity;
        this.dayLink = dayLink;
        this.position = position;
        this.person = person;
        this.state = state;
    }

    public Worker() {
    }
    
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Worker{" + "workerId=" + workerId + ", bloodType=" + bloodType + ", healthEntity=" + healthEntity + ", dayLink=" + dayLink + ", position=" + position + ", state=" + state + ", person=" + person + '}';
    }
    
    
}
