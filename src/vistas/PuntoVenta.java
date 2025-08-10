package vistas;

import controladores.Controlador;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelos.ModeloException;
import modelos.Producto;
import modelos.ProductoVenta;
import shared.Result;

/**
 *
 * @author Mati
 */
public class PuntoVenta extends javax.swing.JFrame {

    private final Controlador controlador;
    private List<ProductoVenta> compras;
    private Map<String, Producto> productos;
    private List<Producto> productosFiltrados;

    public PuntoVenta(Controlador controlador) {
        this.controlador = controlador;
        this.compras = new ArrayList<>();
        initComponents();

        cargarTodosLosProductos();

        cargarTablaProductos();
        cargarTablaCompras();
    }

    private void cargarTodosLosProductos() {
        Result<List<Producto>> res = controlador.getAllProducts();

        if (!res.isOk()) {
            System.out.println("No se pudo cargar los productos: " + res.getError());
            return;
        }

        productos = new HashMap<>();
        for (Producto p : res.getValue()) {
            productos.put(p.getId().getValue(), p);
        }
        productosFiltrados = res.getValue();
    }

    private void cargarTablaProductos() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] campos = {"ID", "Nombre", "Precio"};

        model.setColumnIdentifiers(campos);

        for (Producto p : productosFiltrados) {
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

    private void cargarTablaCompras() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return (column == 3 || column == 4);
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 3 ->
                        Integer.class;
                    case 4 ->
                        JButton.class;
                    default ->
                        String.class;
                };
                //return super.getColumnClass(columnIndex); 
            }
        };

        DefaultTableCellRenderer render = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return switch (value) {
                    case JButton btn ->
                        btn;
                    case JSpinner spn ->
                        spn;
                    default ->
                        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                };
            }
        };

        this.compra_table.setDefaultRenderer(Object.class, render);

        String[] campos = {"ID", "Nombre", "Precio", "Cantidad", "Eliminar"};
        model.setColumnIdentifiers(campos);

        if (compras != null) {
            for (ProductoVenta pv : compras) {

                Object[] row = {pv.getId(), pv.getNombre(), pv.getPrecio(), pv.getCantidad(), "Eliminar"};
                model.addRow(row);
            }
        }

        this.compra_table.setModel(model);
        customizarTablaVenta();
    }

    private void customizarTablaVenta() {
        TableColumnModel columnModel = this.compra_table.getColumnModel();
        this.compra_table.setRowHeight(20);

        int ID_WIDTH = 10;
        int NOMBRE_WIDTH = 100;
        int PRECIO_WIDTH = 80;
        int CANTIDAD_WIDTH = 10;
        int BORRAR_WIDTH = 5;

        columnModel.getColumn(0).setPreferredWidth(ID_WIDTH);
        columnModel.getColumn(0).setResizable(false);

        columnModel.getColumn(1).setPreferredWidth(NOMBRE_WIDTH);

        columnModel.getColumn(2).setPreferredWidth(PRECIO_WIDTH);

        columnModel.getColumn(3).setPreferredWidth(CANTIDAD_WIDTH);

        columnModel.getColumn(4).setPreferredWidth(BORRAR_WIDTH);

        compra_table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        //Aceptar botones y eso
        // Spinner en columna cantidad
        compra_table.getColumnModel().getColumn(3).setCellEditor(new SpinnerEditor(1, 99, 1));

        // Botón en columna eliminar
        compra_table.getColumnModel().getColumn(4).setCellRenderer((table, value, isSelected, hasFocus, row, col) -> {
            JButton btn = new JButton("X");
            btn.setBackground(Color.red);
            btn.setForeground(Color.white);
            return btn;
        });
        compra_table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        compra_table_container = new javax.swing.JScrollPane();
        compra_table = new javax.swing.JTable();
        sell_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total_label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        products_table_container1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        seeAll_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Punto de Venta");

        compra_table.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        compra_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        compra_table_container.setViewportView(compra_table);
        if (compra_table.getColumnModel().getColumnCount() > 0) {
            compra_table.getColumnModel().getColumn(0).setResizable(false);
            compra_table.getColumnModel().getColumn(1).setResizable(false);
            compra_table.getColumnModel().getColumn(2).setResizable(false);
            compra_table.getColumnModel().getColumn(3).setResizable(false);
        }

        sell_btn.setBackground(new java.awt.Color(153, 255, 51));
        sell_btn.setForeground(new java.awt.Color(0, 0, 0));
        sell_btn.setText("VENDER");
        sell_btn.setToolTipText("");
        sell_btn.setFocusable(false);
        sell_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sell_btnActionPerformed(evt);
            }
        });

        clear_btn.setText("LIMPIAR LISTA");
        clear_btn.setFocusable(false);
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de compras");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home_icon.png"))); // NOI18N
        jButton1.setText(" Volver al inicio");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("TOTAL:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("$");

        total_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        total_label.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sell_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(compra_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sell_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(total_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compra_table_container, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Buscar producto");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        search_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_fieldKeyTyped(evt);
            }
        });
        jPanel2.add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 229, -1));

        search_btn.setBackground(new java.awt.Color(255, 255, 255));
        search_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search_icon.png"))); // NOI18N
        search_btn.setToolTipText("");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        jPanel2.add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 40, 40));

        products_table.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ));
        products_table_container1.setViewportView(products_table);

        jPanel2.add(products_table_container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 315, 388));

        seeAll_btn.setText("Ver Todos");
        seeAll_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeAll_btnActionPerformed(evt);
            }
        });
        jPanel2.add(seeAll_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 40));

        add_btn.setBackground(new java.awt.Color(102, 102, 255));
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("Agregar");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel2.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarItemCompra(int row) {
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para eliminar.");
            return;
        }

        String id = (String) compra_table.getValueAt(row, 0);
        System.out.println("Eliminado- ID: '" + id + "' - Fila: '" + row + "'.");
        compras.removeIf((p) -> id.equals(p.getId()));
        cargarTablaCompras();
    }

    private void seeAll_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeAll_btnActionPerformed
        productosFiltrados = new ArrayList(productos.values());
        cargarTablaProductos();
    }//GEN-LAST:event_seeAll_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        int row = this.products_table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para agregar.");
            return;
        }

        String id = (String) products_table.getValueAt(row, 0);

        ProductoVenta encontrado = estaEnLaLista(id);

        if (encontrado != null) {
            encontrado.incrementarCantidad();
        } else {
            Producto prod = productos.get(id);

            ProductoVenta prodVenta = ProductoVenta.crear(prod, 1);
            compras.add(prodVenta);

        }
        cargarTablaCompras();
        actualizarTotal();
    }//GEN-LAST:event_add_btnActionPerformed

    private void buscarProducto() {
        String search = this.search_field.getText().toLowerCase();

        this.productosFiltrados = productos.values().stream()
                .filter((p) -> {
                    String prodNom = p.getNombre().getValue().toLowerCase();
                    return prodNom.contains(search);
                })
                .toList();
        cargarTablaProductos();
    }

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        buscarProducto();
    }//GEN-LAST:event_search_btnActionPerformed

    private void search_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyTyped
        char key = evt.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            buscarProducto();
        }
    }//GEN-LAST:event_search_fieldKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipal mp = new MenuPrincipal(controlador);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        compras = new ArrayList<>();
        cargarTablaCompras();
    }//GEN-LAST:event_clear_btnActionPerformed

    private void sell_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sell_btnActionPerformed

        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar productos para vender!");
        }
        if (compra_table.isEditing()) {
            compra_table.getCellEditor().stopCellEditing();
        }

        System.out.println("Lista: " + compras);

        Result<Void> res = controlador.createVenta(compras);

        if (!res.isOk()) {
            JOptionPane.showMessageDialog(this, res.getError());
            return;
        }

        compras = new ArrayList<>();
        cargarTablaCompras();
        total_label.setText("0,00");
    }//GEN-LAST:event_sell_btnActionPerformed

    private ProductoVenta estaEnLaLista(String id) {
        for (ProductoVenta pv : compras) {
            String pvId = pv.getId();
            if (pvId.equals(id)) {
                return pv;
            }
        }
        return null;
    }
    
    private void actualizarTotal(){
        double total = compras.stream().mapToDouble(ProductoVenta::calcularTotal).sum();
        this.total_label.setText(String.format("%.2f",total));
    }
    
    
    
    
    
    //CLASES AUXILIARES - BOTONES
    // Editor personalizado para JButton
    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private final JButton button;
        private int row;

        public ButtonEditor() {
            button = new JButton("X");
            button.setBackground(Color.red);
            button.setForeground(Color.white);
            button.addActionListener((var e) -> {
                eliminarItemCompra(row);
                actualizarTotal();
                fireEditingStopped();
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null; // el botón no tiene valor en sí
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            this.row = row;
            return button;
        }
    }

    // Editor personalizado para JSpinner
    class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {

        private final JSpinner spinner;
        private Integer value = 1;

        public SpinnerEditor(int min, int max, int step) {
            spinner = new JSpinner(new SpinnerNumberModel(1, min, max, step));
        }

        @Override
        public Object getCellEditorValue() {
            //obtener la fila  editada
            int row = compra_table.getEditingRow();

            //actualizar la cantidad en el producto en la lista
            try {
                compras.get(row).setCantidad((int) spinner.getValue());
                this.value = (int) spinner.getValue();
                actualizarTotal();
            } catch (ModeloException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            return this.value;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton clear_btn;
    private javax.swing.JTable compra_table;
    private javax.swing.JScrollPane compra_table_container;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable products_table;
    private javax.swing.JScrollPane products_table_container1;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_field;
    private javax.swing.JButton seeAll_btn;
    private javax.swing.JButton sell_btn;
    private javax.swing.JLabel total_label;
    // End of variables declaration//GEN-END:variables
}
