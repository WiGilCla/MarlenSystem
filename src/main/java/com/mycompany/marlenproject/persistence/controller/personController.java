/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.PersonJpaController;

/**
 *
 * @author willy
 */
public class personController {
    PersonJpaController personJpa = new PersonJpaController();
    public void savePersonPersis(Person newPersona) throws Exception{
         personJpa.create(newPersona);
    }
}
