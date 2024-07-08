/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.persistence.controller.workerController;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
        
        System.out.println("Tipo sangre trabajador: ".concat(workerBloodType).concat(workerBloodTypeCmplt));
        System.out.println("Tipo Eps: ".concat(workerHealthEntity));
        System.out.println("Dia vinculación: ".concat(workerDayLink.toString()));
        System.out.println("Dia vinculación casteado: ".concat(workerDayLink.toString()));
        System.out.println("Posición: ".concat(WorkerPosition));
        
        String bloodType = workerBloodType.concat(workerBloodTypeCmplt);
        String healthEntity = checker.capitalizedString(workerHealthEntity);
        Timestamp dayLink = new Timestamp( workerDayLink.getTime());
        String position = checker.capitalizedString(WorkerPosition);
        Person person = workerPerson;
        
        
        
        
        
        Worker newWorker = new Worker(bloodType, healthEntity, dayLink, position,person);
        WorkerController.saveWorkerPersis(newWorker);
        
    }
    
    public List<Worker> getWorkers(){
        return WorkerController.getWorkersPersis();
    }
}
