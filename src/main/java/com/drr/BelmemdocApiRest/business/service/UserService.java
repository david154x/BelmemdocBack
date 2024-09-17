package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.AutenticacionUserDTO;
import com.drr.BelmemdocApiRest.business.dto.UserCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> consultarTodosLosUsuarios() throws Exception;
	
	UserEntity consultarUsuarioXId(Integer id);
	
	UserEntity crearUsuario(UserCreateDTO userCreateDTO);
	
	UserEntity modificarUsuario(UserUpdDTO UserUpdateDTO);
	
	Boolean eliminarUsuario(Integer id);
	
	Boolean iniciarSesion(AutenticacionUserDTO autenticacionUserDTO);

}
