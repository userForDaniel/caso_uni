package com.example.casouniversidad.dto;

import com.example.casouniversidad.entity.Carrera;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class AlumnoDto {

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private Carrera carrera;

}
