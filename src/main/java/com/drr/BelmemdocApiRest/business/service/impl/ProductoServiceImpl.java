package com.drr.BelmemdocApiRest.business.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drr.BelmemdocApiRest.business.dto.ProductoCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.MarcaEntity;
import com.drr.BelmemdocApiRest.business.entity.ProductoEntity;
import com.drr.BelmemdocApiRest.business.entity.TipoProductoEntity;
import com.drr.BelmemdocApiRest.business.repository.MarcaRepository;
import com.drr.BelmemdocApiRest.business.repository.ProductoRepository;
import com.drr.BelmemdocApiRest.business.repository.TipoProductoRepository;
import com.drr.BelmemdocApiRest.business.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public List<ProductoEntity> consultarTodosLosProductos() throws Exception {
		try {
			List<ProductoEntity> lstProductos = productoRepository.findAll();
			
			if(lstProductos != null && !lstProductos.isEmpty())
				return lstProductos;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductoEntity consultarProductoXId(Integer id) {
		try {
			Optional<ProductoEntity> optProductoEncontrado = productoRepository.findById(id);
			
			if(optProductoEncontrado.isPresent())
				return optProductoEncontrado.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductoEntity crearProducto(ProductoCreateDTO productoCreateDTO) {
		try {
			Optional<TipoProductoEntity> optTipoProductoEntity = tipoProductoRepository.findById(productoCreateDTO.getIdTipoProducto());
			Optional<MarcaEntity> optMarcaEntity = marcaRepository.findById(productoCreateDTO.getIdMarca());
            
            ProductoEntity productoCreado = productoRepository.save(ProductoEntity.builder()
            																	  .tipoProductoEntity(optTipoProductoEntity.get())
            																	  .marcaEntity(optMarcaEntity.get())
            																	  .nombreProducto(productoCreateDTO.getNombreProducto())
            																	  .descripcionProducto(productoCreateDTO.getDescripcionProducto())
            																	  .valorProducto(productoCreateDTO.getValorProducto())
            																	  .ubicacionFoto(productoCreateDTO.getUbicacionFoto())
            																	  .idActivo("A")
            																	  .fechaCreacion(new Date())
            																	  .build());
            
            if(productoCreado != null)
                return productoCreado;
            
        } catch (Exception e) {
        	e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductoEntity modificarProducto(ProductoUpdDTO productoUpdDTO) {
		try {
			ProductoEntity productoAModificar = consultarProductoXId(productoUpdDTO.getIdProducto());
			
			if(productoUpdDTO.getIdTipoProducto() != null) {
				Optional<TipoProductoEntity> optTipoProductoEntity = tipoProductoRepository.findById(productoUpdDTO.getIdTipoProducto());
				productoAModificar.setTipoProductoEntity(optTipoProductoEntity.get());
			}
			
			if(productoUpdDTO.getIdMarca() != null) {
				Optional<MarcaEntity> optMarcaEntity = marcaRepository.findById(productoUpdDTO.getIdMarca());
				productoAModificar.setMarcaEntity(optMarcaEntity.get());
			}
			
			ProductoEntity productoModificado = productoRepository.save(ProductoEntity.builder()
					                                                                  .idProducto(productoAModificar.getIdProducto())
					                                                                  .tipoProductoEntity(productoAModificar.getTipoProductoEntity())
					                                                                  .marcaEntity(productoAModificar.getMarcaEntity())
					                                                                  .nombreProducto(productoUpdDTO.getNewNombreProducto())
					                                                                  .descripcionProducto(productoUpdDTO.getNewDescripcionProducto())
					                                                                  .valorProducto(productoUpdDTO.getNewValorProducto())
					                                                                  .ubicacionFoto(productoUpdDTO.getNewUbicacionFoto())
					                                                                  .idActivo(productoUpdDTO.getIdActivo())
					                                                                  .fechaCreacion(productoAModificar.getFechaCreacion())
					                                                                  .build());
			
			if(productoModificado != null && !Objects.isNull(productoModificado))
				return productoModificado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean eliminarProducto(Integer id) {
		try {
			productoRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
