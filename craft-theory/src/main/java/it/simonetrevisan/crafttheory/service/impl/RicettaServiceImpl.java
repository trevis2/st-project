package it.simonetrevisan.crafttheory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import it.simonetrevisan.crafttheory.model.recipe.Ricetta;
import it.simonetrevisan.crafttheory.service.IMateriePrimeService;
import it.simonetrevisan.crafttheory.service.IRicettaService;

@Service
public class RicettaServiceImpl implements IRicettaService
{
	@Autowired
	IMateriePrimeService materiePrimeService;

	@Override
	public List<Ricetta> recuperaRicetteDisponibili()
	{
		List<MateriaPrima> materie = materiePrimeService.getMateriePrime();
		List<Ricetta> ricette = new ArrayList<Ricetta>();
		Ricetta ricetta = new Ricetta(materie);
		ricette.add(ricetta.generaRicetta("Ricetta1"));
		ricette.add(ricetta.generaRicetta("Ricetta2"));
		ricette.add(ricetta.generaRicetta("Ricetta3"));

		return ricette;
	}

	@Override
	public Ricetta generaRicetta(String nome, List<String> materiali, String costoMateriali, String valoreMinimoOggettoCostruito)
	{
		List<MateriaPrima> materiePrimeDisponibili = materiePrimeService.getMateriePrime();
		if (materiePrimeDisponibili.containsAll(materiali))
		{
			System.out.println("ok materiali");
		}
		Ricetta ricetta = new Ricetta(materiePrimeDisponibili);
		return ricetta.generaRicetta(nome);
	}
}
