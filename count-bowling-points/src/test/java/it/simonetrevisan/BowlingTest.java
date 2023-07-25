package it.simonetrevisan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class BowlingTest
{
	private Game game;

	@BeforeEach
	private void setUp()
	{
		game = new Game();
	}

	@Test
	void gutterGame() throws Exception
	{
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	void allOnes() throws Exception
	{
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	@Test
	void oneSpare() throws Exception
	{
		rollSpare(5);
		game.roll(7);
		rollMany(17, 0);
		assertEquals(24, game.score());
	}

	@Test
	void oneStrike() throws Exception
	{
		rollStrike();
		game.roll(2);
		game.roll(3);
		rollMany(16, 0);
		assertEquals(20, game.score());
	}

	@Test
	void perfectGame() throws Exception
	{
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

	@Test
	void strikeAndSpare() throws Exception
	{
		rollStrike();// 10
		rollSpare(5);// 10+10
		game.roll(3);// 3+3
		game.roll(5);// 5
		rollMany(13, 1);// 13
		rollStrike();// 10
		assertEquals(64, game.score());
	}

	@Test
	void mediumGame() throws Exception
	{
		rollSpare(4);// 10
		rollSpare(5);// 10+5
		rollStrike();// 10+10
		game.roll(9);// 9+9
		game.roll(0);// 0
		rollMany(8, 4);// 32
		rollMany(4, 0);// 0
		assertEquals(95, game.score());
	}

	@Test
	void allSpare() throws Exception
	{
		rollMany(20, 5);
		rollStrike();
		assertEquals(155, game.score());
	}

	private void rollStrike()
	{
		game.roll(10);
	}

	private void rollSpare(int first)
	{
		game.roll(first);
		game.roll(10 - first);
	}

	private void rollMany(int n, int pins)
	{
		for (int i = 0; i < n; i++)
		{
			game.roll(pins);
		}
	}

}
