package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.TipoProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.TipoProductoEntity;

public interface TipoProductoService {
	
	List<TipoProductoEntity> consultarTodosLosTipoProductos() throws Exception;
	
	TipoProductoEntity consultarTipoProductoXId(Integer id);
	
	TipoProductoEntity crearTipoProducto(String nombreTipoProducto);
	
	TipoProductoEntity modificarTipoProducto(TipoProductoUpdDTO tipoProductoUpdDTO);
	
	Boolean eliminarTipoProducto(Integer id);

}
