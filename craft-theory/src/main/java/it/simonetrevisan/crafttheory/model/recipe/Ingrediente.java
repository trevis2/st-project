package it.simonetrevisan.crafttheory.model.recipe;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import lombok.Data;

@Data
public class Ingrediente
{
	private MateriaPrima materiaPrima;
	private Integer quantita;
	private Integer qualitaMinima;
}
