package modelos;


public class ProductoVenta {
    private final String id;
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public ProductoVenta(String id, String nombre, double precio, int cantidad) {
        if(cantidad <= 0) throw new ModeloException("La cantidad no puede ser 0 o menor.");
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public double calcularTotal(){
        return precio*cantidad;
    }
    
    public static ProductoVenta crear(Producto prod, int cantidad){
        ProductoVenta pv = new ProductoVenta(
                prod.getId().getValue(),
                prod.getNombre().getValue(),
                prod.getPrecio().getValue(),
                cantidad
        );
        return pv;
    }
}
