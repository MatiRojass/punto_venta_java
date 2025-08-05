package servicios;

import java.util.List;
import modelos.*;
import repositorios.ProductoRepositorio;


public class ProductoServicio {
    private final ProductoRepositorio productosRepo;
    private int contId = 1;
    
    private String generarId(){
        String id = String.format("PRO%04d", contId);
        contId++;
        return id;
    }
    
    public ProductoServicio(ProductoRepositorio productosRepo) {
        this.productosRepo = productosRepo;
    }
    
    public void create(String nombre, double precio){ 
        Producto nuevoProducto = new Producto(
                new ID(generarId()),
                new ProductoNombre(nombre),
                new Precio(precio)
        );
        
        productosRepo.save(nuevoProducto);
    }
    
    public void update(String id, String nombre, double precio){
        ID prodId = new ID(id);
        
        Producto prod = productosRepo.getById(prodId);
        
        if(prod == null) throw new ProductoServicioException("No existe producto con id '"+id+"'.");
        
        Producto productoEditado = new Producto(
                prod.getId(), 
                new ProductoNombre(nombre), 
                new Precio(precio)
        );
        
        productosRepo.save(productoEditado);
    }
    
    public Producto delete(String id){
        ID prodId = new ID(id);
        return productosRepo.delete(prodId);
    }
    
    public List<Producto> searchByName(String nameQuery){
        ProductoNombre query = new ProductoNombre(nameQuery);
        return productosRepo.searchByName(query);
    }
    
    public Producto getById(String id){
        ID prodId = new ID(id);
        return productosRepo.getById(prodId);
    }
    
    public List<Producto> getAll(){
        return productosRepo.getAll();
    }
}
