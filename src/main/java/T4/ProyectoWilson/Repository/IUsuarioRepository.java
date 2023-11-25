package T4.ProyectoWilson.Repository;

import java.util.List;

import T4.ProyectoWilson.Model.Usuario;

public interface IUsuarioRepository {
    public List<Usuario> obtenerDatos(String usuario);
}
