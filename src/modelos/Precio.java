package modelos;

import java.util.Objects;

public class Precio {
    private final Double precio;

    public Precio(Double precio) {
        validar(precio);
        this.precio = precio;
    }

    private void validar(Double precio) {
        if (precio == null || precio < 0) {
            throw new ModeloException("El precio no puede ser nulo o negativo.");
        }
    }

    public Double getValue() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%.2f", precio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio that = (Precio) o;
        return Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio);
    }
}