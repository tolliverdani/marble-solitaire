package cs5004.marblesolitaire.model.impl;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class to test my board class and all of it's methods.
 */
public class EuropeanSolitaireModelImplTest {

  private MarbleSolitaireModel defaultBoard;
  private MarbleSolitaireModel customEmpty;
  private MarbleSolitaireModel customSize;
  private MarbleSolitaireModel customEmptyAndSize;
  private Appendable appendable;

  @Before
  public void setUp() {
    defaultBoard = new EuropeanSolitaireModelImpl();
    customEmpty = new EuropeanSolitaireModelImpl(3, 4);
    customSize = new EuropeanSolitaireModelImpl(5);
    customEmptyAndSize = new EuropeanSolitaireModelImpl(7, 9, 12);
    appendable = new StringBuilder();
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEven() {
    // testing the failure when the thickness param is an even number
    EuropeanSolitaireModelImpl corrupt = new EuropeanSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUpEmptyAndEven() {
    // testing the failure when the thickness param is an even number but col and row are OK
    EuropeanSolitaireModelImpl corrupt = new EuropeanSolitaireModelImpl(2, 4, 3);
  }

  @Test
  public void testOneMove() {
    defaultBoard.move(5, 3, 3, 3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O _ O O\n"
            + "    O O O", defaultBoard.getGameState());
    assertEquals(35, defaultBoard.getScore());
  }

  @Test
  public void testGetGameState() {
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", defaultBoard.getGameState());
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", customEmpty.getGameState());
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", customSize.getGameState());
    assertEquals("            O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "            O O O O O O O", customEmptyAndSize.getGameState());
  }

  @Test
  public void testGetScore() {
    assertEquals(36, defaultBoard.getScore());
    assertEquals(36, customEmpty.getScore());
    assertEquals(128, customSize.getScore());
    assertEquals(276, customEmptyAndSize.getScore());
  }

  @Test
  public void testIsGameOver() {
    assertFalse(defaultBoard.isGameOver());
  }

  @Test
  public void playGameWon() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
            new StringReader("3 3 1 3 "
                    + "3 1 3 3 "
                    + "2 5 2 3 "
                    + "4 5 2 5 "
                    + "4 3 4 5 "
                    + "3 4 3 2 "
                    + "6 4 4 4 "
                    + "4 1 4 3 "
                    + "6 2 4 2 "
                    + "5 6 5 4 "
                    + "6 6 6 4 "
                    + "1 5 3 5 "
                    + "3 2 5 2 "
                    + "3 5 5 5 "
                    + "6 3 6 5 "
                    + "4 7 4 5 "
                    + "2 2 2 4 "
                    + "3 7 3 5 "
                    + "1 4 3 4 "
                    + "4 3 6 3 "
                    + "4 5 4 3 "
                    + "7 3 5 3 "
                    + "4 3 6 3 "
                    + "5 1 5 3 "
                    + "5 4 5 2 "
                    + "7 5 7 3 "
                    + "7 3 5 3 "
                    + "5 2 5 4 "
                    + "5 4 5 6 "
                    + "5 7 5 5 "
                    + "6 5 4 5 "
                    + "4 5 2 5 "
                    + "2 6 2 4 "
                    + "3 4 1 4 "
                    + "1 3 1 5 q"),
            appendable);
    controller.playGame(new EuropeanSolitaireModelImpl(0, 2));
    assertEquals("    _ O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 36\n"
            + "    O O O\n"
            + "  O _ O O O\n"
            + "O O _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 35\n"
            + "    O O O\n"
            + "  O _ O O O\n"
            + "_ _ O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 34\n"
            + "    O O O\n"
            + "  O O _ _ O\n"
            + "_ _ O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 33\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ _ O O _ O O\n"
            + "O O O O _ O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ _ O O _ O O\n"
            + "O O _ _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "O O _ _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "O O _ O O O O\n"
            + "O O O _ O O O\n"
            + "  O O _ O O\n"
            + "    O O O\n"
            + "Score: 29\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "_ _ O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O _ O O\n"
            + "    O O O\n"
            + "Score: 28\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "_ O O O O O O\n"
            + "O _ O _ O O O\n"
            + "  _ O _ O O\n"
            + "    O O O\n"
            + "Score: 27\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "_ O O O O O O\n"
            + "O _ O O _ _ O\n"
            + "  _ O _ O O\n"
            + "    O O O\n"
            + "Score: 26\n"
            + "    O O O\n"
            + "  O O _ O O\n"
            + "_ O _ _ _ O O\n"
            + "_ O O O O O O\n"
            + "O _ O O _ _ O\n"
            + "  _ O O _ _\n"
            + "    O O O\n"
            + "Score: 25\n"
            + "    O O _\n"
            + "  O O _ _ O\n"
            + "_ O _ _ O O O\n"
            + "_ O O O O O O\n"
            + "O _ O O _ _ O\n"
            + "  _ O O _ _\n"
            + "    O O O\n"
            + "Score: 24\n"
            + "    O O _\n"
            + "  O O _ _ O\n"
            + "_ _ _ _ O O O\n"
            + "_ _ O O O O O\n"
            + "O O O O _ _ O\n"
            + "  _ O O _ _\n"
            + "    O O O\n"
            + "Score: 23\n"
            + "    O O _\n"
            + "  O O _ _ O\n"
            + "_ _ _ _ _ O O\n"
            + "_ _ O O _ O O\n"
            + "O O O O O _ O\n"
            + "  _ O O _ _\n"
            + "    O O O\n"
            + "Score: 22\n"
            + "    O O _\n"
            + "  O O _ _ O\n"
            + "_ _ _ _ _ O O\n"
            + "_ _ O O _ O O\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    O O O\n"
            + "Score: 21\n"
            + "    O O _\n"
            + "  O O _ _ O\n"
            + "_ _ _ _ _ O O\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    O O O\n"
            + "Score: 20\n"
            + "    O O _\n"
            + "  _ _ O _ O\n"
            + "_ _ _ _ _ O O\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    O O O\n"
            + "Score: 19\n"
            + "    O O _\n"
            + "  _ _ O _ O\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    O O O\n"
            + "Score: 18\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    O O O\n"
            + "Score: 17\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ O O _ _\n"
            + "O O _ O O _ O\n"
            + "  _ O _ O _\n"
            + "    O O O\n"
            + "Score: 16\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ O _ _ _ _\n"
            + "O O _ O O _ O\n"
            + "  _ O _ O _\n"
            + "    O O O\n"
            + "Score: 15\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ O _ _ _ _\n"
            + "O O O O O _ O\n"
            + "  _ _ _ O _\n"
            + "    _ O O\n"
            + "Score: 14\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "O O _ O O _ O\n"
            + "  _ O _ O _\n"
            + "    _ O O\n"
            + "Score: 13\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ O O O _ O\n"
            + "  _ O _ O _\n"
            + "    _ O O\n"
            + "Score: 12\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ O _ _ O _ O\n"
            + "  _ O _ O _\n"
            + "    _ O O\n"
            + "Score: 11\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ O _ _ O _ O\n"
            + "  _ O _ O _\n"
            + "    O _ _\n"
            + "Score: 10\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ O O _ O _ O\n"
            + "  _ _ _ O _\n"
            + "    _ _ _\n"
            + "Score: 9\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O O _ O\n"
            + "  _ _ _ O _\n"
            + "    _ _ _\n"
            + "Score: 8\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ O O\n"
            + "  _ _ _ O _\n"
            + "    _ _ _\n"
            + "Score: 7\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ O _ _\n"
            + "  _ _ _ O _\n"
            + "    _ _ _\n"
            + "Score: 6\n"
            + "    O _ _\n"
            + "  _ _ _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 5\n"
            + "    O _ _\n"
            + "  _ _ _ O O\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 4\n"
            + "    O _ _\n"
            + "  _ _ O _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 3\n"
            + "    O O _\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 2\n"
            + "    _ _ O\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 1\n"
            + "Game over!\n"
            + "    _ _ O\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _\n"
            + "Score: 1\n", appendable.toString());
  }

}

