/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.persistence.controller.CustomerController;
import java.util.List;

public class RequestCustomer {
    CustomerController customerController = new CustomerController();
    
    public void saveCustomer(Person person, String phone, String address, String email, boolean isDelete){
        String customerPhone = phone;
        String customerAddress = address;
        String customerEmail = email;
        boolean customerIsDelete = isDelete;
        
        Customer newCustomer = new Customer(customerPhone, customerAddress, 
                customerEmail, customerIsDelete, person);
        
        customerController.saveCustomerPersis(newCustomer);
    }
    
    public void editCustomer(Customer editCustomer) throws Exception{
        
        String customerEmail = editCustomer.getEmail().toLowerCase();
        
        Customer newCustomer = new Customer(editCustomer.getPhone(),editCustomer.getAddress(), 
                customerEmail, editCustomer.isIsDelete(), editCustomer.getPerson());
        
        customerController.editCustomerPersis(newCustomer);
    }
    
    public List<Customer> getCustomerList(){
        return customerController.getCustomerPersis();
    }
    
    public Customer getCustomerByDNI(String dni){
        return customerController.getCustomerByDNIPersis(dni);
    }
}
