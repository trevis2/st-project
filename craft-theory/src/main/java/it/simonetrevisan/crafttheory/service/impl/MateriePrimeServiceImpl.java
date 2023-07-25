package it.simonetrevisan.crafttheory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import it.simonetrevisan.crafttheory.repository.IMaterialiRepository;
import it.simonetrevisan.crafttheory.service.IMateriePrimeService;

@Service
public class MateriePrimeServiceImpl implements IMateriePrimeService
{
	@Autowired
	private IMaterialiRepository materialiRepository;

	@Override
	public List<MateriaPrima> getMateriePrime()
	{
		List<MateriaPrima> listaMateriePrime = materialiRepository.findAll();
		return listaMateriePrime;
	}

}
