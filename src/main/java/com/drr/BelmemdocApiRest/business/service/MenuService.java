package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.MenuRolDTO;
import com.drr.BelmemdocApiRest.business.dto.MenuRolesUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.MenuEntity;

public interface MenuService {
	
	List<MenuEntity> consultarTodosLosMenu() throws Exception;
	
	MenuEntity consultarMenuXId(Integer id);
	
	MenuEntity crearMenu(MenuRolDTO menuRolDTO);
	
	MenuEntity modificarMenu(MenuRolesUpdDTO menuRolesUpdDTO);
	
	Boolean eliminarMenu(Integer id);

}
