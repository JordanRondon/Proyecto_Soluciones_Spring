package T4.ProyectoWilson.Model;
import lombok.Data;

@Data
public class Producto {
    int id_producto;
    String nombre;
    String descripcion;
    float precio_unitario;
    byte[] imagen;
    int id_producto_categoria;
}
