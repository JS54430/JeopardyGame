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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * GUI file
 * grid of buttons, when clicked, jeopardy slide pops up
 */
/**
 */
// JeopardyButton is-a JButton, uses StyleMethods
public class JeopardyButton extends JButton implements StyleMethods
{
	// Add more to constructor parameters and constructor as needed
	private Color buttonColor; // JeopardyButton has-a color
	private int buttonRow; // JeopardyButton has-a int row
	private int buttonColumn; // JeopardyButton has-a int column
	private JeopardyStyle buttonStyle; // JeopardyButton has-a style
	private String text; // JeopardyButton has text
	
	// Constructor for JeopardyButton
	public JeopardyButton(int buttonRow, int buttonColumn, JeopardyStyle style, String text)
	{
		this.buttonRow = buttonRow;
		this.buttonColumn = buttonColumn;
		this.buttonStyle = style;
		this.text = text;
		this.setText(text);
				
		setColors();
		setFonts();
	}
	
	// Constructor for JeopardyButton
	public JeopardyButton(JeopardyStyle style, String text)
	{
		this.buttonStyle = style;
		this.text = text;
		this.setText(text);
		
		setColors();
		setFonts();
	}
	
	// returns row
	public int getRow()
	{
		return buttonRow;
	}
	
	// returns column
	public int getColumn()
	{
		return buttonColumn;
	}

	// Sets colors for the buttons on the board
	@Override
	public void setColors()
	{
		Color[] colors = this.buttonStyle.getStyleColors();
		this.buttonColor = colors[1];
		this.setBackground(this.buttonColor);
	}

	// Sets the font for the buttons on the board
	@Override
	public void setFonts()
	{
		Font[] fonts = this.buttonStyle.getStyleFonts();
		this.setFont(fonts[2]);
	}
}
