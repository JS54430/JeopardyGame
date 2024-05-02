import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
 * 
 */
/**
 */

public class SlideButtonListener implements ActionListener
{
	private JeopardyButton jeopardyButton;
	private String buttonBehavior;
	
	public SlideButtonListener(JeopardyButton jeopardyButton, String buttonBehavior)
	{
		this.jeopardyButton = jeopardyButton;
		this.buttonBehavior = buttonBehavior;
	}
	
	
	// Creates a new JeopardyAnswerPopup depending on behavior
	// If hint, displays hint text
	// If answer, displays right or wrong, as well as correct answer
	public void actionPerformed(ActionEvent e)
	{
		if (buttonBehavior == "Hint")
		{
			// Display hint
			// Use hint constructor
		}
		else
		{
			// Answer behavior
			// JeopardyAnswerPopup popupExample = new JeopardyAnswerPopup(styleExample2, false);
			// Use answer constructor
		}
	}
}
