package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.UserRolCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserRolUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.UserRolEntity;

public interface UserRolService {
	
	 List<UserRolEntity> consultarTodosLosRolesUsuario() throws Exception;

	 UserRolEntity consultarRolUsuarioXId(Integer id);

	 List<UserRolEntity> crearRolUsuario(UserRolCreateDTO userRolCreateDTO);

	 UserRolEntity modificarRolUsuario(UserRolUpdateDTO userRolUpdateDTO);

	 Boolean eliminarRolUsuario(Integer id);

}
