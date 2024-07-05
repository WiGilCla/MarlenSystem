/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.persistence.controller.workerController;
import java.util.Date;

/**
 *
 * @author willy
 */
public class requestWorker {
    private final workerController WorkerController = new workerController();
    private final CheckFields checker = new CheckFields();
    public void saveWorker(String personId, String workerBloodType, String workerBloodTypeCmplt, String workerHealthEntity, Date workerDayLink, String WorkerPosition) throws Exception{
        Person workerPerson = new Person();
        workerPerson.setIdentificationNumber(Integer.parseInt(personId));
        
        String bloodType = workerBloodType.concat(workerBloodTypeCmplt);
        String healthEntity = checker.capitalizedString(workerHealthEntity);
        Date dayLink = workerDayLink;
        String position = checker.capitalizedString(WorkerPosition);
        Person person = workerPerson;
        
        System.out.println(bloodType);
        System.out.println(healthEntity);
        System.out.println(dayLink);
        System.out.println(position);
        
        Worker newWorker = new Worker(bloodType, healthEntity, dayLink, position,person);
        WorkerController.saveWorkerPersis(newWorker);
        
    }
}
