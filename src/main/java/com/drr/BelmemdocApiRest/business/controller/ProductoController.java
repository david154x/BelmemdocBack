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

import com.drr.BelmemdocApiRest.business.dto.ProductoCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ProductoUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.ProductoEntity;
import com.drr.BelmemdocApiRest.business.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<ProductoEntity> consultarTodosLosProductos() {
		try {
			List<ProductoEntity> lstProductos =  productoService.consultarTodosLosProductos();
			
			if (lstProductos != null && !lstProductos.isEmpty())
				return lstProductos;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public ProductoEntity consultarProductoXId(@PathVariable Integer id) {
		try {
			ProductoEntity productoEntity =  productoService.consultarProductoXId(id);
			
			if (productoEntity != null && !Objects.isNull(productoEntity))
				return productoEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public ProductoEntity crearProducto(@RequestBody ProductoCreateDTO productoCreateDTO) {
		try {
			
			ProductoEntity productoCreado = productoService.crearProducto(productoCreateDTO);

			if(productoCreado != null)
				return productoCreado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public ProductoEntity updateProducto(@RequestBody ProductoUpdDTO productoUpdDTO) {
		try {
			
			ProductoEntity productoModificado = productoService.modificarProducto(productoUpdDTO);
			
			if(productoModificado != null)
				return productoModificado;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteProducto(@PathVariable Integer id) {
		try {
			
			if(productoService.eliminarProducto(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return Boolean.FALSE;
    }

}
