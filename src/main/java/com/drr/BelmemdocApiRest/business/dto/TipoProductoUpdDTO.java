package com.drr.BelmemdocApiRest.business.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoProductoUpdDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idTipoProducto;
	
	private String nuevoNombreTipoProducto;
	
	private String idActivo;

}
