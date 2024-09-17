package com.drr.BelmemdocApiRest.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaUpdDTO {
	
	private Integer idResenia;
	
	private Integer idNuevoProducto;
	
	private Integer idNuevoUsuario;
	
	private String nuevaDescripcionReseniaProducto;
	
	private Integer nuevaPuntuacionResenia;
	
}
