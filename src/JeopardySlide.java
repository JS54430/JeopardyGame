import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.*;

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
 * Version/date: Version 1, 5/1/2024
 * 
 * Responsibilities of class:
 * GUI file
 * Displays question when button on board is clicked
 *
 */
/**
 */
public class JeopardySlide extends JPanel
{
	private ArrayList<String> questionContent; // element from JeopardyQAndA
	private JeopardyStyle slideStyle;
	private JLabel directions;
	private JeopardyButton submissionButton;
	private JTextField submissionField;
	private JeopardyButton hintButton;

	// If hint button is pressed, cue JeopardyAnswerPopup to appear
	
	public JeopardySlide (JeopardyStyle style, ArrayList<String> questionContent)
	{
		// TODO
		// GUI stuff
		this.slideStyle = style;
		this.questionContent = questionContent;
		this.setLayout(new BorderLayout());
		
		// Top
		this.directions = new JLabel("Submit the answer to the following question\n"+questionContent.get(0));
		
		// Center
		this.submissionField = new JTextField();
		this.submissionButton = new JeopardyButton(slideStyle, "Submit Answer");
		submissionButton.addActionListener(new SlideButtonListener(slideStyle, submissionButton, "Answer", this.questionContent, submissionField));
		
		// Bottom
		this.hintButton = new JeopardyButton(slideStyle, "Hint");
		hintButton.addActionListener(new SlideButtonListener(slideStyle, hintButton, "Hint", this.questionContent));
		
		JPanel top = new JPanel();
		JPanel center = new JPanel(new GridLayout());
		JPanel bottom = new JPanel();
		
		top.add(directions);
		center.add(submissionField);
		center.add(submissionButton);
		bottom.add(hintButton);
		
		this.add(top, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

		this.setVisible(true);
		
		//System.out.println("slide exists"); //debug
	}
}