package com.drr.BelmemdocApiRest.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drr.BelmemdocApiRest.business.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, String>  {

}
