package com.example.demo4.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.daos.Tarea2Repository;
import com.example.demo4.dtos.ITarea2;

@RestController
@RequestMapping(path = "/tarea2",
				produces = MediaType.APPLICATION_JSON_VALUE)
public class Tarea2Controller {

    @Autowired
	private Tarea2Repository repo;
	
    
    @GetMapping()
	public ResponseEntity<List<ITarea2>> busquedaCompleja() {
		try {
			List<ITarea2> resultado = new ArrayList<>();			
			resultado = repo.busquedaCompleja();
			
			if (resultado.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}