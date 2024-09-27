/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.personController;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import java.sql.Timestamp;
import java.util.Date;


public class requestPerson {
    private final personController PersonController = new personController();
    private final CheckFields checker = new CheckFields();
    
    public void savePerson(Person newPerson) throws Exception{
        
        String firstName = checker.capitalizedString(newPerson.getFirstName());
        String secondName = (newPerson.getSecondName().isEmpty())? null:checker.capitalizedString(newPerson.getSecondName());
        String firstLastName = checker.capitalizedString(newPerson.getFirstLastName());
        String secondLastName = (newPerson.getSecondLastName().isEmpty())? null:checker.capitalizedString(newPerson.getSecondLastName());
        String identificationType = checker.capitalizedString(newPerson.getIdentificationType());
        Timestamp birthdate = (newPerson.getBirthdate() != null)? new Timestamp(newPerson.getBirthdate().getTime()): null;
        
        newPerson.setFirstName(firstName);
        newPerson.setSecondName(secondName);
        newPerson.setFirstLastName(firstLastName);
        newPerson.setSecondLastName(secondLastName);
        newPerson.setIdentificationType(identificationType);
        newPerson.setBirthdate(birthdate);
        
        PersonController.savePersonPersis(newPerson);
    }
    
    public void editPerson(Person editPerson) throws Exception{
        
        
        String firstName = checker.capitalizedString(editPerson.getFirstName());
        String secondName = (editPerson.getSecondName().isEmpty())? null:checker.capitalizedString(editPerson.getSecondName());
        String firstLastName = checker.capitalizedString(editPerson.getFirstLastName());
        String secondLastName = (editPerson.getSecondLastName().isEmpty())? null:checker.capitalizedString(editPerson.getSecondLastName());
        String identificationType = checker.capitalizedString(editPerson.getIdentificationType());
        Timestamp birthdate = (editPerson.getBirthdate() != null)? new Timestamp(editPerson.getBirthdate().getTime()): null;
        
        editPerson.setFirstName(firstName);
        editPerson.setSecondName(secondName);
        editPerson.setFirstLastName(firstLastName);
        editPerson.setSecondLastName(secondLastName);
        editPerson.setIdentificationType(identificationType);
        editPerson.setBirthdate(birthdate);
        
        PersonController.editPersonPersis(editPerson);
    }
    
    public void deletePerson(String personId) throws NonexistentEntityException{
        PersonController.deletePersonPersis(personId);
    }
    
}
