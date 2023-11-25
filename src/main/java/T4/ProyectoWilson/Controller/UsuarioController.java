package T4.ProyectoWilson.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import T4.ProyectoWilson.Model.Usuario;

import T4.ProyectoWilson.Service.IUsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/list/{id}")
	public ResponseEntity<List<Usuario>> list(@PathVariable String id){
		var result  = iUsuarioService.obtenerDatos(id);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
