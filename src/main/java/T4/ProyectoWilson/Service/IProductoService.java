package T4.ProyectoWilson.Service;

import java.util.List;

import T4.ProyectoWilson.Model.Producto;
public interface IProductoService {
    public List<Producto> findAll();
	public int save(Producto producto);
	public int update(Producto producto);
	public int delete(int id);
}
