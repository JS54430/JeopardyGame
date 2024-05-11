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
 * Version/date: Version 1, 5/10/2024
 * 
 * Responsibilities of class:
 * 
 */
/**
 */

public class SlideButtonListener implements ActionListener
{
	private JeopardyStyle jeopardyStyle;
	private JeopardyButton jeopardyButton;
	private String buttonBehavior;
	private ArrayList<String> questionContent;
	private JTextField submissionField;
	private String playerAnswer;
	private String trueAnswer;
	private JeopardyGame jeopardyGame;
	
	// Hint listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, JeopardyButton jeopardyButton, String buttonBehavior, ArrayList<String> questionContent)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.jeopardyButton = jeopardyButton;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
	}
	
	// Answer listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, JeopardyButton jeopardyButton, String buttonBehavior, ArrayList<String> questionContent, JTextField submissionField, JeopardyGame jeopardyGame)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.jeopardyButton = jeopardyButton;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
		this.submissionField = submissionField;
		this.jeopardyGame = jeopardyGame;
	}
	
	// Determines if the answer is correct or incorrect
	public boolean determineAnswer()
	{
		this.trueAnswer = questionContent.get(1);
		this.playerAnswer = submissionField.getText();
		
//		Debug
//		System.out.println(trueAnswer);
//		System.out.println(playerAnswer);
		
		return trueAnswer.equals(playerAnswer); // String uses equals because it is an object
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
			String hint = questionContent.get(2);
			new JeopardyAnswerPopup(jeopardyStyle, hint);
		}
		else
		{
			// Answer behavior
			// Use answer constructor
			new JeopardyAnswerPopup(jeopardyStyle, determineAnswer(), trueAnswer);
			jeopardyGame.loadRegularScreen();
		}
	}
}
