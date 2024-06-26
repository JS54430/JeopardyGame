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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * Action listener of JeopardyButton
 */
/**
 */

// JeopardyButtonListener is ActionListener
public class JeopardyButtonListener implements ActionListener
{
	private JeopardyModel jeopardyModel; // JeopardyButtonListener has-a jeopardy model
	private JeopardyGame jeopardyGame; // JeopardyButtonListener has-a jeopardy game
	private JeopardyButton jeopardyButton; // JeopardyButtonListener has-a jeopardy button
	private JeopardyStyle jeopardyStyle; // JeopardyButtonListener has-a jeopardy style
	private int buttonRow; // JeopardyButtonListener has-a button row
	private int buttonColumn; // JeopardyButtonListener has-a button column
	private ArrayList<Object> questionContent; // JeopardyButtonListener has-a questionContent 
	private int points; // JeopardyButtonListener has-a points
	
	// Constructor for JeopardyButtonListener
	public JeopardyButtonListener(JeopardyModel jeopardyModel, JeopardyGame jeopardyGame, JeopardyStyle jeopardyStyle, ArrayList<Object> questionContent, JeopardyButton jeopardyButton)
	{
		this.jeopardyModel = jeopardyModel;
		this.jeopardyGame = jeopardyGame;
		this.jeopardyButton = jeopardyButton;
		this.jeopardyStyle = jeopardyStyle;

		// Button coordinates for which button was clicked
		this.buttonRow = jeopardyButton.getRow();
		this.buttonColumn = jeopardyButton.getColumn();
		this.questionContent = questionContent;
		this.points = (int) jeopardyModel.getGrid()[buttonRow][buttonColumn];
	}
	
	// When (usable) button is clicked
	public void actionPerformed(ActionEvent e)
	{
		jeopardyButton.setEnabled(false); // Update button to not be clickable
		jeopardyButton.setBackground(jeopardyStyle.getStyleColors()[2]); // finished style color
		jeopardyModel.setButtonChecked(buttonRow, buttonColumn); // checks button on checked grid
		
//		System.out.println(Arrays.deepToString(jeopardyModel.getCheckedGrid())); // Debug
				
		jeopardyGame.loadSlide(new JeopardySlide(jeopardyStyle, questionContent, jeopardyGame, jeopardyModel, points)); // New slide loaded
	}
}
