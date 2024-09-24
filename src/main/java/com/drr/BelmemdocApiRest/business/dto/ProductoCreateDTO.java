package com.drr.BelmemdocApiRest.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCreateDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idTipoProducto;

	private Integer idMarca;

	private String nombreProducto;

	private String descripcionProducto;

	private BigDecimal valorProducto;

	private byte[] ubicacionFoto;

}
