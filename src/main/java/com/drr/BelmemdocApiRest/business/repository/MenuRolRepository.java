package com.drr.BelmemdocApiRest.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drr.BelmemdocApiRest.business.entity.MenuEntity;

public interface MenuRolRepository extends JpaRepository<MenuEntity, Integer> {

}
