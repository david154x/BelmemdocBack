package com.drr.BelmemdocApiRest.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drr.BelmemdocApiRest.business.entity.UserRolEntity;

public interface UserRolRepository extends JpaRepository<UserRolEntity, Integer> {

}
