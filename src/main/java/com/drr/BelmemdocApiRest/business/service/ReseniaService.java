package com.drr.BelmemdocApiRest.business.service;

import java.util.List;

import com.drr.BelmemdocApiRest.business.dto.ReseniaCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ReseniaUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.ReseniaEntity;

public interface ReseniaService {
	
	List<ReseniaEntity> buscarTodasLasResenias();
	
	ReseniaEntity buscarReseniaXId(Integer idResenia);
	
	ReseniaEntity guardarResenia(ReseniaCreateDTO reseniaCreateDTO);
	
	ReseniaEntity actualizarResenia(ReseniaUpdDTO reseniaUpdDTO);
	
	Boolean eliminarResenia(Integer idResenia);

}
