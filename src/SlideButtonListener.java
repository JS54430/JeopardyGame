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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * Action listener of slide
 */
/**
 */

// SlideButtonListener is ActionListener
public class SlideButtonListener implements ActionListener
{
	private JeopardyStyle jeopardyStyle; // SlideButtonListener has-a style
	private String buttonBehavior; // SlideButtonListener has-a button behavior
	private ArrayList<Object> questionContent; // SlideButtonListener has-a question content
	private JTextField submissionField; // SlideButtonListener has-a submission field
	private String playerAnswer; // SlideButtonListener has-a player answer
	private String trueAnswer; // SlideButtonListener has-a true answer
	private JeopardyGame jeopardyGame; // SlideButtonListener has-a jeopardy game
	private JeopardyModel jeopardyModel; // SlideButtonListener has-a jeopardy model
	private int points; // SlideButtonListener has-a points
	
	// Hint listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, String buttonBehavior, ArrayList<Object> questionContent)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
	}
	
	// Answer listener
	public SlideButtonListener(JeopardyStyle jeopardyStyle, String buttonBehavior, ArrayList<Object> questionContent, JTextField submissionField, JeopardyGame jeopardyGame, JeopardyModel jeopardyModel, int points)
	{
		this.jeopardyStyle = jeopardyStyle;
		this.buttonBehavior = buttonBehavior;
		this.questionContent = questionContent;
		this.submissionField = submissionField;
		this.jeopardyGame = jeopardyGame;
		this.jeopardyModel = jeopardyModel;
		this.points = points;
		this.trueAnswer = (String) questionContent.get(1);
	}
	
	// Determines if the answer is correct or incorrect
	public boolean determineAnswer()
	{
		String lenientTrueAnswer = this.trueAnswer.toLowerCase();
		this.playerAnswer = submissionField.getText().toLowerCase();
		
//		Debug
//		System.out.println(trueAnswer);
//		System.out.println(playerAnswer);
		
		return lenientTrueAnswer.equals(playerAnswer) || playerAnswer.contains(lenientTrueAnswer); // String uses equals because it is an object, lowercase used as to not place importance on capitalization; contains used in case the answer is "close enough"
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
			String hint = (String) questionContent.get(2);
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
