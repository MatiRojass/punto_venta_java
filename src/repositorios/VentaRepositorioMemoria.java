package repositorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelos.Fecha;
import modelos.ID;
import modelos.Venta;

public class VentaRepositorioMemoria implements VentaRepositorio {

    private final Map<ID, Venta> ventas = new HashMap<>();

    @Override
    public void add(Venta venta) {
        ID id = venta.getId();
        ventas.putIfAbsent(id, venta);
    }

    @Override
    public Venta delete(ID id) {
        return ventas.remove(id);
    }

    @Override
    public List<Venta> getAll() {
        return new ArrayList<>(ventas.values());
    }

    @Override
    public Venta getById(ID id) {
        return ventas.get(id);
    }

    @Override
    public List<Venta> getByFecha(Fecha fecha) {
        List<Venta> results = new ArrayList<>();
        for(Venta v : ventas.values()){
            if(fecha.equals(v.getFechaVenta())){
                results.add(v);
            }
        }
        return results;
    }

}
