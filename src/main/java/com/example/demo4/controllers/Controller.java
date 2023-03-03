package com.example.demo4.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo4.daos.CiudadRepository;
import com.example.demo4.entities.Ciudad;

@RestController
@RequestMapping(path = "/ciudades", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

	@Autowired
	private CiudadRepository ciudadRepository;

	@GetMapping()
	public ResponseEntity<List<Ciudad>> buscarTodos() {
		try {
			List<Ciudad> resultado = new ArrayList<>();
			Iterable<Ciudad> iterable = ciudadRepository.findAll();
			for (Ciudad c : iterable) {
				resultado.add(c);
			}

			if (resultado.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id_ciudad}")
	public ResponseEntity<Ciudad> buscarPorClave(@PathVariable("id_ciudad") Integer id_ciudad) {
		Optional<Ciudad> ciudad;
		try {
			ciudad = ciudadRepository.findById(id_ciudad);

			if (ciudad.isPresent()) {
				return new ResponseEntity<>(ciudad.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	  @DeleteMapping(path = "/{id_ciudad}") 
	  public ResponseEntity<HttpStatus> eliminar(@PathVariable("id_ciudad") Integer id_ciudad) { 
		  try {
			  	Optional<Ciudad> ciudad = ciudadRepository.findById(id_ciudad); 
			  	if(ciudad.isPresent()) { 
			  		ciudadRepository.delete(ciudad.get()); 
			  		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			  	} 
			  	else { 
			  		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			  	}
	  
		  } catch (Exception e) { 
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		  	}
	  }
	  
	  @PutMapping(path = "/{id_ciudad}", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Ciudad> modificar(@PathVariable("id_ciudad") Integer id_ciudad, @RequestBody Ciudad ciudad) {
			Optional<Ciudad> ciudadOptional;
			try {
				ciudadOptional = ciudadRepository.findById(id_ciudad);
				
				if (ciudadOptional.isPresent()) {
					Ciudad nuevaCiudad = ciudadRepository.save(ciudad);
					return new ResponseEntity<>(nuevaCiudad, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	  
	  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Ciudad> crear(@RequestBody Ciudad ciudad) {
			try {
				Integer id_ciudad = ciudad.getId();
				if ((id_ciudad != null) && id_ciudad != 0) {
					Optional<Ciudad> ciudadOptional = ciudadRepository.findById(id_ciudad);

					if (ciudadOptional.isEmpty()) {
						Ciudad nuevaCiudad = ciudadRepository.save(ciudad);
						URI uri = crearURICiudad(nuevaCiudad);

						return ResponseEntity.created(uri).body(nuevaCiudad);

					}
				}
				// No aporta id_ciudad o id_ciudad ya existe
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	  
	// Construye la URI del nuevo recurso creado con POST 
		private URI crearURICiudad(Ciudad ciudad) {
			return ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id_ciudad}")
			.buildAndExpand(ciudad.getId())
			.toUri();				
		}
	 

}