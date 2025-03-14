/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.ProductsSection;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.logic.request.RequestProduct;
import com.mycompany.marlenproject.utils.colors.Colors;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
public class AddProductView extends javax.swing.JPanel {

    public AddProductView() {
        initComponents();
    }
    
    private boolean checkRequiredField() {
        String productName = InputValidator.removeStringBlanks(txtProductName.getText());
        if (productName.isBlank()) {
            txtProductName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe dar un nombre al producto.", "Producto sin nombre", 1);
            return false;
        }
        if (!productName.isBlank() && !InputValidator.checkStringField(productName)) {
            txtProductName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTxtField(this, null, null, null);
            return false;
        }

        return true;
    }
    
    private boolean checkNoRequiredField() {
        String productDescription = InputValidator.removeStringBlanks(txtADescriptionProduct.getText());

        if (!productDescription.isBlank() && !InputValidator.checkStringTextArea(productDescription)) {
            txtADescriptionProduct.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTextArea(this, null, null, null);
            return false;
        }

        return true;
    }
    
    private void clearFields(){
        txtProductName.setText("");
        txtADescriptionProduct.setText("");
        txtProductName.setBackground(Colors.NormalColorFields());
        txtADescriptionProduct.setBackground(Colors.NormalColorFields());
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
        btnClearFields = new javax.swing.JButton();

        setBackground(Colors.PRIMARY_200);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_950)); // NOI18N

        PanelProductName.setBackground(Colors.PRIMARY_200);

        lbProductName.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        lbProductName.setText("Nombre del producto:");

        txtProductName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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
                .addContainerGap(193, Short.MAX_VALUE))
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

        PanelProductDescription.setBackground(Colors.PRIMARY_200);

        txtADescriptionProduct.setColumns(20);
        txtADescriptionProduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelProductDescriptionLayout.setVerticalGroup(
            PanelProductDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelButtons.setBackground(Colors.PRIMARY_200);

        btnSave.setBackground(Colors.PRIMARY_400);
        btnSave.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnSave.setForeground(Colors.PRIMARY_950);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setPreferredSize(new java.awt.Dimension(150, 60));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClearFields.setBackground(Colors.PRIMARY_400);
        btnClearFields.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnClearFields.setForeground(Colors.PRIMARY_950);
        btnClearFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconDelete.png"))); // NOI18N
        btnClearFields.setText("Limpiar");
        btnClearFields.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClearFields.setPreferredSize(new java.awt.Dimension(150, 60));
        btnClearFields.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonsLayout = new javax.swing.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelButtonsLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearFields, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(PanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelProductName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelProductDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(PanelProductDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusGained
        txtProductName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtProductNameFocusGained

    private void txtADescriptionProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtADescriptionProductFocusGained
        txtADescriptionProduct.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtADescriptionProductFocusGained

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkRequiredField() && checkNoRequiredField()) {
            try {
                RequestProduct requestProduct = new RequestProduct();

                String productName = txtProductName.getText();
                String productDescription = txtADescriptionProduct.getText();

                Product newProduct = new Product(productName, productDescription);
                requestProduct.saveProduct(newProduct);
                JPaneMessage.messageDialog(this, "El producto se ha guardado existosamente.", "Guardado exitoso", 1);
                clearFields();
            } catch (Exception ex) {
                JPaneMessage.messageDialog(this, "Ha ocurrido un error durante el guardado de producto", "Error de guardado", 0);

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearFieldsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelProductDescription;
    private javax.swing.JPanel PanelProductName;
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JTextArea txtADescriptionProduct;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
