package srl.ibc.demo.app.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import srl.ibc.demo.app.AppApplicationTests;
import srl.ibc.demo.app.service.IUserService;
import srl.ibc.demo.app.service.model.User;

public class UserServiceTests extends AppApplicationTests {

	@Autowired
	private IUserService userService;

	@ParameterizedTest
	@CsvSource({ "1,Simone,Trevisan,TRVSMN86S28H501M", "2,Emanuela,Piovesan,PIOPIO" })
	public void testInserimentoUtente(Long id, String nome, String cognome, String codiceFiscale) {
		User user = new User(id, nome, cognome, codiceFiscale);
		userService.insertUserAndFlush(user);
		User response = userService.getUser(id);
		assertEquals(nome, response.getNome());
		assertEquals(cognome, response.getCognome());
		assertEquals(codiceFiscale, response.getCodiceFiscale());
	}

	@Override
	@BeforeEach
	protected void beforeEach() {
		System.out.println("---------beforeEach UserServiceTests---------");
	}

	@Test
	public void testLettura() {
		User response = userService.getUser(1l);
		assertEquals("Simone", response.getNome());
		assertEquals("trevisan", response.getCognome());
	}

}
