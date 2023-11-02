package com.example.casouniversidad.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ALUMNO")
public class Alumno {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_ALUMNO")
	    private Long id;
	    @NotBlank(message = "Ingrese un nombre") //EN EL CONTROLLER SE AGREGA
	    @Column(name = "NOMBRE")
	    private String nombre;

	    @NotBlank(message = "Ingrese un apellido")
		@Column(name = "APELLIDO")
	    private String apellido;

	    @Length(min = 9, max = 9)
		@Column(name = "TELEFONO")
	    private String telefono;

	    @Column(name = "CORREO")
	    private String correo;
	    
	    @ManyToOne
	    @JoinColumn(name = "id" , referencedColumnName = "ID_CARRERA") 
	    private Carrera carrera;

}
