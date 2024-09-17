package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.MarcaUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.MarcaEntity;

public interface MarcaService {
	
	List<MarcaEntity> consultarTodasLasMarcas() throws Exception;
	
	MarcaEntity consultarMarcaXId(Integer id);
	
	MarcaEntity crearMarca(String nombreMarca);
	
	MarcaEntity modificarMarca(MarcaUpdateDTO marcaUpdateDTO);
	
	Boolean eliminarMarca(Integer id);

}
