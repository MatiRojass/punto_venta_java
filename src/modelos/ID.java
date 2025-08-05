package modelos;

import java.util.Objects;

public class ID {
    private final String id;

    public ID(String id) {
        validar(id);
        this.id = id;
    }

    private void validar(String id) {
        if (id == null || !id.matches("^[A-Z]+\\d{4}$")) {
            throw new ModeloException("El ID debe tener un prefijo en mayúsculas seguido de 4 números (ej: PRE1234).");
        }
    }

    public String getValue() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID that = (ID) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}