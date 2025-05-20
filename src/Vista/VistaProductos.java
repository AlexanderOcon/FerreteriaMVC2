package Vista;

import Controlador.ProductoControlador;
import Controlador.CategoriaControlador;
import Modelo.Producto;
import Modelo.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaProductos extends javax.swing.JPanel {
    
    private final ProductoControlador productoControlador;
    private Integer idProductoSeleccionado = null;
    
    private final CategoriaControlador categoriaControlador;
    private Integer idCategoriaSeleccionada = null;
    
      public VistaProductos() {
        initComponents();
        this.productoControlador = new ProductoControlador();
        this.categoriaControlador = new CategoriaControlador();
        cargarDatosTabla();
        cargarCategorias();
        eventoComboCategorias();
    }
      
    private void cargarDatosTabla() {
        List<Producto> productos = productoControlador.obtenerTodosProductos();
        if (productos != null) {
            DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();
            model.setRowCount(0);
            for (Producto pro : productos) {
                Object[] row = {
                    pro.getIdProducto(),
                    pro.getNombreProducto(),
                    pro.getDescripcionProducto(),
                    pro.getIdCategoria(),
                    pro.getPrecioUnitario(),
                    pro.getStock(),
                    pro.getImagen()
                };
                model.addRow(row);
            }
        }
}
    
    private void cargarCategorias() {
        try {
        // Obtener las categorías desde el controlador
            List<Categoria> categorias
                    = categoriaControlador.obtenerTodasCategorias();
        // Limpiar el combo box por si tiene datos
            ComboCategoria.removeAllItems();
        // Agregar cada categoría al combo box
            for (Categoria cat : categorias) {
                ComboCategoria.addItem(cat.getNombreCategoria());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar las categorías: " + e.getMessage());
        }
    }
    
    
    private void eventoComboCategorias() {
    ComboCategoria.addActionListener(e -> {
        // Obtener el indice seleccionado
        int indiceSeleccionado = ComboCategoria.getSelectedIndex();
        if (indiceSeleccionado >= 0) { // Verificar que se haya seleccionado algo
            try {
                // Obtener la lista de categorias desde el controlador o memoria
                List<Categoria> categorias = categoriaControlador.obtenerTodasCategorias();
                // Obtener el objeto de categoria correspondiente al indice seleccionado
                Categoria categoriaSeleccionada = categorias.get(indiceSeleccionado);
                // Actualizar la variable global con el ID de la categoria seleccionada
                idCategoriaSeleccionada = categoriaSeleccionada.getIdCategoria();
                // Mostrar el ID seleccionado en la consola (puedes quitar esta linea)
                System.out.println("ID de la categoria seleccionada: " + idCategoriaSeleccionada);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al seleccionar categoria: " + ex.getMessage());
            }
        }
    });
}
    
    
    private void seleccionarCategoriaEnConbo(Integer idCategoria) {
    try {
        // Obtener las categorías desde el controlador
        List<Categoria> categorias = categoriaControlador.obtenerTodasCategorias();
        
        // Recorrer las categortas y buscar la que coincida con el ID
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            if (categoria.getIdCategoria() == idCategoria) {
                ComboCategoria.setSelectedIndex(i);
                break;
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al seleccionar categoria: " + e.getMessage());
    }
}
    
        private void limpiar() {
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        txtPrecioUnitario.setText("");
        txtStock.setText("");
        txtImagen.setText("");
        ComboCategoria = null;
        idProductoSeleccionado = null;
        txtEliminar.setEnabled(true);
        txtGuardar.setEnabled(true);
    }
        
  


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel1 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jlabel2 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        txtGuardar = new javax.swing.JButton();
        txtActualizar = new javax.swing.JButton();
        txtEliminar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();
        txtLimpiar = new javax.swing.JButton();

        jlabel1.setText("nombre_producto");

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        jlabel2.setText("descripcion_producto");

        txtDescripcionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionProductoActionPerformed(evt);
            }
        });

        jLabel4.setText("precio_unitario");

        txtPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioActionPerformed(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel5.setText(" stock");

        jLabel6.setText("imagen");

        txtImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImagenActionPerformed(evt);
            }
        });

        txtGuardar.setText("Guardar");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });

        txtActualizar.setText("Actualizar");
        txtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarActionPerformed(evt);
            }
        });

        txtEliminar.setText("Eliminar");
        txtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEliminarActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarProducto(evt);
            }
        });

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Descripcion", "ID Categoria", "Precio", "Stock", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductos(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        jLabel1.setText("Categoria");

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtLimpiar.setText("Limpiar");
        txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(95, 95, 95))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtDescripcionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProductoActionPerformed

    private void txtPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUnitarioActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImagenActionPerformed

    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        String nombreProducto = txtNombreProducto.getText();
        String descripcionProducto = txtDescripcionProducto.getText();
        int idCategoria = idCategoriaSeleccionada;

        // Cambiado para obtener el stock correctamente
        int stock = Integer.parseInt(txtStock.getText());
        float precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());
        String imagen = txtImagen.getText();

           if (!nombreProducto.isEmpty() && !descripcionProducto.isEmpty() && precioUnitario >= 0 && stock >= 0 && idCategoria != -1) {
                try {
                productoControlador.crearProducto(
                        nombreProducto,
                        descripcionProducto,
                        idCategoria,
                        precioUnitario,
                        stock,
                        imagen
                );
                limpiar();
                cargarDatosTabla();
                cargarCategorias();
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error en los datos: " + e.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Por favor, llene todos los campos obligatorios correctamente.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_txtGuardarActionPerformed

    private void txtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarActionPerformed
        String nombreProducto = txtNombreProducto.getText();
        String descripcionProducto = txtDescripcionProducto.getText();
        int idCategoria = idCategoriaSeleccionada;
        float precioUnitario = Float.parseFloat(txtPrecioUnitario.getText());
        int stock = Integer.parseInt(txtStock.getText());
        String imagen = txtImagen.getText();

        if (idProductoSeleccionado != null && !nombreProducto.isEmpty() && !descripcionProducto.isEmpty() && idCategoria >= 0 && stock >= 0) {
            try {
                productoControlador.actualizarProducto(
                        idProductoSeleccionado,
                        nombreProducto,
                        descripcionProducto,
                        idCategoria,
                        precioUnitario,
                        stock,
                        imagen
                );
                cargarDatosTabla(); // Vuelve a cargar los datos en la tabla después de actualizar
                limpiar(); // Limpia los campos
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error en los datos: " + e.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Por favor, llene todos los campos obligatorios.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_txtActualizarActionPerformed

    private void txtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEliminarActionPerformed
        int filaSeleccionada = TablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idProducto = (int) TablaProductos.getValueAt(filaSeleccionada, 0);
            productoControlador.eliminarProducto(idProducto);
            cargarDatosTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Selecciona una fila para eliminar.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_txtEliminarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void tablaProductos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductos
        // Verifica si fue un doble clic
        if (evt.getClickCount() == 2) {
            // Obtener la fila seleccionada
            int filaSeleccionada = TablaProductos.getSelectedRow();
            if (filaSeleccionada != -1) {
                // Obtener el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) TablaProductos.getModel();

                // Extraer los datos de la fila seleccionada
                idProductoSeleccionado = (Integer) model.getValueAt(filaSeleccionada, 0);
                String nombreProducto = (String) model.getValueAt(filaSeleccionada, 1);
                String descripcionProducto = (String) model.getValueAt(filaSeleccionada, 2);
                Integer idCategoria = (Integer) model.getValueAt(filaSeleccionada, 3);
                Float precioUnitario = (Float) model.getValueAt(filaSeleccionada, 4);
                Integer stock = (Integer) model.getValueAt(filaSeleccionada, 5);
                String imagen = (String) model.getValueAt(filaSeleccionada, 6);

                // Asignar los valores a los campos de texto
                txtNombreProducto.setText(nombreProducto);
                txtDescripcionProducto.setText(descripcionProducto);
                txtPrecioUnitario.setText(precioUnitario.toString());
                txtStock.setText(stock.toString());
                txtImagen.setText(imagen);

                // Seleccionar la categoria correspondiente en el combo
                seleccionarCategoriaEnConbo(idCategoria);
                idCategoriaSeleccionada = idCategoria;

                // Deshabilitar el botón Eliminar y Guardar si es necesario
                txtEliminar.setEnabled(false);
                txtGuardar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tablaProductos

    private void BuscarProducto(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarProducto
        String textoBusqueda = txtBuscarProducto.getText().trim().toLowerCase();
        List<Producto> productos = productoControlador.obtenerTodosProductos();

        DefaultTableModel modelo = (DefaultTableModel) TablaProductos.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de mostrar los resultados

        if (productos != null) {
            for (Producto pro : productos) {
                // Busca coincidencias en los campos del producto
                if (textoBusqueda.isEmpty() // Si el campo de búsqueda está vacío, muestra todos
                        || pro.getNombreProducto().toLowerCase().contains(textoBusqueda)
                        || pro.getDescripcionProducto().toLowerCase().contains(textoBusqueda)
                        || String.valueOf(pro.getIdCategoria()).contains(textoBusqueda)
                        || String.valueOf(pro.getPrecioUnitario()).contains(textoBusqueda)
                        || String.valueOf(pro.getStock()).contains(textoBusqueda)) {
                    Object[] fila = {
                        pro.getIdProducto(),
                        pro.getNombreProducto(),
                        pro.getDescripcionProducto(),
                        pro.getIdCategoria(),
                        pro.getPrecioUnitario(),
                        pro.getStock(),
                        pro.getImagen()
                    };
                    modelo.addRow(fila); // Agrega la fila a la tabla
                }
            }
        }
    }//GEN-LAST:event_BuscarProducto

    private void BtnLimpiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiar
        limpiar();
    }//GEN-LAST:event_BtnLimpiar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JButton txtActualizar;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JButton txtEliminar;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JButton txtLimpiar;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
