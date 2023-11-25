package T4.ProyectoWilson.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import T4.ProyectoWilson.Model.Usuario;
@Repository
public class UsuarioRepository implements IUsuarioRepository{
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Usuario> obtenerDatos(String usuario) {
		String sql = "SELECT * FROM usuario where id_usuario=?";
		return jdbcTemplate.query(sql,  BeanPropertyRowMapper.newInstance(Usuario.class),new Object[]{usuario});
	}
}
