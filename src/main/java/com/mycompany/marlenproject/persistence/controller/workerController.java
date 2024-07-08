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
         workerJpa.create(newWorker);
    }
    
    public List<Worker> getWorkersPersis(){
        return workerJpa.findWorkerEntities();
    }
}
