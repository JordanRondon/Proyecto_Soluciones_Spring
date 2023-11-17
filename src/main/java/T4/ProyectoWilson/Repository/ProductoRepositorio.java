package T4.ProyectoWilson.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import T4.ProyectoWilson.Model.Producto;
@Repository
public class ProductoRepositorio implements ProductoRepository{
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Producto> findAll() {
		String sql = "SELECT * FROM producto";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Producto.class));
	}

	@Override
	public int save(Producto producto) {
		String sql = "INSERT INTO producto VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {producto.getNombre(),producto.getDescripcion(),producto.getPrecio_unitario(),producto.getImagen(),producto.getId_producto_categoria()});
	}

	@Override
	public int update(Producto producto) {
		String sql = "UPDATE producto SET nombre=?,descripcion=?,precio_unitario=?,imagen=?,id_producto_categoria=? WHERE id_producto=?";
		return jdbcTemplate.update(sql,new Object[] {producto.getNombre(),producto.getDescripcion(),producto.getPrecio_unitario(),producto.getImagen(),producto.getId_producto_categoria(),producto.getId_producto()});
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE producto where id_producto=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
}
