package puntoventa;
import modelos.*;
import repositorios.*;
import servicios.*;
import controladores.Controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import vistas.MenuPrincipal;

public class Principal {
    private static final boolean TEST_MODE = true;
    
    
    public static void main(String[] args) {
        
        ProductoRepositorio prodsRepo = new ProductoRepositorioMemoria();
        VentaRepositorio ventasRepo = new VentaRepositorioMemoria();
        
        if(TEST_MODE){
            cargarDatosPrueba(prodsRepo, ventasRepo);
        }
        
        ProductoServicio prodServ = new ProductoServicio(prodsRepo);
        VentaServicio ventasServ = new VentaServicio(ventasRepo);
        
        Controlador controller = new Controlador(prodServ, ventasServ);
        
        MenuPrincipal mp = new MenuPrincipal(controller);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
    }
    
    private static void cargarDatosPrueba(ProductoRepositorio pr, VentaRepositorio vr){
        //LISTA DE PRODUCTOS
        Producto[] productos = {
            new Producto(new ID("PRO1000"), new ProductoNombre("Dulce de leche"), new Precio(5050.0)),
            new Producto(new ID("PRO2200"), new ProductoNombre("Queso"), new Precio(6000.0)),
            new Producto(new ID("PRO3400"), new ProductoNombre("Arroz blanco"), new Precio(2499.99)),
            new Producto(new ID("PRO2400"), new ProductoNombre("Carne"), new Precio(10000.0)),
            new Producto(new ID("PRO9100"), new ProductoNombre("Chocolate Cofler"), new Precio(789.9)),
        };
        
        List<List<ProductoVenta>> listaProds = List.of(
            List.of(ProductoVenta.crear(productos[0], 4), ProductoVenta.crear(productos[2], 1)),
            List.of(ProductoVenta.crear(productos[1], 2), ProductoVenta.crear(productos[0], 3)),
            List.of(ProductoVenta.crear(productos[2], 2), ProductoVenta.crear(productos[3], 1)),
            List.of(ProductoVenta.crear(productos[4], 5), ProductoVenta.crear(productos[1], 1))
        );
        
        Venta[] ventas = {
            new Venta(new ID("VEN7070"), listaProds.get(0), new Fecha(LocalDate.parse("2025-04-30"))),
            new Venta(new ID("VEN9400"), listaProds.get(1), new Fecha(LocalDate.parse("2025-05-23"))),
            new Venta(new ID("VEN7040"), listaProds.get(2), new Fecha(LocalDate.parse("2025-08-02"))),
            new Venta(new ID("VEN6550"), listaProds.get(3),  new Fecha(LocalDate.parse("2025-04-01")))
        };
        
        //CARGAR PRODUCTOS AL REPO
        for(Producto p : productos){
            pr.save(p);
        }
        
        //CARGAR VENTAS AL REPO
        for(Venta v : ventas){
            vr.add(v);
        }
        
    }
    
    

}
