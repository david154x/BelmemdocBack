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
public class ProductoUpdDTO {
	
	private Integer idProducto;

	private Integer idTipoProducto;

	private Integer idMarca;

	private String newNombreProducto;

	private String newDescripcionProducto;

	private BigDecimal newValorProducto;

	private String newUbicacionFoto;
	
	private String idActivo;

}
