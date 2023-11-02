package com.example.casouniversidad.service;

import java.util.List;
import java.util.Optional;

import com.example.casouniversidad.dto.CarreraDto;
import com.example.casouniversidad.entity.Carrera;

public interface CarreraService {
	
	List<Carrera> findAll();

	Carrera saveCarrera(Carrera carrera);
	Carrera updateCarrera(Long id,Carrera carrera);
	void deleteCarrera(Long id);
	Optional<Carrera> findByNombreIgnoreCase(String nombre);

	List<CarreraDto> findCarreraBy();

}
