package com.drr.BelmemdocApiRest.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReseniaCreateDTO {
	
	private Integer idProducto;
	
	private Integer idUser;
	
	private String descripcionResenia;
	
	private Integer puntuacionResenia;

}
