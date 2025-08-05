/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.Controlador;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelos.Producto;
import shared.Result;

/**
 *
 * @author Mati
 */
public class GestionProductos extends javax.swing.JFrame {

    private final Controlador controlador;
    private Producto productToEdit = null;
    private boolean tableModified = false;

    public GestionProductos(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
        cargarTabla();
    }

    private void cargarTabla() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] campos = {"ID", "Nombre", "Precio"};

        model.setColumnIdentifiers(campos);

        Result<List<Producto>> res = controlador.getAllProducts();

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener los productos :(");
            return;
        }

        for (Producto p : res.getValue()) {
            Object[] row = {
                p.getId().getValue(),
                p.getNombre().getValue(),
                p.getPrecio().getValue()
            };
            model.addRow(row);
        }

        this.products_table.setModel(model);
        this.products_table.setCellSelectionEnabled(false);
        this.products_table.setDragEnabled(false);
        this.products_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo una fila a la vez
        this.products_table.setRowSelectionAllowed(true);
    }

    private void cambiarVista(String vista) {
        CardLayout cl = (CardLayout) this.mainLayout.getLayout();
        cl.show(this.mainLayout, vista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLayout = new javax.swing.JPanel();
        products_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        products_table_container = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        goToCreate_btn = new javax.swing.JButton();
        goToEdit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        goToMainMenu_btn = new javax.swing.JButton();
        create_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        product_name_label = new javax.swing.JLabel();
        product_name_field = new javax.swing.JTextField();
        price_label = new javax.swing.JLabel();
        create_error_label = new javax.swing.JLabel();
        create_btn = new javax.swing.JButton();
        goBack_btn = new javax.swing.JLabel();
        price_field = new javax.swing.JTextField();
        edit_panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        id_field = new javax.swing.JTextField();
        product_name_label1 = new javax.swing.JLabel();
        product_name_edit_field = new javax.swing.JTextField();
        price_label1 = new javax.swing.JLabel();
        edit_error_label = new javax.swing.JLabel();
        edit_btn = new javax.swing.JButton();
        goBack_btn1 = new javax.swing.JLabel();
        price_edit_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLayout.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Productos");

        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        products_table_container.setViewportView(products_table);

        goToCreate_btn.setText("Crear Producto");
        goToCreate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToCreate_btnActionPerformed(evt);
            }
        });

        goToEdit_btn.setText("Editar");
        goToEdit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToEdit_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Eliminar");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        goToMainMenu_btn.setText("Menu Principal");
        goToMainMenu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMainMenu_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout products_panelLayout = new javax.swing.GroupLayout(products_panel);
        products_panel.setLayout(products_panelLayout);
        products_panelLayout.setHorizontalGroup(
            products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(products_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addComponent(products_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goToCreate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goToMainMenu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goToEdit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        products_panelLayout.setVerticalGroup(
            products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(products_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(products_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(products_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(products_panelLayout.createSequentialGroup()
                        .addComponent(goToCreate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goToEdit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goToMainMenu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        mainLayout.add(products_panel, "products_view");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Crear Producto");

        product_name_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        product_name_label.setText("Nombre");

        price_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        price_label.setText("Precio");

        create_error_label.setForeground(new java.awt.Color(255, 102, 102));
        create_error_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        create_error_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        create_btn.setText("Crear");
        create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnActionPerformed(evt);
            }
        });

        goBack_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goBack_btn.setText("Volver");
        goBack_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBack_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack_btnMouseClicked(evt);
            }
        });

        price_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price_fieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout create_panelLayout = new javax.swing.GroupLayout(create_panel);
        create_panel.setLayout(create_panelLayout);
        create_panelLayout.setHorizontalGroup(
            create_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(create_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product_name_label)
                    .addComponent(jLabel2)
                    .addComponent(price_label)
                    .addComponent(create_error_label, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(create_panelLayout.createSequentialGroup()
                        .addComponent(create_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goBack_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(create_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(price_field, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(product_name_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        create_panelLayout.setVerticalGroup(
            create_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(product_name_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(price_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(create_error_label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(create_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBack_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        mainLayout.add(create_panel, "create_view");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Editar Producto");

        id_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id_label.setText("ID");

        id_field.setEditable(false);
        id_field.setEnabled(false);

        product_name_label1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        product_name_label1.setText("Nombre");

        price_label1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        price_label1.setText("Precio");

        edit_error_label.setForeground(new java.awt.Color(255, 102, 102));
        edit_error_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        edit_error_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        edit_btn.setText("Editar");
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });

        goBack_btn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goBack_btn1.setText("Volver");
        goBack_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBack_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBack_btn1MouseClicked(evt);
            }
        });

        price_edit_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price_edit_fieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout edit_panelLayout = new javax.swing.GroupLayout(edit_panel);
        edit_panel.setLayout(edit_panelLayout);
        edit_panelLayout.setHorizontalGroup(
            edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_label)
                    .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product_name_label1)
                    .addComponent(jLabel4)
                    .addComponent(price_label1)
                    .addComponent(edit_error_label, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(edit_panelLayout.createSequentialGroup()
                        .addComponent(edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goBack_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(price_edit_field, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(product_name_edit_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        edit_panelLayout.setVerticalGroup(
            edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(id_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(product_name_label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_name_edit_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(price_label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(price_edit_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(edit_error_label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBack_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        mainLayout.add(edit_panel, "edit_view");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToCreate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToCreate_btnActionPerformed
        cambiarVista("create_view");
    }//GEN-LAST:event_goToCreate_btnActionPerformed

    private void goToEdit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToEdit_btnActionPerformed
        //obtener el producto a editar
        int rowIndex = this.products_table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para editarlo");
            return;
        }

        String id = (String) this.products_table.getValueAt(rowIndex, 0);

        Result<Producto> res = controlador.getProductoById(id);

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }

        productToEdit = res.getValue();

        cargarDatosAEditar();

        cambiarVista("edit_view");
    }//GEN-LAST:event_goToEdit_btnActionPerformed

    private void cargarDatosAEditar() {
        this.product_name_edit_field.setText(productToEdit.getNombre().getValue());
        this.id_field.setText(productToEdit.getId().getValue());
        this.price_edit_field.setText(String.valueOf(productToEdit.getPrecio().getValue()));
    }

    private void volverAlMenuPrincipal() {
        if (tableModified) {
            cargarTabla();
            this.tableModified = false;
        }
        cambiarVista("products_view");
    }

    private void goBack_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_btnMouseClicked
        volverAlMenuPrincipal();
    }//GEN-LAST:event_goBack_btnMouseClicked

    private void goBack_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBack_btn1MouseClicked
        volverAlMenuPrincipal();
    }//GEN-LAST:event_goBack_btn1MouseClicked

    private void goToMainMenu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMainMenu_btnActionPerformed
        MenuPrincipal mp = new MenuPrincipal(controlador);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_goToMainMenu_btnActionPerformed

    private void create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnActionPerformed
        String nombre = this.product_name_field.getText();
        String precioStr = this.price_field.getText();
        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            this.create_error_label.setText("Debe ingresar un precio valido.");
            return;
        }

        Result<Void> res = controlador.createProducto(nombre, precio);

        if (!res.isOk()) {
            this.create_error_label.setText(res.getError());
            System.out.println("Hubo un error: " + res.getError());
            return;
        }

        this.tableModified = true;
        JOptionPane.showMessageDialog(this, "Prodcto creado!");

        product_name_field.setText("");
        price_field.setText("");
    }//GEN-LAST:event_create_btnActionPerformed

    private void validarIngresoPrecio(KeyEvent evt) {
        char evtChar = evt.getKeyChar();

        /**
         * Ignora si: - Ingresa algo que no es un numero - Si presiona una tecla
         * distinta de BackSpace (borrar) - Si es distinto de un punto - Si el
         * campo ya contiene un punto
         */
        if ((evtChar < '0' || evtChar > '9')
                && (evtChar != KeyEvent.VK_BACK_SPACE)
                && (evtChar != '.' || price_field.getText().contains("."))) {
            evt.consume();
        }
    }

    private void price_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price_fieldKeyTyped
        validarIngresoPrecio(evt);
    }//GEN-LAST:event_price_fieldKeyTyped

    private void price_edit_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price_edit_fieldKeyTyped
        validarIngresoPrecio(evt);
    }//GEN-LAST:event_price_edit_fieldKeyTyped

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        String nombreEditado = product_name_edit_field.getText();
        String precioEditadoStr = price_edit_field.getText();
        double precioEditado;

        try {
            precioEditado = Double.parseDouble(precioEditadoStr);
        } catch (NumberFormatException e) {
            this.create_error_label.setText("Debe ingresar un precio valido.");
            return;
        }

        String id = id_field.getText();

        Result<Void> res = controlador.updateProduct(id, nombreEditado, precioEditado);

        if (!res.isOk()) {
            this.edit_error_label.setText(res.getError());
            System.out.println("Hubo un error: " + res.getError());
            return;
        }

        this.tableModified = true;
        JOptionPane.showMessageDialog(this, "Prodcto editado!");
    }//GEN-LAST:event_edit_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int rowIndex = this.products_table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para eliminarlo");
            return;
        }

        String id = (String) this.products_table.getValueAt(rowIndex, 0);
        
        int option = JOptionPane.showConfirmDialog(this
                , "Esta seguro que desea eliminar el producto con id '"+id+"'?"
                , "Advertencia"
                , JOptionPane.YES_NO_OPTION);
        
        if(option == JOptionPane.NO_OPTION){
            return;
        }
        
        Result<Producto> res = controlador.deleteProduct(id);
        
        if(!res.isOk()){
            System.out.println("Hubo un error: " + res.getError());
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }
        
        cargarTabla();
    }//GEN-LAST:event_delete_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_btn;
    private javax.swing.JLabel create_error_label;
    private javax.swing.JPanel create_panel;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JLabel edit_error_label;
    private javax.swing.JPanel edit_panel;
    private javax.swing.JLabel goBack_btn;
    private javax.swing.JLabel goBack_btn1;
    private javax.swing.JButton goToCreate_btn;
    private javax.swing.JButton goToEdit_btn;
    private javax.swing.JButton goToMainMenu_btn;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainLayout;
    private javax.swing.JTextField price_edit_field;
    private javax.swing.JTextField price_field;
    private javax.swing.JLabel price_label;
    private javax.swing.JLabel price_label1;
    private javax.swing.JTextField product_name_edit_field;
    private javax.swing.JTextField product_name_field;
    private javax.swing.JLabel product_name_label;
    private javax.swing.JLabel product_name_label1;
    private javax.swing.JPanel products_panel;
    private javax.swing.JTable products_table;
    private javax.swing.JScrollPane products_table_container;
    // End of variables declaration//GEN-END:variables
}
