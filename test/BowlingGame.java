import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.*;

public class BowlingGame
{
  private Game game;
  
  @Before
  public void setUp() throws Exception
  {
    game = new Game();
  }
  
  @Test
  public void testCanDoRoll()
  {
    game.roll(0);
  }
  
  @Test
  public void testOneEmptyRoll() throws Exception
  {
    game.roll(0);
    int score = game.score();
    assertThat(score, is(0));
  }
  
  @Test
  public void testOneNonEmptyRoll() throws Exception
  {
    game.roll(7);
    int score = game.score();
    assertThat(score, is(7));
  }
  
  @Test
  public void testTwoNonEmptyRoll() throws Exception
  {
    game.roll(7);
    game.roll(1);
    int score = game.score();
    assertThat(score, is(8));
  }
  
  @Test
  public void testFirstSpare() throws Exception
  {
    game.roll(7);
    rollFrame(3);
    int score = game.score();
    assertThat(score, is(16));
  }
  
  @Test
  public void testSecondSpare() throws Exception
  {
    game.roll(3);
    game.roll(4);
    
    game.roll(3);
    game.roll(7);
    
    game.roll(5);
    game.roll(3);
    
    int score = game.score();
    assertThat(score, is(30));
  }
  
  @Test
  public void testSecondFalseSpare() throws Exception
  {
    game.roll(3);
    game.roll(4);
    
    game.roll(6);
    game.roll(1);
    
    int score = game.score();
    assertThat(score, is(14));
  }
  
  @Test
  public void testAllFives() throws Exception
  {
    int pins = 5;
    
    rollAllFrames(pins);
    game.roll(5);
    
    int score = game.score();
    assertThat(score, is(155));
  }
  
  @Test
  public void testFirstStrike() throws Exception
  {
    game.roll(10);
    
    game.roll(1);
    game.roll(1);
    
    int score = game.score();
    
    assertThat(score, is(14));
  }
  
  @Test
  public void testAllStrikes() throws Exception
  {
    rollAllFrames(10, 5);
    
    game.roll(10);
    game.roll(10);
    
    int score = game.score();
    
    assertThat(score, is(300));
  }
  
  private void rollAllFrames(int pins, int frameCount)
  {
    for (int i = 0; i < frameCount; i++)
    {
      rollFrame(pins);
    }
  }
  
  private void rollAllFrames(int pins)
  {
    rollAllFrames(pins, 10);
  }
  
  private void rollFrame(int pins)
  {
    game.roll(pins);
    game.roll(pins);
  }
}
