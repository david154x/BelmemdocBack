package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.ProductoCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.ProductoEntity;

public interface ProductoService {
	
	List<ProductoEntity> consultarTodosLosProductos() throws Exception;

	ProductoEntity consultarProductoXId(Integer id);

	ProductoEntity crearProducto(ProductoCreateDTO productoCreateDTO);

	ProductoEntity modificarProducto(ProductoUpdDTO productoUpdDTO);

	Boolean eliminarProducto(Integer id);

}
