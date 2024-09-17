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
public class MenuRolDTO {
	
	private String nombreMenu;
	
	private String rutaURL;
	
	private List<Integer> lstIdRoles;
	
}
