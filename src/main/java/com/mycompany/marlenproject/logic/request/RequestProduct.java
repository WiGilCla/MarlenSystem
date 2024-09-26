/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.persistence.controller.ProductController;
import java.util.ArrayList;
import java.util.List;


public class RequestProduct {
    private final ProductController productController = new ProductController();
    private final CheckFields CHECKER = new CheckFields();
    
    public void saveProduct(Product newProduct){
        String productName = CHECKER.capitalizedString(newProduct.getName());
        String productDescription = CHECKER.capitalizedString(newProduct.getDescription());
        
        newProduct.setName(productName);
        newProduct.setDescription(productDescription);
        
        productController.saveProductPersis(newProduct);
    }
    
    public void editProduct(Product editProduct) throws Exception{
        String productName = CHECKER.capitalizedString(editProduct.getName());
        String productDescription = CHECKER.capitalizedString(editProduct.getDescription());
        
        editProduct.setName(productName);
        editProduct.setDescription(productDescription);
        
        productController.editProductPersis(editProduct);
    }
    
    public void deteleProduct(Product deleteProduct) throws Exception{
        productController.deleteProductPersis(deleteProduct.getId());
    }
    
    public List<Product> getAllProducts(){
        
        List<Product> productList = new ArrayList<>();
        List<Product> bdProductlist = productController.getAllProductPersis();
        
        return (bdProductlist == null)? productList:bdProductlist;
    }
    
}
