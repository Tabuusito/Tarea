package com.example.demo4.daos;

import java.util.Collections;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.entities.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {

    
}