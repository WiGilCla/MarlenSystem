/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.persistence.controller.ProductController;
import java.util.ArrayList;
import java.util.List;


public class RequestProduct {
    private final ProductController productController = new ProductController();
    
    public void saveProduct(Product newProduct){
        String productName = InputValidator.capitalizedString(newProduct.getName());
        String productDescription = InputValidator.capitalizedString(newProduct.getDescription());
        
        newProduct.setName(productName);
        newProduct.setDescription(productDescription);
        
        productController.saveProductPersis(newProduct);
    }
    
    public void editProduct(Product editProduct) throws Exception{
        String productName = InputValidator.capitalizedString(editProduct.getName());
        String productDescription = InputValidator.capitalizedString(editProduct.getDescription());
        
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
