package it.simonetrevisan.crafttheory.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import it.simonetrevisan.crafttheory.model.recipe.Ricetta;

public class RecipesDTO
{
	List<Ricetta> ricette;

	public List<Ricetta> getRicette()
	{
		if (CollectionUtils.isEmpty(ricette))
		{
			ricette = new ArrayList<Ricetta>();
		}
		return this.ricette;
	}

}
