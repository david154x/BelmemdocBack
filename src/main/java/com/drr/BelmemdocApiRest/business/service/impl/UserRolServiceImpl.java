package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.UserRolCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserRolUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.RolesEntity;
import com.drr.BelmemdocApiRest.business.entity.UserEntity;
import com.drr.BelmemdocApiRest.business.entity.UserRolEntity;
import com.drr.BelmemdocApiRest.business.repository.RolesRepository;
import com.drr.BelmemdocApiRest.business.repository.UserRepository;
import com.drr.BelmemdocApiRest.business.repository.UserRolRepository;
import com.drr.BelmemdocApiRest.business.service.UserRolService;

@Service
public class UserRolServiceImpl implements UserRolService {
	
	@Autowired
	private UserRolRepository userRolRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserRolEntity> consultarTodosLosRolesUsuario() throws Exception {
		try {
			List<UserRolEntity> lstUserRol = userRolRepository.findAll();
			
			if(lstUserRol != null && !lstUserRol.isEmpty())
				return lstUserRol;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserRolEntity consultarRolUsuarioXId(Integer id) {
		try {
			Optional<UserRolEntity> userRol = userRolRepository.findById(id);
			
			if(userRol.isPresent())
				return userRol.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserRolEntity> crearRolUsuario(UserRolCreateDTO userRolCreateDTO) {
		List<UserRolEntity> lstRet = null;
		try {
			
			if(userRolCreateDTO != null && !userRolCreateDTO.getLstRolesAsignados().isEmpty()){
				
				lstRet = new ArrayList<>();
				
				for(Integer rol : userRolCreateDTO.getLstRolesAsignados()) {
					
					Optional<RolesEntity> optRolEntity = rolesRepository.findById(rol);
					
					if(optRolEntity.isPresent()) {
						
						Optional<UserEntity> optUserEntity = userRepository.findById(userRolCreateDTO.getIdUsuario());
						
						UserRolEntity userRolCreado = userRolRepository.save(UserRolEntity.builder()
	                            														  .user(optUserEntity.get())
	                            														  .rol(optRolEntity.get())
	                            														  .fechaCreacion(new Date())
	                            														  .build());
						
						if(userRolCreado != null && !Objects.isNull(userRolCreado))
							lstRet.add(userRolCreado);
						
					}
					
				}
				
				if (lstRet != null && !lstRet.isEmpty())
					return lstRet;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserRolEntity modificarRolUsuario(UserRolUpdateDTO userRolUpdateDTO) {
		try {
			
			Optional<UserRolEntity> optUserRolEntity = userRolRepository.findById(userRolUpdateDTO.getIdRolUser());
			Optional<RolesEntity> optRolEntiy = rolesRepository.findById(userRolUpdateDTO.getIdNuevoRol());
			Optional<UserEntity> optUserEntity = userRepository.findById(userRolUpdateDTO.getIdUser());
			
			optUserRolEntity.get().setRol(optRolEntiy.get());
			optUserRolEntity.get().setUser(optUserEntity.get());
			
			UserRolEntity userRolModificado = userRolRepository.save(optUserRolEntity.get());
			
			if (userRolModificado != null && !Objects.isNull(userRolModificado))
				return userRolModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarRolUsuario(Integer id) {
		try {
			userRolRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
