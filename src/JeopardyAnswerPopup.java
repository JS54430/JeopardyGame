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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * GUI file
 *
 */
/**
 * Functions as an answer popup
 */

//JeopardyAnswerPopup is-a JeopardyPopup
public class JeopardyAnswerPopup extends JeopardyPopup implements StyleMethods
{
	private final int POPUP_HEIGHT = 100;
	private final int POPUP_WIDTH  = 350;
	//private final int DURATION = 5; // seconds for popup to exist before closing
	
	private JeopardyStyle style;
	private JPanel answerPopup; 
	private JLabel textToPopup;
	private JLabel trueAnswer;
	private boolean correctAnswer;

	
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
		
		if (correctAnswer)
		{
			this.textToPopup = new JLabel("Correct answer!", SwingConstants.CENTER);
			answerPopup.add(textToPopup);
		}
		else
		{
			this.textToPopup = new JLabel("Wrong answer. Correct answer: ", SwingConstants.CENTER);
			this.trueAnswer = new JLabel(answer, SwingConstants.CENTER);
			
			answerPopup.add(textToPopup, BorderLayout.NORTH);
			answerPopup.add(trueAnswer, BorderLayout.SOUTH);
		}
		
		setColors();
		setFonts();
		
		this.add(answerPopup, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		this.setVisible(true);
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
