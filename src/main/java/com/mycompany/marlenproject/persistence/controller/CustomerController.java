/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.persistence.CustomerJpaController;
import java.util.List;


public class CustomerController {
    CustomerJpaController customerJpaController = new CustomerJpaController();
    
    public void saveCustomerPersis(Customer newCustomer){
        customerJpaController.create(newCustomer);
    }
    
    public void editCustomerPersis(Customer editCustomer) throws Exception{
        customerJpaController.edit(editCustomer);
    }
    
    public void deleteCustomerPersis(int idCustomer) throws Exception{
        customerJpaController.destroy(idCustomer);
    }
    
    public List<Customer> getCustomerPersis(){
        return customerJpaController.findCustomerEntities();
    }
    
    public List<Customer> getNoDeletedCustomerPersis(){
       return customerJpaController.getNodeletedCustomer();
    }
    
    public Customer getCustomerByDNIPersis(String dni){
        return customerJpaController.findCustomerByDNI(dni);
    }
    
    
}
