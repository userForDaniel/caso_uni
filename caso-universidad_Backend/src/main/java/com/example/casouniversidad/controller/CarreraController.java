package com.example.casouniversidad.controller;

import java.util.List;
import java.util.Optional;

import com.example.casouniversidad.dto.CarreraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.casouniversidad.entity.Carrera;
import com.example.casouniversidad.service.CarreraService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/carrera")
public class CarreraController {
	
	@Autowired
	CarreraService carreraService;

	@GetMapping("listar")
	public List<Carrera> findAll(){
		return carreraService.findAll();
	}

	@GetMapping("/all/{nombre}")
	Optional<Carrera> indByNombreIgnoreCase(@PathVariable String nombre){
		return carreraService.findByNombreIgnoreCase(nombre);
	}

	@PostMapping("/agregar")
	public Carrera AgregarCarrera(@RequestBody Carrera carrera){
		return carreraService.saveCarrera(carrera);
	}

	@PutMapping("/{id}")
	public Carrera EditarCarrera(@PathVariable Long id, @RequestBody Carrera carrera){
		return  carreraService.updateCarrera(id, carrera);
	}

	@DeleteMapping("/{id}")
	public String EliminarCarrera(@PathVariable Long id){
		carreraService.deleteCarrera(id);
		return "Eliminado Correctamente";
	}
	//LISTADO DTO
	@GetMapping("/all02")
	public List<CarreraDto> findCarreraBylis(){
		return carreraService.findCarreraBy();
	}

}
