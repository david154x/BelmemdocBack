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

import com.drr.BelmemdocApiRest.business.dto.MarcaUpdateDTO;
import com.drr.BelmemdocApiRest.business.entity.MarcaEntity;
import com.drr.BelmemdocApiRest.business.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<MarcaEntity> consultarTodosLasMarcas() {
		try {
			List<MarcaEntity> lstMarcas =  marcaService.consultarTodasLasMarcas();
			
			if (lstMarcas != null && !lstMarcas.isEmpty())
				return lstMarcas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public MarcaEntity consultarMarcaXId(@PathVariable Integer id) {
		try {
			MarcaEntity marcaEntity =  marcaService.consultarMarcaXId(id);
			
			if (marcaEntity != null && !Objects.isNull(marcaEntity))
				return marcaEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/{nombreMarca}")
	public MarcaEntity crearMarca(@PathVariable String nombreMarca) {
		try {
			
			MarcaEntity marcaCreada = marcaService.crearMarca(nombreMarca);

			if(marcaCreada != null)
				return marcaCreada;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public MarcaEntity updateMarca(@RequestBody MarcaUpdateDTO marcaUpdateDTO) {
		try {
			MarcaEntity marcaModificada = marcaService.modificarMarca(marcaUpdateDTO);
			
			if(marcaModificada != null)
				return marcaModificada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteMarca(@PathVariable Integer id) {
		try {
			
			if(marcaService.eliminarMarca(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return Boolean.FALSE;
    }

}
