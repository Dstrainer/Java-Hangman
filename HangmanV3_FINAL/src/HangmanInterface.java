import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JOptionPane;

/**
 *ITEC 220 Project 5
 *@author Dustin Trainer
 *
 *Interface class picks a random word then gathers the guessed letter from the user and checks it
 *the random word contains the letter. 
 */
public class HangmanInterface {
		protected String word;
		protected String guessed = "";
		protected StringBuffer bufferWord;
		private int lengthWord = 0;
		private HangmanGui board = new HangmanGui(this);
		private HangmanController control = new HangmanController(this,board);
		protected String input;
		
/**
 * Constructor for Hangman interface
 */
		public HangmanInterface(){
		}
		
		
/**
 * Calls the gui to create the playing board and then picks the random word
 */
		public void startGame(){
			board.createFrame();
			randomWord();
			
		}
		
		
/**
 * Picks a random word from the dictionary text file and creates a buffer the hide the characters.
 */
		public void randomWord(){
			File file = new File("dictionary.txt");
			ArrayList<String> words = new ArrayList<String>();
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String word1;
				while (( word1 = reader.readLine()) != null)
					words.add(word1);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(words.size() < 1)
				word = "";
			else
			{
				Random rand = new Random();
				int i = rand.nextInt(words.size());
				word = words.get(i);
			}
			bufferWord = new StringBuffer();
			for(int i = 0; i < word.length(); i++)
				bufferWord.append("-");
			this.print();
			control.printMessage();
		}
		
		
/**
 * Takes in the guessed letter from the user and validates it is correct
 * 
 */
		public void receiveInput() {						
			char enteredChar;
			
			addGuess(input);
			
			if (input.indexOf(takeGuess()) == -1){
				JOptionPane.showMessageDialog(board,"Letter has already been guessed");
			}
			if(input.length() > 1){
				JOptionPane.showMessageDialog(board,"**Enter one letter at a time!**");
				control.setGuessNumber(control.getGuessNumber() + 1);
			}
			if(input.equals(null)){
				JOptionPane.showMessageDialog(board,"**Enter a letter!**");
				control.setGuessNumber(control.getGuessNumber() + 1);
			}
				enteredChar = input.charAt(0);
	        	
			if (!Character.isLetter(enteredChar)){
				  JOptionPane.showMessageDialog(board,"**Enter a valid letter!**");
				  control.setGuessNumber(control.getGuessNumber() + 1);
	             
			}
		}
		
		
/**
 * Processes the game with the letter entered by the user.
 * This will update the number of guesses, print out the guessed letters, and create the hangman
 */
		public void play() {			
							
			char ch = takeGuess();
			
			if(guess(ch)) {
			}
			else {
					control.setGuessNumber(control.getGuessNumber() - 1);
					control.showMan();
					//board.view.repaint();
					control.printMessage();					
					board.guessField.setText(guessed);
			}
							
			if(foundWord())
				control.win();
				board.letterField.setText("");
				
				
		}
		
		
/**
 * Setter method for the input variable
 * @param s The letter that is guessed
 */
		public void setInput(String s){
			input = s;
		}
		
	
/**
 * Getter for input variable
 * @return the input
 */
		public String getInput() {
			return input;
		}
		

/**
 * Method used to reset all components of the game if reset button is clicked.
 */			
		public void reset(){
			control.setGuessNumber(6);
			board.hangmanBox.setText("");
			board.guessField.setText("");
			guessed = "";
			board.wordField.setText("");
			this.randomWord();
			this.lengthWord = 0;
			
		}
		
/**
 * Prints the buffer word to the text area
 */
		public void print() {
			String s = bufferWord.toString();			
			board.wordField.setText(s);
						
		}
		
/**
 * Saves guessed letter
 * @param s The guessed letter
 */
		public void addGuess(String s){
			guessed += s+", ";
		}
		
				
/**
 * Takes the input word and gets the first character
 * @return Converted character from string that the user entered
 */
		public char takeGuess() {
			char c = input.charAt(0);
			return c;
			
		}
		
		
		
/**
 * Returns whether the word has been successfully guessed
 * @return if the word has been guessed
 */
		public boolean foundWord() {
			return ( lengthWord == word.length() );
		}

		
		
		
/**
 * Determines if the input has the character
 * @return if the input has is character
 */
		public boolean guess(char c) {
			int index = word.indexOf(c);
			
										
            if( index == -1 ){
				return false;
            }
			else {
				lengthWord = lengthWord + findOccurences(c);
				
				board.guessField.setText(guessed);
				return true;
			}
		}
		
		
/**
 * Finds if there are occurrences of the guessed letter and returns the count if so. Also updates the buffer word
 * with the character that was guessed if the word contains the guessed character
 * @param c The character that was guessed
 * @return number of occurrences of that letter in the random word
 */
		private int findOccurences(char c) {
			int inputLoc = word.indexOf(c);
			bufferWord.setCharAt(inputLoc, word.charAt(inputLoc) );
			this.print();
			int count = 1;
			while(inputLoc != -1) {
				int temp = word.indexOf(c, inputLoc + 1);
				inputLoc = temp;
				if(inputLoc != -1) {
					count++;
					bufferWord.setCharAt(inputLoc, word.charAt(inputLoc) );
					this.print();
				}
			}
			return count;
		}
	}
	