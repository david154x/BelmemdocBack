package com.drr.BelmemdocApiRest.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRolUpdateDTO {
	
	private Integer idRolUser;
	
	private Integer idUser;
	
	private Integer idNuevoRol;

}
