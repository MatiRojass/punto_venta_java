package repositorios;

import java.util.List;
import modelos.Venta;
import modelos.ID;
import modelos.Fecha;

public interface VentaRepositorio {

    void add(Venta venta);

    Venta delete(ID id);

    List<Venta> getAll();

    Venta getById(ID id);

    List<Venta> getByFecha(Fecha fecha);

}
