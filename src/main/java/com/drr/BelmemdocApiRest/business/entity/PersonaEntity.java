package com.drr.BelmemdocApiRest.business.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nu_docu", nullable = false)
	private String numeroDocumento;
	
	@Column(name="de_nomb_1", nullable = false)
	private String primerNombre;
	
	@Column(name="de_nomb_2", nullable = true)
	private String segundoNombre;
	
	@Column(name="de_ape_1", nullable = false)
	private String primerApellido;
	
	@Column(name="de_ape_2", nullable = true)
	private String segundoApellido;
	
	@Column(name="id_gene", nullable = false)
	private String genero;
	
	@Column(name="fe_naci", nullable = false)
	private String fechaNacimiento;
	
	@Column(name="de_tele", nullable = false)
	private String telefono;
	
	@Column(name="de_dire", nullable = false)
	private String direccion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;

}
