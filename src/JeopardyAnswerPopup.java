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
 * Version/date: Version 1, 5/5/2024
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
	private final int POPUP_HEIGHT = 300;
	private final int POPUP_WIDTH  = 100;
	//private final int DURATION = 5; // seconds for popup to exist before closing
	
	private JeopardyStyle style;
	private JPanel answerPopup; 
	private JLabel textToPopup;

	
	public JeopardyAnswerPopup(JeopardyStyle style, boolean correctAnswer, String answer)
	{

		this.style = style;
		this.setTitle("Popup");
		this.setSize(POPUP_HEIGHT, POPUP_WIDTH);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Answer");
		
		this.answerPopup = new JPanel();
		this.textToPopup = new JLabel();
		
		if (correctAnswer)
		{
			textToPopup.setText("Correct answer!");
		}
		else
		{
			textToPopup.setText("Wrong answer. Correct answer:"+answer);
		}
		
		answerPopup.add(textToPopup);
		this.add(answerPopup);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JeopardyAnswerPopup(JeopardyStyle style, String hint)
	{

		this.style = style;
		this.setTitle("Popup");
		this.setSize(POPUP_HEIGHT, POPUP_WIDTH);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.style = style;

		this.setTitle("Hint");

		this.setSize(POPUP_HEIGHT , POPUP_WIDTH); 
		
		this.answerPopup = new JPanel();
		this.textToPopup = new JLabel(hint);
		
		answerPopup.add(textToPopup);
		this.add(answerPopup);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
}
