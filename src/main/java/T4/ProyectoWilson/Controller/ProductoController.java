package T4.ProyectoWilson.Controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import T4.ProyectoWilson.Model.Producto;
import T4.ProyectoWilson.Model.ServiceResponse;
import T4.ProyectoWilson.Service.IProductoService;


@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin("*")

public class ProductoController {
    @Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Producto>> list(){
		var result  = iProductoService.findAll();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	@PostMapping(value="/save",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> save(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("precio_unitario") float precio_unitario,
            @RequestParam("imagen") MultipartFile  imagen,
			@RequestParam("id_producto_categoria") int id_producto_categoria
            ) throws IOException{
			Producto producto= new Producto();
		ServiceResponse serviceResponse = new ServiceResponse();
        producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio_unitario(precio_unitario);
        producto.setImagen(imagen.getBytes());
		producto.setId_producto_categoria(id_producto_categoria);
		int result= iProductoService.save(producto);
		if(result==1) {
			serviceResponse.setMenssage("El producto se registro correctamente.");
			
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
	
	@PostMapping(value="/update",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> update(
			@RequestParam("id_producto") int id_producto,
			@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("precio_unitario") float precio_unitario,
            @RequestParam("imagen") MultipartFile  imagen,
			@RequestParam("id_producto_categoria") int id_producto_categoria)throws IOException{
			Producto producto= new Producto();
		ServiceResponse serviceResponse = new ServiceResponse();
		producto.setId_producto(id_producto);
        producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio_unitario(precio_unitario);
        producto.setImagen(imagen.getBytes());
		producto.setId_producto_categoria(id_producto_categoria);
		int result= iProductoService.update(producto);
		if(result==1) {
			serviceResponse.setMenssage("El producto se modifico correctamente.");
			
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}

	/* 
	@PostMapping("/update")
	public ResponseEntity<ServiceResponse> update(@RequestBody Producto producto){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result= iProductoService.update(producto);
		if(result==1) {
			serviceResponse.setMenssage("El producto se modifico correctamente.");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
	*/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result= iProductoService.delete(id);
		if(result==1) {
			serviceResponse.setMenssage("El producto se elimino correctamente.");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
}
