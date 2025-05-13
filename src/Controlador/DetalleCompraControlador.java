
package Controlador;

import DAO.DetalleCompraDAO;
import Modelo.DetalleCompra;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class DetalleCompraControlador {

    private final DetalleCompraDAO detalleCompraDAO;

    public DetalleCompraControlador() {
        this.detalleCompraDAO = new DetalleCompraDAO();
    }

    // Método para crear un nuevo detalle de compra
    public void crearDetalleCompra(int idCompra, int idProducto, int cantidad, float precioUnitario) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setIdCompra(idCompra);
            detalle.setIdProducto(idProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalleCompraDAO.crearDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los detalles de compra
    public List<DetalleCompra> obtenerTodosDetallesCompra() {
        try {
            return detalleCompraDAO.leerTodosDetallesCompra();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un detalle de compra existente
    public void actualizarDetalleCompra(int idDetalleCompra, int idCompra, int idProducto, int cantidad, float precioUnitario) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setIdDetalleCompra(idDetalleCompra);
            detalle.setIdCompra(idCompra);
            detalle.setIdProducto(idProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalleCompraDAO.actualizarDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un detalle de compra
    public void eliminarDetalleCompra(int idDetalleCompra) {
        try {
            detalleCompraDAO.eliminarDetalleCompra(idDetalleCompra);
            JOptionPane.showMessageDialog(null, "Detalle de compra eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
