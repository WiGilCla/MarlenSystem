/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.personController;
import java.util.Date;

/**
 *
 * @author willy
 */
public class requestPerson {
    private final personController PersonController = new personController();
    private final CheckFields checker = new CheckFields();
    
    public void savePerson(String personFirstName, String personSecondName, 
            String personFirstLastName, String personSecondLastName, String personIdentificationType, 
            String personIdentificationNumber, Date birthdate) throws Exception{
        
        String firstName = checker.capitalizedString(personFirstName);
        String secondName = (personSecondName.isEmpty())? null:checker.capitalizedString(personSecondName);
        String firstLastName = checker.capitalizedString(personFirstLastName);
        String secondLastName = (personSecondLastName.isEmpty())? null:checker.capitalizedString(personSecondLastName);
        String identificationType = checker.capitalizedString(personIdentificationType);
        int identificationNumber = Integer.parseInt( personIdentificationNumber);
        Date age = new java.sql.Date(birthdate.getTime()) ;
        
        System.out.println(firstName);
        System.out.println(secondName);
        System.out.println(firstLastName);
        System.out.println(secondLastName);
        System.out.println(identificationType);
        System.out.println(identificationNumber);
        System.out.println(age);
        
        Person newPerson = new Person(firstName, secondName, firstLastName, secondLastName, identificationType, identificationNumber, age);
        
        PersonController.savePersonPersis(newPerson);
    }
    
}
