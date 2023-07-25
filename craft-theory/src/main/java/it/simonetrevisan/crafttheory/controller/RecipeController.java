package it.simonetrevisan.crafttheory.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.simonetrevisan.crafttheory.dto.RecipesDTO;
import it.simonetrevisan.crafttheory.model.recipe.Ricetta;
import it.simonetrevisan.crafttheory.service.IRicettaService;

@RestController
public class RecipeController
{
	@Autowired
	private IRicettaService ricettaService;

	@GetMapping("/recipes")
	public RecipesDTO getRecipes()
	{
		RecipesDTO ricetteDisponibili = new RecipesDTO();
		List<Ricetta> ricette = ricettaService.recuperaRicetteDisponibili();
		ricetteDisponibili.getRicette().addAll(ricette);
		return ricetteDisponibili;
	}

	@PostMapping("/generate-recipe")
	public ResponseEntity<Ricetta> creaRicetta(HttpServletResponse response, @RequestParam(name = "nome-ricetta") String nomeRicetta, @RequestParam(name = "costo-materiali") String costoMateriali, @RequestParam List<String> materiali,
			@RequestParam(name = "valore-minimo-oggetto-costruito") String valoreMinimoOggettoCostruito)
	{
		System.out.println(nomeRicetta);
		System.out.println(materiali);
		System.out.println(costoMateriali);
		System.out.println(valoreMinimoOggettoCostruito);
		Ricetta ricetta = ricettaService.generaRicetta(nomeRicetta, materiali, costoMateriali, valoreMinimoOggettoCostruito);
		response.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<Ricetta>(ricetta, HttpStatus.OK);
//		return ResponseEntity.ok().body(ricetta);
	}
}
