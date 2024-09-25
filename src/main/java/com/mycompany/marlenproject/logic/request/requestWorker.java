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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class requestWorker {
    private final workerController WorkerController = new workerController();
    private final CheckFields checker = new CheckFields();
    
    public void saveWorker(String identificationNumber, String workerBloodType, String workerBloodTypeCmplt, 
            String workerHealthEntity, Date workerDayLink, String WorkerPosition) throws Exception{
        
        
        String bloodType = workerBloodType.concat(workerBloodTypeCmplt);
        String healthEntity = checker.capitalizedString(workerHealthEntity);
        Timestamp dayLink = new Timestamp( workerDayLink.getTime());
        String position = checker.capitalizedString(WorkerPosition);
        boolean state = true;
        boolean is_delete = false;
        
        
        Person workerPerson = new Person();
        workerPerson.setIdentificationNumber(identificationNumber);
        Person person = workerPerson;
        
        
        Worker newWorker = new Worker(bloodType, healthEntity, dayLink, position,state, is_delete,person);
        WorkerController.saveWorkerPersis(newWorker);
    }
    
    public List<Worker> getWorkers(){
        List<Worker> workerList = new ArrayList<>();
        List<Worker> bdWorkerList = WorkerController.getWorkerPersis();
        return (bdWorkerList == null)? workerList : bdWorkerList;
    }
    
    public void editWorker(int workerId,String identificationNumber, String workerBloodType, 
            String workerBloodTypeCmplt, String workerHealthEntity, Date workerDayLink, 
            String WorkerPosition, boolean workerState, boolean workerDelete) throws Exception{
        
        
        
        String bloodType = workerBloodType.concat(workerBloodTypeCmplt);
        String healthEntity = checker.capitalizedString(workerHealthEntity);
        Timestamp dayLink = new Timestamp( workerDayLink.getTime());
        String position = checker.capitalizedString(WorkerPosition);
        boolean state = workerState;
        boolean is_delete = workerDelete;
        
        
        Person workerPerson = new Person();
        workerPerson.setIdentificationNumber(identificationNumber);
        Person person = workerPerson;

        
        Worker newWorker = new Worker(bloodType, healthEntity, dayLink, position,state,is_delete,person);
        newWorker.setWorkerId(workerId);
        WorkerController.editWorkerPersis(newWorker);    
    }
    
    public List<Worker> getNoDeletedWorker(){
        List<Worker> workerList = new ArrayList<>();
        List<Worker> bdWorkerList = WorkerController.getNoDeletedWorkerPersis();
        return (bdWorkerList == null)? workerList : bdWorkerList;
    }
    
    public Worker findWorkerByDNI(String dni){
        return WorkerController.getWorkerByDNIPersis(dni);
    }
}
