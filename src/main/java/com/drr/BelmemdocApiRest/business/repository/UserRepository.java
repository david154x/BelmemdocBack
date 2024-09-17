package com.drr.BelmemdocApiRest.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drr.BelmemdocApiRest.business.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByNombreUsuario(String nombreUsuario);

}
