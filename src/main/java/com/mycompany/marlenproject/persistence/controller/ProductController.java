/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.persistence.controller;

import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.persistence.ProductJpaController;
import java.util.List;


public class ProductController {
    ProductJpaController productJpaController = new ProductJpaController();
    
    public void saveProductPersis(Product newProduct){
       productJpaController.create(newProduct);
    }
    
    public void editProductPersis(Product editProduct) throws Exception{
        productJpaController.edit(editProduct);
    }
    
    public void deleteProductPersis(int ProductId)throws Exception{
        productJpaController.destroy(ProductId);
    }
    
    public List<Product> getAllProductPersis(){
        return productJpaController.findProductEntities();
    }
}
