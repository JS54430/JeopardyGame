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
 * Version/date: Version 1, 4/11/2024
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
	
	/**
	 * @param jeopardyModel
	 * @param jeopardyGame
	 * @param jeopardyButton
	 */
	public JeopardyButtonListener(JeopardyModel jeopardyModel, JeopardyGame jeopardyGame, JeopardyButton jeopardyButton)
	{
		this.jeopardyModel = jeopardyModel;
		this.jeopardyGame = jeopardyGame;
		this.jeopardyButton = jeopardyButton;
	}
	
	// When (usable) button is clicked
	public void actionPerformed(ActionEvent e)
	{
		// Button coordinates for which button was clicked
		int buttonRow = jeopardyButton.getRow();
		int buttonColumn = jeopardyButton.getColumn();

		// JeopardyPopUp at button spot
		

		// Update button to not be clickable
		//jeopardyModel.updateUI();
	}
}
