package servicios;

import java.time.LocalDate;
import java.util.List;
import modelos.Fecha;
import modelos.ID;
import modelos.ProductoVenta;
import repositorios.VentaRepositorio;
import modelos.Venta;


public class VentaServicio {
    private final VentaRepositorio ventaRepo; 
    private int contId = 1;
    
    private String generarId(){
        String id = String.format("VEN%04d", contId);
        contId++;
        return id;
    }
    
    public VentaServicio(VentaRepositorio ventaRepo) {
        this.ventaRepo = ventaRepo;
    }

    public void create(List<ProductoVenta> productos, LocalDate fechaVenta){
        Venta nuevaVenta = new Venta(new ID(generarId()), productos, new Fecha(fechaVenta));
        
        ventaRepo.add(nuevaVenta);
    }
    
    public List<Venta> getAll(){
        return ventaRepo.getAll();
    }
    
    public Venta getById(String id){
        ID ventId = new ID(id);
        
        return ventaRepo.getById(ventId);
    }
    
    public List<Venta> getByFecha(LocalDate fecha){
        Fecha f = new Fecha(fecha);
        return ventaRepo.getByFecha(f);
    }
    
    public Venta delete(String id){
        ID ventId = new ID(id);
        return ventaRepo.delete(ventId);
    }
    
    
    
    
}
