package T4.ProyectoWilson.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

import T4.ProyectoWilson.Model.Usuario;
import T4.ProyectoWilson.Repository.IUsuarioRepository;
@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
	private IUsuarioRepository usuarioRepository;
    @Override
	public List<Usuario> obtenerDatos(String usuario) {
		List<Usuario> list;
		try {
			list=usuarioRepository.obtenerDatos(usuario);
		}catch (Exception ex) {
			throw ex;
		}
		return list;
	}
}
