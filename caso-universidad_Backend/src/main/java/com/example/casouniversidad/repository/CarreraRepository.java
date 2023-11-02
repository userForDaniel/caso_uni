package com.example.casouniversidad.repository;

import com.example.casouniversidad.dto.CarreraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.casouniversidad.entity.Carrera;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    Optional<Carrera> findByNombreIgnoreCase(String nombre);

    //dto
    List<CarreraDto> findCarreraBy();
}
