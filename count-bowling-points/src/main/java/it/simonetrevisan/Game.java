package it.simonetrevisan;

public class Game
{
	private int score;
	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins)
	{
		this.rolls[this.currentRoll++] = pins;
	}

	public Integer score()
	{
		int frameIndex = 0;
		for (int frame = 0; frame < 10; frame++)
		{
			if (isStrike(frameIndex))
			{
				score += 10 + strikeBonus(frameIndex);
				frameIndex += 1;
			}
			else if (isSpare(frameIndex))
			{
				score += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			}
			else
			{
				score += scoreTwoBallsInFrame(frameIndex);
				frameIndex += 2;
			}
		}
		return score;
	}

	private int scoreTwoBallsInFrame(int frameIndex)
	{
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex)
	{
		return rolls[frameIndex + 2];
	}

	private int strikeBonus(int frameIndex)
	{
		return rolls[frameIndex + 1] + spareBonus(frameIndex);
	}

	private boolean isStrike(int frameIndex)
	{
		return rolls[frameIndex] == 10;
	}

	private boolean isSpare(int frameIndex)
	{
		return scoreTwoBallsInFrame(frameIndex) == 10;
	}
}
