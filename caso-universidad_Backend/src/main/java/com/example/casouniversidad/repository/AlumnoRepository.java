package com.example.casouniversidad.repository;

import com.example.casouniversidad.dto.AlumnoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.casouniversidad.entity.Alumno;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    //CONSULTA DE LISTA POR NOMBRE SIN QUERY
    Optional<Alumno> findByNombre(String nombre);

    //CONSULTA DE LISTA POR NOMBRE PERO NO IMPORTA SI ES MAYUSCULA O MINUSCULA
    Optional<Alumno> findByNombreIgnoreCase(String nombre);


}
