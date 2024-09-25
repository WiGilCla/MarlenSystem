/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic.request;

import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.persistence.controller.ProductController;
import java.util.ArrayList;
import java.util.List;


public class RequestProduct {
    ProductController productController = new ProductController();
    
    public void saveProduct(Product newProduct){
        productController.saveProductPersis(newProduct);
    }
    
    public void editProduct(Product editProduct) throws Exception{
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
