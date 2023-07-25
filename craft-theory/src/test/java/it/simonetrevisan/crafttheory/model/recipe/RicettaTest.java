package it.simonetrevisan.crafttheory.model.recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.simonetrevisan.crafttheory.model.rawmaterial.MateriaPrima;
import it.simonetrevisan.crafttheory.service.impl.MateriePrimeServiceImpl;

class RicettaTest
{

	@Test
	void testCreaRicettaRandom()
	{
		System.out.println(new Ricetta(new MateriePrimeServiceImpl().getMateriePrime()).generaRicetta("test"));
	}

	@Test
	public void testRandom()
	{
//		for (int i = 0; i < 50; i++)
//		{
//			int num = generaNumeroInteroCasualeRange(0, 1);
//			System.out.println(num);
//			assertTrue(num <= 1 && num >= 0, "il numero non è nel range tra 0 e 1");
//		}
//		for (int i = 0; i < 50; i++)
//		{
//			int num = generaNumeroInteroCasualeRange(1, 2);
//			System.out.println(num);
//			assertTrue(num <= 2 && num >= 1, "il numero non è nel range tra 1 e 2");
//		}
//		for (int i = 0; i < 50; i++)
//		{
//			int num = generaNumeroInteroCasualeRange(2, 3);
//			System.out.println(num);
//			assertTrue(num <= 3 && num >= 2, "il numero non è nel range tra 2 e 3");
//		}
//		for (int i = 0; i < 50; i++)
//		{
//			int num = generaNumeroInteroCasualeRange(2, 4);
//			System.out.println(num);
//			assertTrue(num <= 4 && num >= 2, "il numero non è nel range tra 2 e 4");
//		}
		for (int i = 0; i < 5000; i++)
		{
			int num = generaNumeroInteroCasualeRange(0, 100);
			System.out.println(num);
			assertTrue(num <= 100 && num >= 0, "il numero non è nel range tra 0 e 100");
			if (num == 100)
			{
				System.out.println("CENTO!!");
			}
		}
	}

	public int generaNumeroInteroCasualeRange(int minimo, int massimo)
	{
		return (int) (Math.round(Math.random() * (massimo - minimo)) + minimo);
	}

	@Test
	public void materiaTest()
	{
		MateriaPrima rame = new MateriaPrima("RAME", 150000, 5, 5);
		MateriaPrima zinco = new MateriaPrima("ZINCO", 150000, 5, 5);
		MateriaPrima nichel = new MateriaPrima("NICHEL", 150000, 10, 5);
		MateriaPrima ferro = new MateriaPrima("FERRO", 150000, 15, 5);

		MateriaPrima argento = new MateriaPrima("ARGENTO", 75000, 15, 5);
		MateriaPrima vanadio = new MateriaPrima("VANADIO", 75000, 25, 5);
		MateriaPrima oro = new MateriaPrima("ORO", 50000, 30, 5);
		MateriaPrima titanio = new MateriaPrima("TITANIO", 35000, 30, 5);

		MateriaPrima platino = new MateriaPrima("PLATINO", 28000, 35, 5);
		MateriaPrima palladio = new MateriaPrima("PALLADIO", 25000, 45, 5);

		System.out.println(rame.getValore());
		System.out.println(zinco.getValore());
		System.out.println(nichel.getValore());
		System.out.println(ferro.getValore());

		System.out.println(argento.getValore());
		System.out.println(vanadio.getValore());
		System.out.println(oro.getValore());
		System.out.println(titanio.getValore());

		System.out.println(platino.getValore());
		System.out.println(palladio.getValore());
	}

}
