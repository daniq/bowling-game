import java.util.*;

class Game
{
  private ArrayList<Integer> rolls = new ArrayList<Integer>();

  void roll(int pins)
  {
    rolls.add(pins);
    if (pins == 10)
      rolls.add(0);
  }

  int score()
  {
    Integer score = 0;
    for (int i = 0, rollsSize = rolls.size(); i < rollsSize; i++)
    {
      Integer roll = rolls.get(i);
      score += roll;

      boolean isFrameStart = i % 2 == 0;
      boolean hasMoreThanOneFrame = i >= 2;

      if (hasMoreThanOneFrame && isFrameStart)
      {
        boolean isPreviousFrameStrike = rolls.get(i - 2) == 10;
        if (isPreviousFrameStrike)
        {
          score += roll;
          score += rolls.get(i + 1);
        }
        else
        {
          boolean isPreviousFrameSpare = rolls.get(i - 2) + rolls.get(i - 1) == 10;
          if (isPreviousFrameSpare)
          {
            score += roll;
          }
        }
      }
    }
    return score;
  }
}
