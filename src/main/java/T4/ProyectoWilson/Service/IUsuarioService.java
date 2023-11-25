package T4.ProyectoWilson.Service;

import java.util.List;

import T4.ProyectoWilson.Model.Usuario;

public interface IUsuarioService {
    public List<Usuario> obtenerDatos(String usuario);
}
