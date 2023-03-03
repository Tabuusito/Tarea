package com.example.demo4.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo4.dtos.ITarea2;
import com.example.demo4.entities.Pais;

@Repository
public interface Tarea2Repository extends CrudRepository<Pais,Integer>{

	
	@Query(value = "SELECT p.id_pais AS idPais, p.nombre_pais AS nombrePais, c.id_ciudad AS idCiudad, c.nombre_ciudad AS nombreCiudad, "
			+ "IFNULL(c.valor_ciudad, p.valor_pais) AS valor, t.descripcion_tipo AS descripcion , count(s.sede) AS numVecesSede "
			+ "FROM Ciudad c INNER JOIN Pais p ON c.id_pais = p.id_pais "
			+ "INNER JOIN Sede_jjoo s ON c.id_ciudad = s.sede "
			+ "INNER JOIN Tipo_jjoo t ON s.id_tipo_jjoo = t.id_tipo_jjoo "
			+ "GROUP BY c.id_pais, p.nombre_pais, c.id_ciudad, c.nombre_ciudad, valor, s.id_tipo_jjoo "
			, nativeQuery = true)
	public List<ITarea2> busquedaCompleja();
}

/*@Query("SELECT new com.example.demo4.dtos.Tarea2DTO(p.id_pais, p.nombre_pais, c.id_ciudad, c.nombre_ciudad) "
		+ "FROM Ciudad c INNER JOIN Pais p ON c.pais.id_pais = p.id_pais")
public List<Tarea2DTO> busqueda();*/