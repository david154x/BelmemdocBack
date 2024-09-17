package com.drr.BelmemdocApiRest.business.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resenia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rese")
	private Integer idResenia;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prod", nullable = false)
    private ProductoEntity productoEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity userEntity;
	
	@Column(name = "de_desc_prod", nullable = false)
	private String descripcionReseniaProducto;
	
	@Column(name = "nu_punt_rese", nullable = false)
	private Integer puntuacionResenia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;

}
