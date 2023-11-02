package com.example.casouniversidad.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.casouniversidad.dto.CarreraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casouniversidad.entity.Carrera;
import com.example.casouniversidad.repository.CarreraRepository;
import com.example.casouniversidad.service.CarreraService;

@Service
public class CarreraServiceImpl  implements CarreraService{
	
	@Autowired
	CarreraRepository carreraRepository;

	@Override
	public List<Carrera> findAll() {
		return carreraRepository.findAll();
	}



	@Override
	public Carrera saveCarrera(Carrera carrera) {
		return carreraRepository.save(carrera);
	}

	@Override
	public Carrera updateCarrera(Long id, Carrera carrera) {
		Carrera carreraBD = carreraRepository.findById(id).get();
		if (Objects.nonNull(carrera.getNombre()) && !"".equalsIgnoreCase(carrera.getNombre())){
			carreraBD.setNombre(carrera.getNombre());
		}
		return carreraRepository.save(carreraBD);
	}

	@Override
	public void deleteCarrera(Long id) {
		carreraRepository.deleteById(id);

	}

	@Override
	public Optional<Carrera> findByNombreIgnoreCase(String nombre) {
		return carreraRepository.findByNombreIgnoreCase(nombre);
	}

	@Override
	public List<CarreraDto> findCarreraBy() {
		return carreraRepository.findCarreraBy();
	}

}
