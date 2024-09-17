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

import com.drr.BelmemdocApiRest.business.dto.UserRolCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserRolUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.UserRolEntity;
import com.drr.BelmemdocApiRest.business.service.UserRolService;

@RestController
@RequestMapping("/userRol")
public class UserRolController {
	
	@Autowired
	private UserRolService userRolService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<UserRolEntity> consultarTodosLosRolesXUsuarios() {
		try {
			List<UserRolEntity> lstUsersRoles =  userRolService.consultarTodosLosRolesUsuario();
			
			if(lstUsersRoles != null && !lstUsersRoles.isEmpty())
				return lstUsersRoles;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public UserRolEntity consultarRolUsuarioXId(@PathVariable Integer id) {
		try {
			UserRolEntity userRolEntity = userRolService.consultarRolUsuarioXId(id);
			
			if(userRolEntity != null && !Objects.isNull(userRolEntity))
				return userRolEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public List<UserRolEntity> crearRolUsuario(@RequestBody UserRolCreateDTO userRolCreateDTO) {
		try {
			
			List<UserRolEntity> lstUsersRoles = userRolService.crearRolUsuario(userRolCreateDTO);

			if(lstUsersRoles != null && !lstUsersRoles.isEmpty())
				return lstUsersRoles;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public UserRolEntity updateRolUser(@RequestBody UserRolUpdateDTO userRolUpdateDTO) {
        try {
        	UserRolEntity userRolEntityModificado = userRolService.modificarRolUsuario(userRolUpdateDTO);
			
			if(userRolEntityModificado != null && !Objects.isNull(userRolEntityModificado))
				return userRolEntityModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteRolUser(@PathVariable Integer id) {
		try {
			
			if(userRolService.eliminarRolUsuario(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
