package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.MarcaUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.MarcaEntity;
import com.drr.BelmemdocApiRest.business.repository.MarcaRepository;
import com.drr.BelmemdocApiRest.business.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public List<MarcaEntity> consultarTodasLasMarcas() throws Exception {
		try {
			
			List<MarcaEntity> lstMarcas = marcaRepository.findAll();
			
			if(lstMarcas == null || lstMarcas.isEmpty())
				throw new Exception("No se encontraron marcas");
			
			return lstMarcas;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public MarcaEntity consultarMarcaXId(Integer id) {
		try {
			Optional<MarcaEntity> optMarcaEncontrada = marcaRepository.findById(id);
			
			if(!optMarcaEncontrada.isPresent())
				throw new Exception("No se encontro el usuario con la id: "+id+" enviado.");
			
			return optMarcaEncontrada.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MarcaEntity crearMarca(String nombreMarca) {
		try {
			MarcaEntity marcaCreada = marcaRepository.save(MarcaEntity.builder()
																	  .nombre(nombreMarca)
																	  .idActivo("A")
																	  .fechaCreacion(new Date())
																	  .build());

			if (marcaCreada != null && !Objects.isNull(marcaCreada))
				return marcaCreada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MarcaEntity modificarMarca(MarcaUpdateDTO marcaUpdateDTO) {
		try {
			MarcaEntity marcaEncontrada = consultarMarcaXId(marcaUpdateDTO.getIdMarca());
			
			if(marcaEncontrada == null && Objects.isNull(marcaEncontrada))
				throw new Exception("No se encontro la marca con id: " + marcaUpdateDTO.getIdMarca() + " enviado, no se puede modificar la marca.");
			
			marcaEncontrada.setNombre(marcaUpdateDTO.getNuevoNombreMarca());
			marcaEncontrada.setIdActivo(marcaUpdateDTO.getIdActivo());
			
			MarcaEntity marcaModificada = marcaRepository.save(marcaEncontrada);
			
			if(marcaModificada == null && Objects.isNull(marcaModificada))
				throw new Exception("No se pudo modificar la marca.");
			
			return marcaModificada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarMarca(Integer id) {
		try {
			marcaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

}
