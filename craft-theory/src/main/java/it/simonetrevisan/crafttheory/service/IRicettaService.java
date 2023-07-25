package it.simonetrevisan.crafttheory.service;

import java.util.List;

import it.simonetrevisan.crafttheory.model.recipe.Ricetta;

public interface IRicettaService
{
	public List<Ricetta> recuperaRicetteDisponibili();

	public Ricetta generaRicetta(String nome, List<String> materiali, String costoMateriali, String valoreMinimoOggettoCostruito);
}
