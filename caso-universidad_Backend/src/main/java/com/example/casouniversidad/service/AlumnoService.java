package com.example.casouniversidad.service;

import java.util.List;
import java.util.Optional;

import com.example.casouniversidad.dto.AlumnoDto;
import com.example.casouniversidad.entity.Alumno;
import com.example.casouniversidad.entity.Carrera;
import com.example.casouniversidad.exceptions.AlumnoNoFoundExceptions;

public interface AlumnoService {
	List<Alumno> findAll();
	Alumno saveAlumno(Alumno alumno);
	Alumno updateAlumno(Long id, Alumno alumno);
	void deleteAlumno(Long id);
	Optional<Alumno> findByNombre(String nombre) throws AlumnoNoFoundExceptions;
	Optional<Alumno> findByNombreIgnoreCase(String nombre);


}
