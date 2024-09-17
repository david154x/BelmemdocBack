package com.drr.BelmemdocApiRest.business.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drr.BelmemdocApiRest.business.dto.MenuRolDTO;
import com.drr.BelmemdocApiRest.business.dto.MenuRolesUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.MenuEntity;
import com.drr.BelmemdocApiRest.business.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<MenuEntity> consultarTodosLosMenus() {
		try {
			List<MenuEntity> lstMenus =  menuService.consultarTodosLosMenu();
			
			if (lstMenus != null && !lstMenus.isEmpty())
				return lstMenus;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public MenuEntity consultarMenuXId(@PathVariable Integer id) {
		try {
			MenuEntity menuEntity =  menuService.consultarMenuXId(id);
			
			if (menuEntity != null && !Objects.isNull(menuEntity))
				return menuEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public MenuEntity crearMenu(@RequestBody MenuRolDTO menuRolDTO) {
		try {
			
			MenuEntity menuCreado = menuService.crearMenu(menuRolDTO);

			if(menuCreado != null)
				return menuCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public MenuEntity updateMenu(@RequestBody MenuRolesUpdDTO menuRolesUpdDTO) {
		try {
			
			MenuEntity menuModificado = menuService.modificarMenu(menuRolesUpdDTO);
			
			if(menuModificado != null)
				return menuModificado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteMenu(@PathVariable Integer id) {
		try {
			
			if(menuService.eliminarMenu(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
