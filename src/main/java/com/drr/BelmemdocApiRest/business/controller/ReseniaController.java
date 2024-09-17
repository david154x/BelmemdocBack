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

import com.drr.BelmemdocApiRest.business.dto.ReseniaCreateDTO;
import com.drr.BelmemdocApiRest.business.dto.ReseniaUpdDTO;
import com.drr.BelmemdocApiRest.business.entity.ReseniaEntity;
import com.drr.BelmemdocApiRest.business.service.ReseniaService;

@RestController
@RequestMapping("/resenia")
public class ReseniaController {
	
	@Autowired
	private ReseniaService reseniaService;
	
	@GetMapping("/status")
	public Boolean status() {
		return Boolean.TRUE;
	}
	
	@GetMapping("")
	public List<ReseniaEntity> consultarTodasLasResenias() {
		try {
			List<ReseniaEntity> lstResenias =  reseniaService.buscarTodasLasResenias();
			
			if(lstResenias != null && !lstResenias.isEmpty())
				return lstResenias;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public ReseniaEntity consultarReseniaXId(@PathVariable Integer id) {
		try {
			ReseniaEntity reseniaEntity =  reseniaService.buscarReseniaXId(id);
			
			if (reseniaEntity != null && !Objects.isNull(reseniaEntity))
				return reseniaEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("")
	public ReseniaEntity crearResenia(@RequestBody ReseniaCreateDTO reseniaCreateDTO) {
		try {
			
			ReseniaEntity reseniaCreada = reseniaService.guardarResenia(reseniaCreateDTO); 

			if(reseniaCreada != null)
				return reseniaCreada;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("")
    public ReseniaEntity updateResenia(@RequestBody ReseniaUpdDTO reseniaUpdDTO) {
		try {
			
			ReseniaEntity reseniaModificada = reseniaService.actualizarResenia(reseniaUpdDTO);
			
			if(reseniaModificada != null)
				return reseniaModificada;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	@DeleteMapping("/{id}")
    public Boolean deleteResenia(@PathVariable Integer id) {
		try {
			
			if(reseniaService.eliminarResenia(id))
				return Boolean.TRUE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return Boolean.FALSE;
    }

}
