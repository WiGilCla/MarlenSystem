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
    
    public void savePerson(String personFirstName, String personSecondName, 
        String personFirstLastName, String personSecondLastName, String personIdentificationType, 
        String personIdentificationNumber, Date personBirthdate) throws Exception{
        
        
        String firstName = checker.capitalizedString(personFirstName);
        String secondName = (personSecondName.isEmpty())? null:checker.capitalizedString(personSecondName);
        String firstLastName = checker.capitalizedString(personFirstLastName);
        String secondLastName = (personSecondLastName.isEmpty())? null:checker.capitalizedString(personSecondLastName);
        String identificationType = checker.capitalizedString(personIdentificationType);
        String identificationNumber = personIdentificationNumber;
        Timestamp birthdate = new Timestamp(personBirthdate.getTime());
        
        
        Person newPerson = new Person(firstName, secondName, firstLastName, secondLastName, identificationType, identificationNumber, birthdate);
        
        
        PersonController.savePersonPersis(newPerson);
    }
    
    public void editPerson(String personIdentificationNumber, String personFirstName, String personSecondName, 
            String personFirstLastName, String personSecondLastName, String personIdentificationType, 
            Date personBirthdate) throws Exception{
        
        
        String firstName = checker.capitalizedString(personFirstName);
        String secondName = (personSecondName.isEmpty())? null:checker.capitalizedString(personSecondName);
        String firstLastName = checker.capitalizedString(personFirstLastName);
        String secondLastName = (personSecondLastName.isEmpty())? null:checker.capitalizedString(personSecondLastName);
        String identificationType = checker.capitalizedString(personIdentificationType);
        String identificationNumber = personIdentificationNumber;
        Timestamp birthdate = new Timestamp(personBirthdate.getTime());
        
        
        Person newPerson = new Person(firstName, secondName, firstLastName, secondLastName, identificationType, identificationNumber, birthdate);
        
        PersonController.editPersonPersis(newPerson);
    }
    
    public void deletePerson(String personId) throws NonexistentEntityException{
        PersonController.deletePersonPersis(personId);
    }
    
}
