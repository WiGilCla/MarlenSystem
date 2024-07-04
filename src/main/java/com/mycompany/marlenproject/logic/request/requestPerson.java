/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.personController;

/**
 *
 * @author willy
 */
public class requestPerson {
    private personController PersonController = new personController();
    private CheckFields checker = new CheckFields();
    
    public void savePerson(String personFirstName, String personSecondName, 
            String personFirstLastName, String personSecondLastName, String personIdentificationType, 
            String personIdentificationNumber, String personAge) throws Exception{
        
        String firstName = checker.capitalizedString(personFirstName);
        String secondName = checker.capitalizedString(personSecondName);
        String firstLastName = checker.capitalizedString(personFirstLastName);
        String secondLastName = checker.capitalizedString(personSecondLastName);
        String identificationType = checker.capitalizedString(personIdentificationType);
        String identificationNumber = personIdentificationNumber;
        String age = personAge;
        
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
