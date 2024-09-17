package com.drr.BelmemdocApiRest.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drr.BelmemdocApiRest.business.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
