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

import com.drr.BelmemdocApiRest.business.dto.RolUpdtDTO;
import com.drr.BelmemdocApiRest.business.entity.RolesEntity;
import com.drr.BelmemdocApiRest.business.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<RolesEntity> consultarTodosLosRoles() {
		try {
			List<RolesEntity> lstRoles =  rolService.consultarTodosLosRoles();
			
			if(lstRoles != null && !lstRoles.isEmpty())
				return lstRoles;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public RolesEntity consultarRolXId(@PathVariable Integer id) {
		try {
			RolesEntity rolEntity =  rolService.consultarRolXId(id);
			
			if (rolEntity != null && !Objects.isNull(rolEntity))
				return rolEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/{nombreRol}")
	public RolesEntity crearRol(@PathVariable String nombreRol) {
		try {
			
			RolesEntity rolesEntity = rolService.crearRol(nombreRol);

			if(rolesEntity != null)
				return rolesEntity;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public RolesEntity updateRol(@RequestBody RolUpdtDTO rolUpdtDTO) {
		try {
			
			RolesEntity rolModificado = rolService.modificarRol(rolUpdtDTO);
			
			if(rolModificado != null)
				return rolModificado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteRol(@PathVariable Integer id) {
		try {
			
			if(rolService.eliminarRol(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
