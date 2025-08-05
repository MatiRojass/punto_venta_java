package repositorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelos.ID;
import modelos.Producto;
import modelos.ProductoNombre;


public class ProductoRepositorioMemoria implements ProductoRepositorio {

    private final Map<ID, Producto> productos = new HashMap<>();
    
    @Override
    public void save(Producto producto) {
        ID id = producto.getId();
        productos.put(id, producto);
    }

    @Override
    public Producto delete(ID id) {
        return productos.remove(id);
    }

    @Override
    public List<Producto> getAll() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public Producto getById(ID id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> searchByName(ProductoNombre nombre) {
        List<Producto> results = new ArrayList<>();
        String searchQuery = nombre.getValue().toLowerCase();
        
        for(Producto p : productos.values()){
            String prodNombre = p.getNombre().getValue().toLowerCase();
            if(prodNombre.contains(searchQuery)){
                results.add(p);
            }
        }
        
        return results;
    }

}
