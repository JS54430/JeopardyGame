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
	private JeopardyButton hintButton;
	private JeopardyButton submissionButton;
	private JTextField submissionField;
	// If hint button is pressed, cue JeopardyAnswerPopup to appear
	
	public JeopardySlide (JeopardyStyle style, ArrayList<String> questionContent)
	{
		// TODO
		// GUI stuff
		this.slideStyle = style;
		this.questionContent = questionContent;
		
		this.setLayout(new BorderLayout());
		
	}
}