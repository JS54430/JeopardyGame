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
 * Admin. "How to Change the Background Color of a JButton." StackHowTo, 10 Oct. 2021, stackhowto.com/how-to-change-the-background-color-of-a-jbutton/.
 *  
 * Version/date: Version 1, 5/10/2024
 * 
 * Responsibilities of class:
 * 
 */
/**
 */

public class JeopardyButtonListener implements ActionListener
{
	private JeopardyModel jeopardyModel;
	private JeopardyGame jeopardyGame;
	private JeopardyButton jeopardyButton;
	private JeopardyQAndA questionsAndAnswers;
	private JeopardyStyle jeopardyStyle;
	private int buttonRow;
	private int buttonColumn;
	private ArrayList<String> questionContent;
	
	/**
	 * @param jeopardyModel
	 * @param jeopardyGame
	 * @param questionsAndAnswers
	 * @param jeopardyStyle
	 * @param jeopardyButton
	 */
	public JeopardyButtonListener(JeopardyModel jeopardyModel, JeopardyGame jeopardyGame, JeopardyQAndA questionsAndAnswers, JeopardyStyle jeopardyStyle, JeopardyButton jeopardyButton)
	{
		this.jeopardyModel = jeopardyModel;
		this.jeopardyGame = jeopardyGame;
		this.jeopardyButton = jeopardyButton;
		this.questionsAndAnswers = questionsAndAnswers;
		this.jeopardyStyle = jeopardyStyle;
		
		// Button coordinates for which button was clicked
		this.buttonRow = jeopardyButton.getRow();
		this.buttonColumn = jeopardyButton.getColumn();
		
		// Uses button coordinates to access to question content
		this.questionContent = questionsAndAnswers.getQuestionContent(buttonRow, buttonColumn);
	}
	
	// When (usable) button is clicked
	public void actionPerformed(ActionEvent e)
	{
		// Update button to not be clickable
		jeopardyButton.setEnabled(false);
		jeopardyButton.setBackground(jeopardyStyle.getStyleColors()[2]); // finished style color
				
		jeopardyGame.loadSlide(new JeopardySlide(jeopardyStyle, questionContent, jeopardyGame));
	}
}
