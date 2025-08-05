package repositorios;

import java.util.List;
import modelos.Producto;
import modelos.ID;
import modelos.ProductoNombre;

public interface ProductoRepositorio {

    void save(Producto producto);

    Producto delete(ID id);

    List<Producto> getAll();

    Producto getById(ID id);

    List<Producto> searchByName(ProductoNombre nombre);
}
