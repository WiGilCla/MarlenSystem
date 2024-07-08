/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.personController;
import java.sql.Time;
import java.sql.Timestamp;
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
        String personIdentificationNumber, Date personBirthdate) throws Exception{
        
        System.out.println("Nombre persona: ".concat(personFirstName));
        System.out.println("Segundo Nombre persona: ".concat(personSecondName));
        System.out.println("Apellido persona: ".concat(personFirstLastName));
        System.out.println("Segundo Apellido persona: ".concat(personSecondLastName));
        System.out.println("Tipo identificación persona: ".concat(personIdentificationType));
        System.out.println("Numero identificación persona: ".concat(personIdentificationNumber));
        System.out.println("Nacimiento persona: ".concat(String.valueOf(personBirthdate.toString())));
        
        String firstName = checker.capitalizedString(personFirstName);
        String secondName = (personSecondName.isEmpty())? null:checker.capitalizedString(personSecondName);
        String firstLastName = checker.capitalizedString(personFirstLastName);
        String secondLastName = (personSecondLastName.isEmpty())? null:checker.capitalizedString(personSecondLastName);
        String identificationType = checker.capitalizedString(personIdentificationType);
        int identificationNumber = Integer.parseInt( personIdentificationNumber);
        
        Timestamp birthdate = new Timestamp(personBirthdate.getTime());
        
        Person newPerson = new Person(firstName, secondName, firstLastName, secondLastName, identificationType, identificationNumber, birthdate);
        
        PersonController.savePersonPersis(newPerson);
    }
    
}
