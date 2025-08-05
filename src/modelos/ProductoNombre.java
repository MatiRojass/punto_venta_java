package modelos;

import java.util.Objects;

public class ProductoNombre {
    private final String nombre;

    public ProductoNombre(String nombre) {
        validar(nombre);
        this.nombre = nombre;
    }

    private void validar(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ModeloException("El nombre del producto no puede ser nulo o vacío.");
        }
    }

    public String getValue() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoNombre that = (ProductoNombre) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}