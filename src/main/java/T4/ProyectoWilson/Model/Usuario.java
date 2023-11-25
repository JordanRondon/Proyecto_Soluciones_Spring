package T4.ProyectoWilson.Model;
import lombok.Data;

@Data
public class Usuario {
    String id_usuario;
    String contraseña;
    String nombre;
    String apellido;
    int dni;
    int telefono;
    String rol;
}
