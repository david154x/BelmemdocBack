package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.RolUpdtDTO;
import com.drr.BelmemdocApiRest.business.entity.RolesEntity;

public interface RolService {

	List<RolesEntity> consultarTodosLosRoles() throws Exception;

	RolesEntity consultarRolXId(Integer id);

	RolesEntity crearRol(String nombreRol);

	RolesEntity modificarRol(RolUpdtDTO rolUpdtDTO);

	Boolean eliminarRol(Integer id);

}
