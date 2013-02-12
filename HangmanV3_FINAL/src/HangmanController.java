import java.awt.Font;

import javax.swing.JOptionPane;
/**
 * ITEC 220 PROJECT 5
 * @author Dustin Trainer
 *
 *Controller class
 *Creates the game, manages the number of guesses remaining, and shows the hangmang
 */


public class HangmanController {
	
	private HangmanInterface hangman;
	private HangmanGui board;	
	private int guessNumber = 6;

/**
 * Overloaded constructor
 */
	public HangmanController(HangmanInterface _hangman, HangmanGui _board) {		
		hangman = _hangman;
		board = _board;
		    
	}
	
/**
 * Constructor for controller class	
 */
	public HangmanController() {
		
	}
	
/**
 * Calls the gui class to create the board and creates a random word	
 */
	public void startGame(){
		board.createFrame();		
		hangman.randomWord(); 
		
	}
	
	
/**
 * Displays the number of guesses left
 */
	public void printMessage() {
		board.missesField.setText(guessNumber+"");
		
}
		
/**
 * Displays the hangman
 */
	public void showMan(){
        if (guessNumber==5){
            board.hangmanBox.setText("\t-------- \n\t |      | \n\t |     () \n\t |   \n\t | \n\t | \n\t=====");
        }
        if (guessNumber==4){
            board.hangmanBox.setText("\t-------- \n\t |      | \n\t |     () \n\t |     || \n\t | \n\t | \n\t=====");
        }
        if (guessNumber==3){
        	board.hangmanBox.setText("\t-------- \n\t |      |\n\t |      ()\n\t |     -|| \n\t | \n\t | \n\t=====");
        }
        if (guessNumber==2){
        	board.hangmanBox.setText("\t--------\n\t |      | \n\t |      () \n\t |     -||- \n\t | \n\t | \n\t=====");
        }
        if (guessNumber==1){
        	board.hangmanBox.setText("\t--------\n\t |      | \n\t |      () \n\t |     -||- \n\t |      / \n\t | \n\t=====");
        }
        if (guessNumber==0){
        	lose();
            Font h= new Font("Arial", Font.PLAIN, 18);
            board.hangmanBox.setFont(h);
        	board.hangmanBox.setText("--------- \n |       | \n |       () \n |      -||- \n |       /\\ \n | \n=====\n\n");
        	           
        }
    }

/**
 * Setter for guessNumber variable.
 * @return the guessNumber
 */
	public int getGuessNumber() {
		return guessNumber;
	}
	
	
/**
 * Getter for guessNumber variable.
 * @param guessNumber the guessNumber to set
 */
	public void setGuessNumber(int guessNumber) {
		this.guessNumber = guessNumber;
	}
	
	
/**
 * Displays a message if the word is guessed
 */
	public void win() {
		JOptionPane.showMessageDialog(board, "You guessed the correct word: \""+hangman.word+"\", You Win!");
}
	
	
/**
 * Displays a message if the word is not guessed
 */
	public void lose() {
		JOptionPane.showMessageDialog(board, "Oh no, Joe has been hung! Better luck next time! The word was: " + hangman.word);
		
	}
	
				
}

	

	