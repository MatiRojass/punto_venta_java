package controladores;

import java.time.LocalDate;
import java.util.List;
import modelos.ModeloException;
import modelos.Producto;
import modelos.ProductoVenta;
import modelos.Venta;
import servicios.ProductoServicio;
import servicios.ServicioException;
import servicios.VentaServicio;
import shared.Result;

public class Controlador {

    private final ProductoServicio ps;
    private final VentaServicio vs;

    public Controlador(ProductoServicio ps, VentaServicio vs) {
        this.ps = ps;
        this.vs = vs;
    }

    /*
    
        CONTROLADORES DE PRODUCTO
    
     */
    public Result<Void> createProducto(String nombre, double precio) {
        try {
            ps.create(nombre, precio);
            return Result.ok(null);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    public Result<Void> updateProduct(String id, String nombre, double precio) {
        try {
            ps.update(id, nombre, precio);
            return Result.ok(null);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    public Result<Producto> deleteProduct(String id) {
        try {
            Producto prod = ps.delete(id);
            return Result.ok(prod);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    public Result<Producto> getProductoById(String id) {
        try {
            Producto producto = ps.getById(id);
            if(producto == null){
                return Result.error("No se encontro producto con el id '"+id+"'.");
            }
            return Result.ok(producto);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    public Result<List<Producto>> getAllProducts() {
        try {
            List<Producto> productos = ps.getAll();
            return Result.ok(productos);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    public Result<List<Producto>> searchProductByName(String query) {
        try {
            List<Producto> productos = ps.searchByName(query);
            return Result.ok(productos);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

    /*
    
        CONTROLADORES DE VENTAS
    
     */
    public Result<Void> createVenta(List<ProductoVenta> productos) {
        try {
            vs.create(productos, LocalDate.now());
            return Result.ok(null);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }
    
    public Result<List<Venta>> getAllVentas(){
        try {
            List<Venta> sells = vs.getAll();
            return Result.ok(sells);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }
    
    public Result<List<Venta>> getVentasByFecha(LocalDate date){
        try {
            List<Venta> sells = vs.getByFecha(date);
            return Result.ok(sells);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }
    
    public Result<Venta> getVentaById(String id){
        try {
            Venta sell = vs.getById(id);
            return Result.ok(sell);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }
    
    public Result<Venta> deleteVenta(String id){
        try {
            Venta sell = vs.delete(id);
            return Result.ok(sell);
        } catch (ModeloException | ServicioException e) {
            return Result.error(e.getMessage());
        }
    }

}
