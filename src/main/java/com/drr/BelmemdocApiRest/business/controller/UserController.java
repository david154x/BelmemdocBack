package com.drr.BelmemdocApiRest.business.controller;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drr.BelmemdocApiRest.business.dto.AutenticacionUserDTO;
import com.drr.BelmemdocApiRest.business.dto.AuthResponse;
import com.drr.BelmemdocApiRest.business.dto.UserCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.UserUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.UserEntity;
import com.drr.BelmemdocApiRest.business.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<UserEntity> consultarTodosLosUsuarios() {
		try {
			List<UserEntity> lstUsers =  userService.consultarTodosLosUsuarios();
			
			if (lstUsers != null && !lstUsers.isEmpty())
				return lstUsers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public UserEntity consultarUsuarioXId(@PathVariable Integer id) {
		try {
			UserEntity userEntity =  userService.consultarUsuarioXId(id);
			
			if (userEntity != null && !Objects.isNull(userEntity))
				return userEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public UserEntity crearUsuario(@RequestBody UserCreateDTO userCreateDTO) {
		try {
			
			UserEntity usuarioCreado = userService.crearUsuario(userCreateDTO);

			if (usuarioCreado != null)
				return usuarioCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public UserEntity updateUser(@RequestBody UserUpdDTO UserUpdateDTO) {
		try {
			UserEntity UserEntityModificado = userService.modificarUsuario(UserUpdateDTO);
			
			if (UserEntityModificado != null && !Objects.isNull(UserEntityModificado))
				return UserEntityModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Integer id) {
		try {
			
			if(userService.eliminarUsuario(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }
	
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody AutenticacionUserDTO autenticacionUserDTO) {
        try {
            
        	if ( this.userService.iniciarSesion(autenticacionUserDTO) ) {

                String token = Jwts.builder()
			                       .setSubject(autenticacionUserDTO.getEmail())
			                       .setIssuedAt(new Date()) // Fecha de emisión
			                       .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
			                       .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
			                       .compact();
                
                System.out.println(token);

                return ResponseEntity.ok(AuthResponse.builder()
                									 .token(token)
                									 .build());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }
        	
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el login");
        }
    }

}
