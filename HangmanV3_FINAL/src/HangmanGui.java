import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * ITEC 220 PROJECT 5
 * @author Dustin Trainer
 *
 *Gui for hangman project
 */
public class HangmanGui extends JFrame implements ActionListener{

	private JFrame board = new JFrame("Hangman");
	private JPanel panel1, panel2, contentPanel;
	private JPanel letterPanel, missesPanel, wordPanel, guessPanel;
	protected JButton submitButton = new JButton("Submit");
	protected JButton restartButton = new JButton("Restart");
    protected JTextField letterField, missesField, wordField, guessField;
    protected JTextArea hangmanBox;
    private JLabel letterLabel;
    protected JLabel missesLabel, enterLabel, wordLabel, guessLabel;
    //protected showMan view = new showMan();
    private HangmanInterface hangman;
    private HangmanController control;
    
/**
 * Constructor for hangman gui   
 * @param _hangman Instance of hangman interface
 */
    public HangmanGui(HangmanInterface _hangman){
    	hangman = _hangman;
    	control = new HangmanController();
    }
/**
 * Creates the hangman board and adds the components
 */
    public void createFrame(){
	   JOptionPane.showMessageDialog(board,"                         Welcome to Java Hangman! \n " +
  		"You only have 6 wrong guesses before Joe gets the rope! Good Luck!");

	   
	   submitButton.addActionListener(this);
	   restartButton.addActionListener(new restartListener());
	   wordField = new JTextField(15);
	   wordField.setEditable(true);
	   letterField = new JTextField(3);
	   letterField.setEditable(true);
	   missesField = new JTextField(3);
	   missesField.setEnabled(false);
	   missesField.setEditable(true);
	   guessField = new JTextField(6);
	   guessField.setEditable(true);
	
	   guessLabel = new JLabel("Guessed Letters: ");
	   missesLabel = new JLabel("Misses Remaining: ");
	   letterLabel = new JLabel("Enter your letter: ");
	   wordLabel = new JLabel("Word: ");
	   hangmanBox = new JTextArea(12, 20);
	   hangmanBox.setEditable(true);
	   
	      letterPanel = new JPanel();
	      letterPanel.setLayout(new BorderLayout());
	      
	      letterPanel.add(letterLabel, BorderLayout.WEST);
	      letterPanel.add(letterField,BorderLayout.EAST);
	      letterPanel.add(submitButton,BorderLayout.SOUTH);
	      
	      missesPanel = new JPanel();
	      missesPanel.setLayout(new BorderLayout());
	      missesPanel.add(missesLabel,BorderLayout.WEST);
	      missesPanel.add(missesField,BorderLayout.EAST);
	      missesPanel.add(restartButton,BorderLayout.SOUTH);
	      

	      wordPanel = new JPanel();	      
	      wordPanel.setLayout(new BorderLayout());
	      wordPanel.add(wordLabel, BorderLayout.WEST);
	      wordPanel.add(wordField, BorderLayout.CENTER);
	      
	      guessPanel = new JPanel();
	      guessPanel.setLayout(new BorderLayout());
	      guessPanel.add(guessLabel, BorderLayout.WEST);
	      guessPanel.add(guessField, BorderLayout.CENTER);
	      
	      panel1 = new JPanel();
	      panel1.setLayout(new BorderLayout());
	      panel1.add(letterPanel, BorderLayout.NORTH);	      
	      panel1.add(wordPanel, BorderLayout.SOUTH);
	      
	      
	      panel2 = new JPanel();
	      panel2.setLayout(new BorderLayout());
	      panel2.add(guessPanel, BorderLayout.NORTH);
	      panel2.add(missesPanel, BorderLayout.SOUTH);
	      
	      contentPanel = new JPanel();
	      contentPanel.setLayout(new BorderLayout());
	      contentPanel.add(panel1, BorderLayout.NORTH);
	      contentPanel.add(panel2, BorderLayout.CENTER);
	      
	      panel2.add(hangmanBox, BorderLayout.CENTER);
	      board.add(contentPanel,BorderLayout.WEST);
 	      board.add(hangmanBox,BorderLayout.CENTER);
	      
	      
 	      board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      board.setLocation(570, 300);
	      board.setVisible(true);
	      board.setSize(700,300);
	      
	      //board.add(view, BorderLayout.CENTER);
	    
	     
	     

	      
   }
/**
 * Plays the game when the submit button is proessed.
 * Calls the set input to save the letter, validates the letter with receive input
 * then processes the game in the play method.
 */
	public void actionPerformed(ActionEvent e) {
		hangman.setInput(letterField.getText());
		hangman.receiveInput();
		hangman.play();
		//board.repaint();
		
	}

/**
 * Action listenter for the reset button. Calls reset method in the interface
 *
 */
class restartListener implements ActionListener
	{
	
	public void actionPerformed(ActionEvent arg0) {
		hangman.reset();
		
	}

	}

/**
 * Paints the hangman graphics
 *
 
class showMan extends JPanel{
	private JPanel hangmanBox = new JPanel();
	
	
	public void paint(Graphics g){
		int guess = control.getGuessNumber();
		super.paint(g);
		// draw gallows
		// base
		g.drawLine(50,550,375,550);
		// vertical pole
		g.drawLine(150,550,150,150);
		// cross-bar
		g.drawLine(150,150,375,150);
		// rope
		g.drawLine(375,150,375,199);
		// draw blank lines and known characters
		switch (guess)
		{
		// string 'em up
		//case 7: animateHang(g);
		// left arm
		case 0: g.drawLine(375,270,300,280);
		// right arm
		case 1: g.drawLine(375,270,450,280);
		// left leg
		case 2: g.drawLine(375,400,325,450);
		// right leg
		case 3: g.drawLine(375,400,425,450);
		// torso
		case 4: g.drawLine(375,250,375,400);
		// face
		case 5: {g.drawOval(349,199,51,51); g.setColor(new Color(0x00ffcc99)); g.fillOval(350,200,50,50);}
		}
		// display list of all character guesses
		g.setColor(Color.black);
	}
}
*/	
	
}
