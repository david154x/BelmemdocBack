package com.drr.BelmemdocApiRest.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolUpdtDTO {
	
	private Integer idRol;

	private String nombreRol;

	private String idActivo;

}
