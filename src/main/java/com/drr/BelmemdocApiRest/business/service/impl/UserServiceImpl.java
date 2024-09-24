package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.AutenticacionUserDTO;
import com.drr.BelmemdocApiRest.business.dto.UserCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.PersonaEntity;
import com.drr.BelmemdocApiRest.business.entity.UserEntity;
import com.drr.BelmemdocApiRest.business.repository.PersonaRepository;
import com.drr.BelmemdocApiRest.business.repository.UserRepository;
import com.drr.BelmemdocApiRest.business.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonaRepository personaRepository; 

	@Override
	public List<UserEntity> consultarTodosLosUsuarios() throws Exception {
		try {
			
			List<UserEntity> lstUsers = userRepository.findAll();
			
			if(lstUsers == null || lstUsers.isEmpty())
				throw new Exception("No se encontraron usuarios");
			
			return lstUsers;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserEntity consultarUsuarioXId(Integer id) {
		try {
			Optional<UserEntity> optUsuarioEncontrado = userRepository.findById(id);
			
			if(!optUsuarioEncontrado.isPresent())
				throw new Exception("No se encontro el usuario con la id: "+id+" enviado.");
			
			return optUsuarioEncontrado.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UserEntity crearUsuario(UserCreateDTO userCreateDTO) {
		try {
			PersonaEntity personaCreada = personaRepository.save(PersonaEntity.builder()
                                                                              .numeroDocumento(userCreateDTO.getNumeroDocumento())
                                                                              .primerNombre(userCreateDTO.getPrimerNombre())
                                                                              .segundoNombre(userCreateDTO.getSegundoNombre())
                                                                              .primerApellido(userCreateDTO.getPrimerApellido())
                                                                              .segundoApellido(userCreateDTO.getSegundoApellido())
                                                                              .genero(userCreateDTO.getGenero())
                                                                              .fechaNacimiento(userCreateDTO.getFechaNacimiento())
                                                                              .telefono(userCreateDTO.getTelefono())
                                                                              .direccion(userCreateDTO.getDireccion())
                                                                              .fechaCreacion(new Date())
                                                                              .build());
			
			
			UserEntity usuarioCreado = userRepository.save(UserEntity.builder()
					                                                 .nombreUsuario(userCreateDTO.getNombreUsuario())
					                                                 .contraseniaUsuario(userCreateDTO.getClaveAsignada())
					                                                 .personaEntity(personaCreada)
					                                                 .idActivo("A")
					                                                 .fechaCreacion(new Date())
					                                                 .build());

			if (usuarioCreado != null && !Objects.isNull(usuarioCreado))
				return usuarioCreado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserEntity modificarUsuario(UserUpdDTO UserUpdateDTO) {
		try {
			UserEntity usuarioEncontrado = consultarUsuarioXId(UserUpdateDTO.getId());
			
			if(usuarioEncontrado == null && Objects.isNull(usuarioEncontrado))
				throw new Exception("No se encontro el usuario con la id: " + UserUpdateDTO.getId() + " enviado, no se puede modificar el usuario.");
			
			usuarioEncontrado.setNombreUsuario(UserUpdateDTO.getNombreUsuario());
			usuarioEncontrado.setContraseniaUsuario(UserUpdateDTO.getClaveUsuario());
			usuarioEncontrado.setIdActivo(UserUpdateDTO.getIdActivo());
			
			UserEntity usuarioModificado = userRepository.save(usuarioEncontrado);
			
			if(usuarioModificado == null && Objects.isNull(usuarioModificado))
				throw new Exception("No se pudo modificar el usuario.");
			
			return usuarioModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarUsuario(Integer id) {
		try {
			userRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean iniciarSesion(AutenticacionUserDTO autenticacionUserDTO) {
		try {
			
			UserEntity usuarioEncontrado = this.userRepository.findByNombreUsuario(autenticacionUserDTO.getEmail());
			
			if ( usuarioEncontrado != null && !Objects.isNull(usuarioEncontrado) ) {
				
				if ( usuarioEncontrado.getContraseniaUsuario().equals(autenticacionUserDTO.getPassword()) )
					return Boolean.TRUE;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
