package it.simonetrevisan.crafttheory.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import lombok.Data;

@Data
public class MaterialiBaseDTO
{
	private List<MateriaPrima> listaMateriePrime;

	public List<MateriaPrima> getListaMateriePrime()
	{
		if (CollectionUtils.isEmpty(listaMateriePrime))
		{
			listaMateriePrime = new ArrayList<MateriaPrima>();
		}
		return listaMateriePrime;
	}
}
