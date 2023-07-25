package it.simonetrevisan.crafttheory.model.recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ricetta
{
	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private Map<String, Ingrediente> ingredienti;

	@Getter
	@Setter
	private Integer difficolta;

	@Getter
	@Setter
	private Integer tempo;

	@Getter
	@Setter
	private Integer valoreOggettoCostruito;

	private List<MateriaPrima> materie;

	public Ricetta(List<MateriaPrima> materie)
	{
		this.materie = materie;
	}

	public Ricetta generaRicetta(String nomeRicetta)
	{
		this.nome = nomeRicetta;
		this.difficolta = generaNumeroInteroCasualeRange(1, 10);
		this.tempo = generaNumeroInteroCasualeRange(1, 20);
		this.valoreOggettoCostruito = this.difficolta * this.tempo;
		this.ingredienti = new HashMap<String, Ingrediente>();
		Integer numeroMaterie = this.materie.size();
		Integer numeroMPNellaRicetta = generaNumeroInteroCasualeRange(1, numeroMaterie);
		for (int i = 0; i < numeroMPNellaRicetta; i++)
		{
			MateriaPrima materia = this.materie.get(generaNumeroInteroCasualeRange(0, numeroMaterie - 1));
			if (!this.ingredienti.containsKey(materia.getNome()))
			{
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setMateriaPrima(materia);
				ingrediente.setQuantita(generaNumeroInteroCasualeRange(1, 5));
				ingrediente.setQualitaMinima(generaNumeroInteroCasualeRange(0, 10));
				this.ingredienti.put(materia.getNome(), ingrediente);
			}
		}
		return this;
	}

	public int generaNumeroInteroCasualeRange(int minimo, int massimo)
	{
		return (int) (Math.round(Math.random() * (massimo - minimo)) + minimo);
	}

}
