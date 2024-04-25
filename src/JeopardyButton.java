import java.awt.*;
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
 * Version/date: Version 1, 4/24/2024
 * 
 * Responsibilities of class:
 * GUI file
 */
/**
 */

 // grid of buttons, when clicked , jeopardy slide pops up
 //


public class JeopardyButton extends JButton
{
	// TODO
	// Add more to constructor parameters and constructor as needed
	// Implement action listener, see fishingGame for example
	
	private Color buttonColor;
	private int buttonRow;
	private int buttonColumn;
	private JeopardyStyle buttonStyle;
	private String text;
	
	public JeopardyButton(int buttonRow, int buttonColumn, JeopardyStyle style, String text)
	{
		this.buttonRow = buttonRow;
		this.buttonColumn = buttonColumn;
		this.buttonStyle = style;
		this.text = text;
		this.setText(text);
	}
	
	// Disable button and change color to finished when clicked
	public void setButtonColor(Color buttonColor) 
	{
		this.buttonColor = buttonColor;
	}
	
	public int getRow()
	{
		return buttonRow;
	}
	
	public int getColumn()
	{
		return buttonColumn;
	}
}
