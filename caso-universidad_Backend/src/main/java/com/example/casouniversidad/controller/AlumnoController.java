package com.example.casouniversidad.controller;

import java.util.List;
import java.util.Optional;

import com.example.casouniversidad.dto.AlumnoDto;
import com.example.casouniversidad.exceptions.AlumnoNoFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.casouniversidad.entity.Alumno;
import com.example.casouniversidad.service.AlumnoService;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("api/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping
	public List<Alumno> findAll(){
		return alumnoService.findAll();
	}

	@GetMapping("/all/{nombre}")
	Optional<Alumno> findByNombre(@PathVariable String nombre) throws AlumnoNoFoundExceptions {
		return alumnoService.findByNombre(nombre);
	}
	@GetMapping("/all2/{nombre}")
	Optional<Alumno> findByNombreIgnoreCase(@PathVariable String nombre){
		return  alumnoService.findByNombreIgnoreCase(nombre);
	}

	@PostMapping()
	public Alumno GuardarAlumno(@Valid @RequestBody Alumno alumno){
		return alumnoService.saveAlumno(alumno);
	}
	@PutMapping("/{id}")
	public Alumno ActualizarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		return  alumnoService.updateAlumno(id, alumno);

	}

	@DeleteMapping("/{id}")
	public String eliminarAlumno(@PathVariable Long id) {
		alumnoService.deleteAlumno(id);
		return "Eliminado Correctamente";
	}

	}
