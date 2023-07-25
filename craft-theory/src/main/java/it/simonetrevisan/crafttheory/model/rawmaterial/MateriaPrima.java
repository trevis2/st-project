package it.simonetrevisan.crafttheory.model.rawmaterial;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table
public class MateriaPrima
{
	@Id
	private Long id;

	private String nome;

	private Integer unitaDisponibili;

	@Range(min = 0, max = 100)
	private Integer difficoltaEstrazione;

	@Range(min = 0, max = 100)
	private Integer difficoltaLavorazione;

	public MateriaPrima()
	{

	}

	public MateriaPrima(String nome, Integer unitaDisponibili, @Range(min = 0, max = 100) Integer difficoltaEstrazione, @Range(min = 0, max = 100) Integer difficoltaLavorazione)
	{
		this.nome = nome;
		this.unitaDisponibili = unitaDisponibili;
		this.difficoltaEstrazione = difficoltaEstrazione;
		this.difficoltaLavorazione = difficoltaLavorazione;
	}

	public String getNome()
	{
		return this.nome;
	}

	public Integer getDifficoltaLavorazione()
	{
		return this.difficoltaLavorazione;
	}

	public BigDecimal getValore()
	{
		BigDecimal difficoltaEstrazione = new BigDecimal(this.difficoltaEstrazione);
		BigDecimal unitaDisponibili = new BigDecimal(this.unitaDisponibili);
		BigDecimal valore = difficoltaEstrazione.divide(unitaDisponibili, 6, RoundingMode.DOWN);
		return valore.multiply(BigDecimal.valueOf(1000l));
	}

}
