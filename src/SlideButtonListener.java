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
 * Version/date: Version 1, 5/11/2024
 * 
 * Responsibilities of class:
 * 
 */
/**
 */

// SlideButtonListener is ActionListener
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
	private JeopardyModel jeopardyModel;
	private int points;
	
	// Hint listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, JeopardyButton jeopardyButton, String buttonBehavior, ArrayList<String> questionContent)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.jeopardyButton = jeopardyButton;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
	}
	
	// Answer listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, JeopardyButton jeopardyButton, String buttonBehavior, ArrayList<String> questionContent, JTextField submissionField, JeopardyGame jeopardyGame, JeopardyModel jeopardyModel, int points)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.jeopardyButton = jeopardyButton;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
		this.submissionField = submissionField;
		this.jeopardyGame = jeopardyGame;
		this.jeopardyModel = jeopardyModel;
		this.points = points;
	}
	
	// Determines if the answer is correct or incorrect
	public boolean determineAnswer()
	{
		this.trueAnswer = questionContent.get(1).toLowerCase();
		this.playerAnswer = submissionField.getText().toLowerCase();
		
//		Debug
//		System.out.println(trueAnswer);
//		System.out.println(playerAnswer);
		
		return trueAnswer.equals(playerAnswer) || playerAnswer.contains(trueAnswer); // String uses equals because it is an object, lowercase used as to not place importance on capitalization; contains used in case the answer is "close enough"
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
			new JeopardyHintPopup(jeopardyStyle, hint);
		}
		else
		{
			// Answer behavior
			// Use answer constructor
			new JeopardyAnswerPopup(jeopardyStyle, determineAnswer(), trueAnswer);
			if(determineAnswer())
			{
				jeopardyModel.updatePoints(1, this.points); // Change player as needed if multiplayer
			}
			jeopardyGame.loadRegularScreen();
		}
	}
}
