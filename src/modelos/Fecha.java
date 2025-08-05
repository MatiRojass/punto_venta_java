package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Fecha {

    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        validar(fecha);
        this.fecha = fecha;
    }

    private void validar(LocalDate fecha) {
        if (fecha == null) {
            throw new ModeloException("La fecha no puede ser nula.");
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new ModeloException("La fecha no puede ser posterior a la fecha actual.");

        }
    }

    public LocalDate getValue() {
        return fecha;
    }

    @Override
    public String toString() {
        return fecha.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fecha that = (Fecha) o;
        return Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }
}
