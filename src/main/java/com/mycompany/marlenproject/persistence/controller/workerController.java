/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.persistence.WorkerJpaController;
import java.util.List;

/**
 *
 * @author willy
 */
public class workerController {
    WorkerJpaController workerJpa = new WorkerJpaController();
    public void saveWorkerPersis(Worker newWorker) throws Exception{
        System.out.println("Accediendo a SAVE WORKER");
         workerJpa.create(newWorker);
    }
    
    public List<Worker> getWorkerPersis(){
        return workerJpa.findWorkerEntities();
    }
    
    public void editWorkerPersis(Worker newWorker) throws Exception{
        System.out.println("TRABAJADOR: ".concat(newWorker.toString()));
        workerJpa.edit(newWorker);
    }
    
    public List<Worker> getActiveWorkerPersis(){
       return workerJpa.getActiveWorker();
    }
    
    public Worker getWorkerByDNIPersis(int dni){
        return workerJpa.findWorkerByDNI(dni);
    }
}
