package T4.ProyectoWilson.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import T4.ProyectoWilson.Model.Producto;
import T4.ProyectoWilson.Repository.ProductoRepository;


@Service
public class ProductoService implements IProductoService{
    @Autowired
	private ProductoRepository productoRepository;
	@Override
	public List<Producto> findAll() {
		List<Producto> list;
		try {
			list=productoRepository.findAll();
		}catch (Exception ex) {
			throw ex;
		}
		return list;
	}

	@Override
	public int save(Producto producto) {
		int row;
		try {
			row=productoRepository.save(producto);
		}catch (Exception ex) {
			throw ex;
		}
		return row;
	}

	@Override
	public int update(Producto producto) {
		int row;
		try {
			row=productoRepository.update(producto);
		}catch (Exception ex) {
			throw ex;
		}
		return row;
	}

	@Override
	public int delete(int id) {
		int row;
		try {
			row=productoRepository.delete(id);
		}catch (Exception ex) {
			throw ex;
		}
		return row;
	}
}
