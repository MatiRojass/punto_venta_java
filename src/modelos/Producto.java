package modelos;

public class Producto {
    private final ID id;
    private final ProductoNombre nombre;
    private final Precio precio;

    public Producto(ID id, ProductoNombre nombre, Precio precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ID getId() {
        return id;
    }

    public ProductoNombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}