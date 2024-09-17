package com.drr.BelmemdocApiRest.business.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuRolesUpdDTO {
	
	private Integer idMenu;
	
	private String nuevoNombreMenu;
	
	private String nuevaRuta;
	
	private String idActivo;
	
	private List<Integer> lstIdRoles;

}
