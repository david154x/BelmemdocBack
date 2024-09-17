package com.drr.BelmemdocApiRest.business.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Hidden
public class MarcaUpdateDTO {
	
	private Integer idMarca;
	
	private String nuevoNombreMarca;
	
	private String idActivo;

}
