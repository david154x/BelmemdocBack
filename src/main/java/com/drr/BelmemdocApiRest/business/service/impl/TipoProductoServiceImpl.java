package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.TipoProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.TipoProductoEntity;
import com.drr.BelmemdocApiRest.business.repository.TipoProductoRepository;
import com.drr.BelmemdocApiRest.business.service.TipoProductoService;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;

	@Override
	public List<TipoProductoEntity> consultarTodosLosTipoProductos() throws Exception {
		try {
			List<TipoProductoEntity> lstTipoProducto = tipoProductoRepository.findAll();
			
			if (lstTipoProducto != null && !lstTipoProducto.isEmpty())
				return lstTipoProducto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TipoProductoEntity consultarTipoProductoXId(Integer id) {
		try {
			Optional<TipoProductoEntity> tipoProducto = tipoProductoRepository.findById(id);
			
			if(tipoProducto.isPresent())
                return tipoProducto.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TipoProductoEntity crearTipoProducto(String nombreTipoProducto) {
		try {
			TipoProductoEntity tipoProductoCreado = tipoProductoRepository.save(TipoProductoEntity.builder()
                    																			  .nombreTipoProducto(nombreTipoProducto)
                    																			  .idActivo("A")
                    																			  .fechaCreacion(new Date())
                    																			  .build());
			
			if(tipoProductoCreado != null && !Objects.isNull(tipoProductoCreado))
				return tipoProductoCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TipoProductoEntity modificarTipoProducto(TipoProductoUpdDTO tipoProductoUpdDTO) {
		try {
			TipoProductoEntity tipoProductoActual = consultarTipoProductoXId(tipoProductoUpdDTO.getIdTipoProducto());
			tipoProductoActual.setNombreTipoProducto(tipoProductoUpdDTO.getNuevoNombreTipoProducto());
			tipoProductoActual.setIdActivo(tipoProductoUpdDTO.getIdActivo());
			
			TipoProductoEntity tipoProductoModificado = tipoProductoRepository.save(tipoProductoActual);
			
			if (tipoProductoModificado != null && !Objects.isNull(tipoProductoModificado))
				return tipoProductoModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarTipoProducto(Integer id) {
		try {
			tipoProductoRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
