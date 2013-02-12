/**
 * ITEC 220 PROJECT 5
 * @author Dustin Trainer
 * 
 * **Hangman Game**
 * Classic hangman game using Java words. Allows a user to input a letter, one at a time, to guess 
 * the random word. User only has 6 attempt until the game is over.
 * 
 * Reference for some methods:
 * http://www.hangman.symbolwebdesign.nl/sourcecode.php?lang=Java
 * 
 * Driver class which calls the interface to begin the game.
 */
public class HangmanDriver {

		public static void main(String[] args) {
			
			HangmanInterface hangman = new HangmanInterface();
			hangman.startGame();
		}
	}