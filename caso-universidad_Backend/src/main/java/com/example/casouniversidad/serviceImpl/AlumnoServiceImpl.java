package com.example.casouniversidad.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.casouniversidad.dto.AlumnoDto;
import com.example.casouniversidad.entity.Carrera;
import com.example.casouniversidad.exceptions.AlumnoNoFoundExceptions;
import com.example.casouniversidad.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casouniversidad.entity.Alumno;
import com.example.casouniversidad.repository.AlumnoRepository;
import com.example.casouniversidad.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno saveAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno updateAlumno(Long id, Alumno alumno) {
		Alumno alumnoBD = alumnoRepository.findById(id).get();
		if (Objects.nonNull(alumno.getNombre()) && !"".equalsIgnoreCase(alumno.getNombre())){
			alumnoBD.setNombre(alumno.getNombre());

		}if (Objects.nonNull(alumno.getApellido()) && !"".equalsIgnoreCase(alumno.getApellido())){
			alumnoBD.setApellido(alumno.getApellido());

		}if (Objects.nonNull(alumno.getTelefono()) && !"".equalsIgnoreCase(alumno.getTelefono())){
			alumnoBD.setTelefono(alumno.getTelefono());

		}if (Objects.nonNull(alumno.getCorreo()) && !"".equalsIgnoreCase(alumno.getCorreo())){
			alumnoBD.setCorreo(alumno.getCorreo());
		}
		return alumnoRepository.save(alumnoBD);
	}

	@Override
	public void deleteAlumno(Long id) {
		 alumnoRepository.deleteById(id);

	}

	@Override
	public Optional<Alumno> findByNombre(String nombre) throws AlumnoNoFoundExceptions {
		Optional<Alumno> alumno1 = alumnoRepository.findByNombre(nombre);
		if (!alumno1.isPresent()){
			throw new AlumnoNoFoundExceptions("El nombre no esta presente");
		}
		return alumno1;
	}

	@Override
	public Optional<Alumno> findByNombreIgnoreCase(String nombre) {
		return alumnoRepository.findByNombreIgnoreCase(nombre);
	}


}
