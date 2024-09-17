package com.drr.BelmemdocApiRest.business.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCreateDTO {
	
	private Integer idTipoProducto;

	private Integer idMarca;

	private String nombreProducto;

	private String descripcionProducto;

	private BigDecimal valorProducto;

	private String ubicacionFoto;

}
