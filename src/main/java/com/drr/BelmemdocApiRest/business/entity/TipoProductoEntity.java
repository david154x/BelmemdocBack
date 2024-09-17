package com.drr.BelmemdocApiRest.business.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_producto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_prod")
	private Integer idTipoProducto;
	
	@Column(name="de_tipo_prod")
	private String nombreTipoProducto;
	
	@Column(name="id_acti", columnDefinition = "varchar(1)", nullable = false)
	private String idActivo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
	
}
