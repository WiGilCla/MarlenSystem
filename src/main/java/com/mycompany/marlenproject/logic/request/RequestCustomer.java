/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.utils.fields.CheckFields;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.persistence.controller.CustomerController;
import java.util.ArrayList;
import java.util.List;

public class RequestCustomer {
    private final CustomerController customerController = new CustomerController();
    private final CheckFields CHECKER = new CheckFields();
    
    public void saveCustomer(Customer newCustomer){
        
        String customerAddress = ((newCustomer.getAddress().isBlank())? null:CHECKER.capitalizedString(newCustomer.getAddress()));
        String customerEmail = ((newCustomer.getEmail().isBlank())? null:newCustomer.getEmail().toLowerCase());
        String customerPhone = ((newCustomer.getPhone().isBlank())? null: newCustomer.getPhone());
        
        newCustomer.setAddress(customerAddress);
        newCustomer.setEmail(customerEmail);
        newCustomer.setPhone(customerPhone);
        
        customerController.saveCustomerPersis(newCustomer);
    }
    
    public void editCustomer(Customer editCustomer) throws Exception{
        
        String customerAddress = ((editCustomer.getAddress().isBlank())? null:CHECKER.capitalizedString(editCustomer.getAddress()));
        String customerEmail = ((editCustomer.getEmail().isBlank())? null:editCustomer.getEmail().toLowerCase());
        String customerPhone = ((editCustomer.getPhone().isBlank())? null: editCustomer.getPhone());
        
        editCustomer.setAddress(customerAddress);
        editCustomer.setEmail(customerEmail);
        editCustomer.setPhone(customerPhone);
        
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
