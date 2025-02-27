/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.ProductsSection;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.logic.request.RequestProduct;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.List;
import javax.swing.JOptionPane;

public class AddProductView extends javax.swing.JFrame {

    private final AdminHome PRINCIPALFRAME;

    public AddProductView(AdminHome principalFrame) {
        this.PRINCIPALFRAME = principalFrame;
        initComponents();
        setResizable(false);
        setTitle("Agregar nuevo producto");
    }

    private boolean checkRequiredField() {
        String productName = InputValidator.removeStringBlanks(txtProductName.getText());
        if (productName.isBlank()) {
            txtProductName.setBackground(Colors.IncorrectColorFields());
            JOptionPane.showMessageDialog(this, "Debe dar un nombre al producto", "Campo requerido", 2);
            return false;
        }
        if (!productName.isBlank() && !InputValidator.checkStringField(productName)) {
            txtProductName.setBackground(Colors.IncorrectColorFields());
            JOptionPane.showMessageDialog(this, "Debe usar carácteres válidos", "Carácter no válido", 2);
            return false;
        }

        return true;
    }

    private boolean checkNoRequiredField() {
        String productDescription = InputValidator.removeStringBlanks(txtADescriptionProduct.getText());

        if (!productDescription.isBlank() && !InputValidator.checkStringTextArea(productDescription)) {
            txtADescriptionProduct.setBackground(Colors.IncorrectColorFields());
            JOptionPane.showMessageDialog(this, "No debe usar caracteres especiales", "Carácter no válido", 2);
            return false;
        }

        return true;
    }

    private void backProductListView() {
        List<Product> productList = new RequestProduct().getAllProducts();
        ProductView productView = new ProductView(PRINCIPALFRAME, productList);
        this.dispose();
        PRINCIPALFRAME.replacePanel(productView);
        PRINCIPALFRAME.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProductName = new javax.swing.JPanel();
        lbProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        PanelProductDescription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescriptionProduct = new javax.swing.JTextArea();
        PanelButtons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelProductName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbProductName.setText("Nombre del producto:");
        lbProductName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductNameFocusGained(evt);
            }
        });

        javax.swing.GroupLayout PanelProductNameLayout = new javax.swing.GroupLayout(PanelProductName);
        PanelProductName.setLayout(PanelProductNameLayout);
        PanelProductNameLayout.setHorizontalGroup(
            PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProductNameLayout.setVerticalGroup(
            PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelProductDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtADescriptionProduct.setColumns(20);
        txtADescriptionProduct.setRows(5);
        txtADescriptionProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtADescriptionProductFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(txtADescriptionProduct);

        javax.swing.GroupLayout PanelProductDescriptionLayout = new javax.swing.GroupLayout(PanelProductDescription);
        PanelProductDescription.setLayout(PanelProductDescriptionLayout);
        PanelProductDescriptionLayout.setHorizontalGroup(
            PanelProductDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelProductDescriptionLayout.setVerticalGroup(
            PanelProductDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setPreferredSize(new java.awt.Dimension(150, 60));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonsLayout = new javax.swing.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProductName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProductDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProductDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        PRINCIPALFRAME.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkRequiredField() && checkNoRequiredField()) {
            try {
                RequestProduct requestProduct = new RequestProduct();

                String productName = txtProductName.getText();
                String productDescription = txtADescriptionProduct.getText();

                Product newProduct = new Product(productName, productDescription);
                requestProduct.saveProduct(newProduct);
                JOptionPane.showMessageDialog(this, "Se ha guardado el producto con exito.", "Operación exitosa", 1);
                backProductListView();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error durante el guardado de producto", "Error de guardado", 0);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusGained
        txtProductName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtProductNameFocusGained

    private void txtADescriptionProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtADescriptionProductFocusGained
        txtADescriptionProduct.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtADescriptionProductFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelProductDescription;
    private javax.swing.JPanel PanelProductName;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JTextArea txtADescriptionProduct;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
