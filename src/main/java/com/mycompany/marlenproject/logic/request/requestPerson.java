/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.personController;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import java.sql.Timestamp;


public class requestPerson {
    private final personController PersonController = new personController();
    
    public void savePerson(Person newPerson) throws Exception{
        
        String firstName = InputValidator.capitalizedString(newPerson.getFirstName());
        String secondName = (newPerson.getSecondName().isBlank())? null:InputValidator.capitalizedString(newPerson.getSecondName());
        String firstLastName = InputValidator.capitalizedString(newPerson.getFirstLastName());
        String secondLastName = (newPerson.getSecondLastName().isBlank())? null:InputValidator.capitalizedString(newPerson.getSecondLastName());
        String identificationType = InputValidator.capitalizedString(newPerson.getIdentificationType());
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
        
        
        String firstName = InputValidator.capitalizedString(editPerson.getFirstName());
        String secondName = (editPerson.getSecondName().isBlank())? null:InputValidator.capitalizedString(editPerson.getSecondName());
        String firstLastName = InputValidator.capitalizedString(editPerson.getFirstLastName());
        String secondLastName = (editPerson.getSecondLastName().isBlank())? null:InputValidator.capitalizedString(editPerson.getSecondLastName());
        String identificationType = InputValidator.capitalizedString(editPerson.getIdentificationType());
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
    
    public Person getPersonByDNI(String dni){
        return PersonController.getPersonByDNIPersis(dni);
    }
    
}
