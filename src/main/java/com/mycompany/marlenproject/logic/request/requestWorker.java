/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.persistence.controller.workerController;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class requestWorker {
    private final workerController WorkerController = new workerController();
    
    public void saveWorker(Worker worker) throws Exception{
        
        Timestamp dayLink = new Timestamp( worker.getDayLink().getTime());
        String position = InputValidator.capitalizedString(worker.getPosition());
        String healthEntity = InputValidator.capitalizedString(worker.getHealthEntity());
        
        worker.setDayLink(dayLink);
        worker.setPosition(position);
        worker.setHealthEntity(healthEntity);
        
        WorkerController.saveWorkerPersis(worker);
    }
    
    public List<Worker> getWorkers(){
        List<Worker> workerList = new ArrayList<>();
        List<Worker> bdWorkerList = WorkerController.getWorkerPersis();
        return (bdWorkerList == null)? workerList : bdWorkerList;
    }
    
    public void editWorker(Worker worker) throws Exception{
        
        String healthEntity = InputValidator.capitalizedString(worker.getHealthEntity());
        Timestamp dayLink = new Timestamp( worker.getDayLink().getTime());
        
        worker.setHealthEntity(healthEntity);
        worker.setDayLink(dayLink);
        
        WorkerController.editWorkerPersis(worker);    
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
