import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Lead Author(s):
 * @author Jake Salzer
 * @author Hernany Torres
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * 
 * "Closing on a Single Window Closes All the Frames in Java." Stack Overflow, stackoverflow.com/questions/9906222/closing-on-a-single-window-closes-all-the-frames-in-java.
 * 
 * "How to Center the Text in a JLabel?" Stack Overflow, stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel.
 * 
 * "JAVA: How to Make a PopUp Window Close Automatically?" Stack Overflow, stackoverflow.com/questions/26075366/java-how-to-make-a-popup-window-close-automatically.
 * 
 * "How to Close JFrame on the Click of a Button in Java." Online Tutorials, Courses, and EBooks Library | Tutorialspoint, www.tutorialspoint.com/how-to-close-jframe-on-the-click-of-a-button-in-java.
 *  
 * Version/date: Version 1, 5/14/2024
 * 
 * Responsibilities of class:
 * GUI file
 * Functions as an answer popup
 */
/**
 */
//JeopardyAnswerPopup is-a JeopardyPopup
public class JeopardyAnswerPopup extends JeopardyPopup implements StyleMethods
{
	private final int POPUP_WIDTH  = 350; // JeopardyAnswerPopup has-a popup width
	private final int POPUP_HEIGHT = 100; // JeopardyAnswerPopup has-a popup height
	private final int DURATION = 10; // seconds for popup to exist before closing
	
	private JeopardyStyle style; // JeopardyAnswerPopup has-a style
	private JPanel answerPopup; // JeopardyAnswerPopup has-an answerPopup
	private JLabel textToPopup; // JeopardyAnswerPopup has-an textToPopup
	private JLabel trueAnswer; // JeopardyAnswerPopup has-a trueAnswer (text)
	private boolean correctAnswer; // JeopardyAnswerPopup has-a correctAnswer (boolean)

	// Constructor for JeopardyAnswerPopup
	public JeopardyAnswerPopup(JeopardyStyle style, boolean correctAnswer, String answer)
	{

		this.style = style;
		this.correctAnswer = correctAnswer;
		this.setTitle("Popup");
		this.setSize(POPUP_WIDTH, POPUP_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Answer");
		
		this.answerPopup = new JPanel(new BorderLayout());
		
		// If answer is correct, display correct answer message
		if (correctAnswer)
		{
			this.textToPopup = new JLabel("Correct answer!", SwingConstants.CENTER);
			answerPopup.add(textToPopup);
		}
		// Else, display wrong answer message, along with the correct answer.
		else
		{
			this.textToPopup = new JLabel("Wrong answer. Correct answer: ", SwingConstants.CENTER);
			this.trueAnswer = new JLabel(answer, SwingConstants.CENTER);
			
			answerPopup.add(textToPopup, BorderLayout.NORTH);
			answerPopup.add(trueAnswer, BorderLayout.SOUTH);
		}
		
		// Try and catch for setting colors and fonts in case this non-essential code bugs
		try
		{
			setColors();
			setFonts();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		this.add(answerPopup, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		this.setVisible(true);
		
		// Timer for self-closing popup
		JeopardyAnswerPopup self = this;
	    Timer timer = new Timer(DURATION*1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            self.dispose();
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}

	@Override
	public void setColors()
	{
		Color[] colors = this.style.getStyleColors();
		// If we use this method, implement more here
	}

	@Override
	public void setFonts()
	{
		Font[] fonts = this.style.getStyleFonts();
		textToPopup.setFont(fonts[1]);
		if(!correctAnswer)
		{
			trueAnswer.setFont(fonts[1]);
		}
	}
}
