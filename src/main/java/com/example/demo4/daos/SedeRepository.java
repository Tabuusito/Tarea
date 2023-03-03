package com.example.demo4.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.entities.Sede_jjoo;

@Repository
public interface SedeRepository extends CrudRepository<Sede_jjoo,Integer>{

}
