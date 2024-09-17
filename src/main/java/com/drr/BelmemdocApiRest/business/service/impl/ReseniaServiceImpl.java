package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.ReseniaCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ReseniaUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.ProductoEntity;
import com.drr.BelmemdocApiRest.business.entity.ReseniaEntity;
import com.drr.BelmemdocApiRest.business.entity.UserEntity;
import com.drr.BelmemdocApiRest.business.repository.ProductoRepository;
import com.drr.BelmemdocApiRest.business.repository.ReseniaRepository;
import com.drr.BelmemdocApiRest.business.repository.UserRepository;
import com.drr.BelmemdocApiRest.business.service.ReseniaService;

@Service
public class ReseniaServiceImpl implements ReseniaService {
	
	@Autowired
	private ReseniaRepository reseniaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<ReseniaEntity> buscarTodasLasResenias() {
		try {
			List<ReseniaEntity> lstResenias = reseniaRepository.findAll();
			
			if (lstResenias != null && !lstResenias.isEmpty())
				return lstResenias;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReseniaEntity buscarReseniaXId(Integer idResenia) {
		try {
			Optional<ReseniaEntity> optResenia = reseniaRepository.findById(idResenia);
			
			if(optResenia.isPresent())
                return optResenia.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReseniaEntity guardarResenia(ReseniaCreateDTO reseniaCreateDTO) {
		try {
			Optional<ProductoEntity> optProducto = productoRepository.findById(reseniaCreateDTO.getIdProducto());
			Optional<UserEntity> optUser = userRepository.findById(reseniaCreateDTO.getIdUser());
			
			ReseniaEntity reseniaCreada = reseniaRepository.save(ReseniaEntity.builder()
																			  .productoEntity(optProducto.get())
																			  .userEntity(optUser.get())
																			  .descripcionReseniaProducto(reseniaCreateDTO.getDescripcionResenia())
																			  .puntuacionResenia(reseniaCreateDTO.getPuntuacionResenia())
																			  .fechaCreacion(new Date())
																			  .build());
			
			if (reseniaCreada != null && !Objects.isNull(reseniaCreada))
				return reseniaCreada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReseniaEntity actualizarResenia(ReseniaUpdDTO reseniaUpdDTO) {
		try {
			Optional<ReseniaEntity> optResenia = reseniaRepository.findById(reseniaUpdDTO.getIdResenia());
			Optional<ProductoEntity> optProducto = productoRepository.findById(reseniaUpdDTO.getIdNuevoProducto());
			Optional<UserEntity> optUser = userRepository.findById(reseniaUpdDTO.getIdNuevoUsuario());
			
			optResenia.get().setProductoEntity(optProducto.get());
			optResenia.get().setUserEntity(optUser.get());
			optResenia.get().setDescripcionReseniaProducto(reseniaUpdDTO.getNuevaDescripcionReseniaProducto());
			optResenia.get().setPuntuacionResenia(reseniaUpdDTO.getNuevaPuntuacionResenia());
			
			ReseniaEntity reseniaActualizada = reseniaRepository.save(optResenia.get());
			
			if(reseniaActualizada != null && !Objects.isNull(reseniaActualizada))
				return reseniaActualizada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarResenia(Integer idResenia) {
		try {
			reseniaRepository.deleteById(idResenia);
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
