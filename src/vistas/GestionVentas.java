/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.Controlador;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import modelos.ProductoVenta;
import modelos.Venta;
import shared.Result;

/**
 *
 * @author Mati
 */
public class GestionVentas extends javax.swing.JFrame {

    private final Controlador controlador;
    private List<Venta> ventasItems;
    private Venta ventaSelected = null;

    public GestionVentas(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
        cargarVentas();
        cargarTabla();
    }
    
    private void cargarTablaDetalles(){
        if(ventaSelected == null) return;
        
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] campos = {"ID", "Nombre", "Precio", "Cantidad", "Total"};

        model.setColumnIdentifiers(campos);
        List<ProductoVenta> list = ventaSelected.getProductos();
        System.out.println("list = " + list);
        
        for (ProductoVenta p : list) {
            Object[] row = {
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCantidad(),
                p.calcularTotal()
            };
            model.addRow(row);
        }

        this.details_table.setModel(model);
        this.details_table.setCellSelectionEnabled(false);
        this.details_table.setDragEnabled(false); // Solo una fila a la vez
        this.details_table.setRowSelectionAllowed(false);
    }

    private void cargarVentas() {
        Result<List<Venta>> res = controlador.getAllVentas();

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener las ventas :(");
            return;
        }

        this.ventasItems = res.getValue();
    }

    private void cargarTabla() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] campos = {"ID", "Fecha", "Total"};

        model.setColumnIdentifiers(campos);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Venta p : ventasItems) {
            Object[] row = {
                p.getId().getValue(),
                formatter.format(p.getFechaVenta().getValue()),
                p.getTotal()
            };
            model.addRow(row);
        }

        this.ventas_table.setModel(model);
        this.ventas_table.setCellSelectionEnabled(false);
        this.ventas_table.setDragEnabled(false);
        this.ventas_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo una fila a la vez
        this.ventas_table.setRowSelectionAllowed(true);
    }

    private void filtrarVentasPorFecha(LocalDate fecha) {
        System.out.println(fecha);
        Result<List<Venta>> res = controlador.getVentasByFecha(fecha);
        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }

        this.ventasItems = res.getValue();
        System.out.println("Filtrado: " + res.getValue());
        cargarTabla();
    }

    private void cambiarVista(String vista) {
        CardLayout cl = (CardLayout) this.mainLayout.getLayout();
        cl.show(this.mainLayout, vista);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLayout = new javax.swing.JPanel();
        ventas_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ventas_table_container = new javax.swing.JScrollPane();
        ventas_table = new javax.swing.JTable();
        seeDetails_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        goToMainMenu_btn = new javax.swing.JButton();
        fecha_filtro_field = new javax.swing.JFormattedTextField();
        apply_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        quitar_filtro_btn = new javax.swing.JButton();
        details_panel = new javax.swing.JPanel();
        details_table_container = new javax.swing.JScrollPane();
        details_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total_show = new javax.swing.JLabel();
        fecha_show = new javax.swing.JLabel();
        id_show = new javax.swing.JLabel();
        goToVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLayout.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Ventas");

        ventas_table.setModel(new javax.swing.table.DefaultTableModel(
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
        ventas_table_container.setViewportView(ventas_table);

        seeDetails_btn.setText("Ver detalles");
        seeDetails_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeDetails_btnActionPerformed(evt);
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

        fecha_filtro_field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        fecha_filtro_field.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        fecha_filtro_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_filtro_fieldActionPerformed(evt);
            }
        });

        apply_btn.setText("Aplicar");
        apply_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apply_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar por fecha");

        quitar_filtro_btn.setText("Quitar filtro");
        quitar_filtro_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitar_filtro_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ventas_panelLayout = new javax.swing.GroupLayout(ventas_panel);
        ventas_panel.setLayout(ventas_panelLayout);
        ventas_panelLayout.setHorizontalGroup(
            ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventas_panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ventas_panelLayout.createSequentialGroup()
                        .addComponent(ventas_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(delete_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seeDetails_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(goToMainMenu_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(quitar_filtro_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ventas_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_filtro_field, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apply_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        ventas_panelLayout.setVerticalGroup(
            ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventas_panelLayout.createSequentialGroup()
                .addGroup(ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventas_panelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apply_btn)
                            .addComponent(fecha_filtro_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(ventas_panelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(ventas_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ventas_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventas_panelLayout.createSequentialGroup()
                        .addComponent(quitar_filtro_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seeDetails_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goToMainMenu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        mainLayout.add(ventas_panel, "ventas_view");

        details_table.setModel(new javax.swing.table.DefaultTableModel(
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
        details_table.setEnabled(false);
        details_table_container.setViewportView(details_table);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Detalles");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Total:");

        total_show.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fecha_show.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        id_show.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        goToVentas.setText("Volver");
        goToVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout details_panelLayout = new javax.swing.GroupLayout(details_panel);
        details_panel.setLayout(details_panelLayout);
        details_panelLayout.setHorizontalGroup(
            details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(details_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(details_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(details_panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id_show, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total_show, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(details_panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_show, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goToVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        details_panelLayout.setVerticalGroup(
            details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_show, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(details_panelLayout.createSequentialGroup()
                        .addGroup(details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(total_show, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(details_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(details_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToVentas)
                .addGap(12, 12, 12))
        );

        mainLayout.add(details_panel, "details_view");

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

    private void goToMainMenu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMainMenu_btnActionPerformed
        MenuPrincipal mp = new MenuPrincipal(controlador);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_goToMainMenu_btnActionPerformed

    private void apply_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apply_btnActionPerformed

        String dateText = fecha_filtro_field.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate dateFilter = LocalDate.parse(dateText, formatter);
            filtrarVentasPorFecha(dateFilter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Fecha invalida, porfavor use el formato dd/MM/yyyy.");
        }


    }//GEN-LAST:event_apply_btnActionPerformed

    private void fecha_filtro_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_filtro_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_filtro_fieldActionPerformed

    private void goToVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToVentasActionPerformed
        cambiarVista("ventas_view");
    }//GEN-LAST:event_goToVentasActionPerformed

    private void seeDetails_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeDetails_btnActionPerformed
        int rowIndex = this.ventas_table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una venta para ver los detalles.");
            return;
        }

        String id = (String) this.ventas_table.getValueAt(rowIndex, 0);

        Result<Venta> res = controlador.getVentaById(id);

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }

        ventaSelected = res.getValue();
        System.out.println("ventaSelected: " + ventaSelected);
        
        this.id_show.setText(ventaSelected.getId().getValue());
        this.fecha_show.setText(ventaSelected.getFechaVenta().getValue().toString());
        this.total_show.setText("$"+ventaSelected.getTotal());
        
        cargarTablaDetalles();

        cambiarVista("details_view");
    }//GEN-LAST:event_seeDetails_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int rowIndex = this.ventas_table.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una venta eliminarla.");
            return;
        }
        
        
        String id = (String) this.ventas_table.getValueAt(rowIndex, 0);

        int option = JOptionPane.showConfirmDialog(this, "Estas seguro que desear eliminar la venta con id '"+id+"'.", "Advertencia", JOptionPane.YES_NO_OPTION);
            
        if(option == JOptionPane.NO_OPTION){
            return;
        }
        
        Result<Venta> res = controlador.deleteVenta(id);

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }
        
        System.out.println("Se elimino correctamente!");
        cargarVentas();
        cargarTabla();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void quitar_filtro_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitar_filtro_btnActionPerformed
        cargarVentas();
        cargarTabla();
        fecha_filtro_field.setText("");
    }//GEN-LAST:event_quitar_filtro_btnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apply_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JPanel details_panel;
    private javax.swing.JTable details_table;
    private javax.swing.JScrollPane details_table_container;
    private javax.swing.JFormattedTextField fecha_filtro_field;
    private javax.swing.JLabel fecha_show;
    private javax.swing.JButton goToMainMenu_btn;
    private javax.swing.JButton goToVentas;
    private javax.swing.JLabel id_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mainLayout;
    private javax.swing.JButton quitar_filtro_btn;
    private javax.swing.JButton seeDetails_btn;
    private javax.swing.JLabel total_show;
    private javax.swing.JPanel ventas_panel;
    private javax.swing.JTable ventas_table;
    private javax.swing.JScrollPane ventas_table_container;
    // End of variables declaration//GEN-END:variables
}
