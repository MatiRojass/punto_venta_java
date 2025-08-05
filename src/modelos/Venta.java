package modelos;

import java.util.List;


public class Venta {
    private ID id;
    private List<ProductoVenta> productos;
    private Fecha fechaVenta;
    private double total;

    public Venta(ID id, List<ProductoVenta> productos, Fecha fechaVenta) {
        this.id = id;
        this.productos = productos;
        this.fechaVenta = fechaVenta;
        this.total = calcularTotal(productos);
    }
    
    private double calcularTotal(List<ProductoVenta> productos){
        return productos.stream()
                .mapToDouble(ProductoVenta::calcularTotal)
                .sum();
    }

    public ID getId() {
        return id;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public Fecha getFechaVenta() {
        return fechaVenta;
    }

    public double getTotal() {
        return total;
    }
    
    
}
