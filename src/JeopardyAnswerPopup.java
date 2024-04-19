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
 * Version/date: Version 1, 4/18/2024
 * 
 * Responsibilities of class:
 * GUI file
 *
 */
/**
 * Functions as an answer popup and hint popup
 */
public class JeopardyAnswerPopup extends JFrame
{
	// TODO
	private final int POPUP_LENGTH = 200;
	private final int POPUP_WIDTH  = 200;
	//private final int DURATION = 5; // seconds for popup to exist before closing
	
	private JeopardyStyle style;
	private JPanel answerPopup; 
	private JLabel textToPopup;

	
	public JeopardyAnswerPopup(JeopardyStyle style, boolean correctAnswer)
	{

		this.style = style;
		this.setTitle("Popup");
		this.setSize(POPUP_LENGTH, POPUP_WIDTH);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.style = style;

		this.setTitle("Answer");

		this.setSize(POPUP_LENGTH , POPUP_WIDTH); 
		
		this.answerPopup = new JPanel();
		this.textToPopup = new JLabel();
		
		if (correctAnswer)
		{
			textToPopup.setText("Correct answer!");
		}
		else
		{
			textToPopup.setText("Wrong answer.");
		}
		
		answerPopup.add(textToPopup);
		this.add(answerPopup);
		this.setVisible(true);
	}
}
