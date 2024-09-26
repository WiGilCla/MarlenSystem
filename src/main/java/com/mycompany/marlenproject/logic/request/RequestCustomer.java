/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.persistence.controller.CustomerController;
import java.util.ArrayList;
import java.util.List;

public class RequestCustomer {
    private final CustomerController customerController = new CustomerController();
    private final CheckFields CHECKER = new CheckFields();
    
    public void saveCustomer(Customer newCustomer){
        
        String customerAddress = CHECKER.capitalizedString(newCustomer.getAddress());
        String customerEmail = newCustomer.getEmail().toLowerCase();
        
        newCustomer.setAddress(customerAddress);
        newCustomer.setEmail(customerEmail);
        
        customerController.saveCustomerPersis(newCustomer);
    }
    
    public void editCustomer(Customer editCustomer) throws Exception{
        
        String customerEmail = editCustomer.getEmail().toLowerCase();
        editCustomer.setEmail(customerEmail);
        
        customerController.editCustomerPersis(editCustomer);
    }
    
    public List<Customer> getCustomerList(){
        List<Customer> customerList = new ArrayList<>();
        List<Customer> bdCustomerList = customerController.getCustomerPersis();
        return (bdCustomerList == null)? customerList : bdCustomerList;
    }
    
    public List<Customer> getNoDeleteCustomer(){
        List<Customer> customerList = new ArrayList<>();
        List<Customer> bdCustomerList = customerController.getNoDeletedCustomerPersis();
        return (bdCustomerList == null)? customerList : bdCustomerList;
    }
    public Customer getCustomerByDNI(String dni){
        return customerController.getCustomerByDNIPersis(dni);
    }
    
    public void deleteCustomer(int customerId) throws Exception{
        customerController.deleteCustomerPersis(customerId);
    }
}
