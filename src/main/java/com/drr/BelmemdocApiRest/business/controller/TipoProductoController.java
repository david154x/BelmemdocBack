package com.drr.BelmemdocApiRest.business.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drr.BelmemdocApiRest.business.dto.TipoProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.TipoProductoEntity;
import com.drr.BelmemdocApiRest.business.service.TipoProductoService;

@RestController
@RequestMapping("/tipoProducto")
public class TipoProductoController {
	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<TipoProductoEntity> consultarTodosLosTipoProducto() {
		try {
			List<TipoProductoEntity> lstTipoProductos =  tipoProductoService.consultarTodosLosTipoProductos();
			
			if(lstTipoProductos != null && !lstTipoProductos.isEmpty())
				return lstTipoProductos;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public TipoProductoEntity consultarTipoProductoXId(@PathVariable Integer id) {
		try {
			TipoProductoEntity tipoProductoEntity =  tipoProductoService.consultarTipoProductoXId(id);
			
			if (tipoProductoEntity != null && !Objects.isNull(tipoProductoEntity))
				return tipoProductoEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/{nombreTipoProducto}")
	public TipoProductoEntity crearTipoProducto(@PathVariable String nombreTipoProducto) {
		try {
			
			TipoProductoEntity TipoProductoCreado = tipoProductoService.crearTipoProducto(nombreTipoProducto);

			if(TipoProductoCreado != null)
				return TipoProductoCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public TipoProductoEntity updateTipoProducto(@RequestBody TipoProductoUpdDTO tipoProductoUpdDTO) {
		try {
			
			TipoProductoEntity TipoProductoModificado = tipoProductoService.modificarTipoProducto(tipoProductoUpdDTO);
			
			if(TipoProductoModificado != null)
				return TipoProductoModificado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteTipoProducto(@PathVariable Integer id) {
		try {
			
			if(tipoProductoService.eliminarTipoProducto(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
