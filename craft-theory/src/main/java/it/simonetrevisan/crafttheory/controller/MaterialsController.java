package it.simonetrevisan.crafttheory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.simonetrevisan.crafttheory.dto.MaterialiBaseDTO;
import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import it.simonetrevisan.crafttheory.service.IMateriePrimeService;

@RestController
public class MaterialsController
{
	@Autowired
	IMateriePrimeService materiePrimeService;

	@GetMapping("/materie-prime")
	public ResponseEntity<MaterialiBaseDTO> getMaterials()
	{
		MaterialiBaseDTO materialiBase = new MaterialiBaseDTO();
		List<MateriaPrima> materiePrime = materiePrimeService.getMateriePrime();
		materialiBase.getListaMateriePrime().addAll(materiePrime);
		return new ResponseEntity<MaterialiBaseDTO>(materialiBase, HttpStatus.ACCEPTED);
	}
}
