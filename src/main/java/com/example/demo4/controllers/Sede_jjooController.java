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

import com.example.demo4.daos.SedeRepository;
import com.example.demo4.entities.Sede_jjoo;

@RestController
@RequestMapping(path = "/sedes",
				produces = MediaType.APPLICATION_JSON_VALUE)
public class Sede_jjooController {

	@Autowired
	private SedeRepository repo;
	
    @GetMapping()
	public ResponseEntity<List<Sede_jjoo>> buscarTodos() {
		try {
			List<Sede_jjoo> resultado = new ArrayList<>();			
			for(Sede_jjoo sede:repo.findAll()) {
				resultado.add(sede);
			}
			if (resultado.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @GetMapping(path = "/{anho}")
	public ResponseEntity<Sede_jjoo> buscarPorClave(@PathVariable("anho") Integer anho) {
		Optional<Sede_jjoo> sede;
		try {
			sede = repo.findById(anho);
			
			if (sede.isPresent()) {
				return new ResponseEntity<>(sede.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping(path = "/{anho}")
	public ResponseEntity<HttpStatus> eliminar(@PathVariable("anho") Integer anho) {
		try {
			Optional<Sede_jjoo> sede = repo.findById(anho);
			if (sede.isPresent()) {
				repo.delete(sede.get());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{anho}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sede_jjoo> modificar(@PathVariable("anho") Integer anho, @RequestBody Sede_jjoo sede) {
		Optional<Sede_jjoo> sedeOptional;
		try {
			sedeOptional = repo.findById(anho);
			
			if (sedeOptional.isPresent()) {
				Sede_jjoo nuevaSede = repo.save(sede);
				return new ResponseEntity<>(nuevaSede, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sede_jjoo> crear(@RequestBody Sede_jjoo sede) {
		try {
			Integer anho = sede.getAnho();
			if ((anho != null) && anho != 0) {
				Optional<Sede_jjoo> sedeOptional = repo.findById(anho);

				if (sedeOptional.isEmpty()) {
					Sede_jjoo nuevaSede = repo.save(sede);
					URI uri = crearURISede(nuevaSede);

					return ResponseEntity.created(uri).body(nuevaSede);

				}
			}
			// No aporta anho o anho ya existe
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Construye la URI del nuevo recurso creado con POST 
	private URI crearURISede(Sede_jjoo sede) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{anho}")
		.buildAndExpand(sede.getAnho())
		.toUri();				
	}
	
}