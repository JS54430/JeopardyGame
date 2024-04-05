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
 * Version/date: Version 1, 3/28/2024
 * 
 * Responsibilities of class:
 * GUI file
 */

import java.awt.Color;

/**
 */
public class JeopardyStyle extends StyleOutline
{
	// TODO
	public JeopardyStyle(Color[] styleColors, String[] styleFonts)
	{
		super(styleColors, styleFonts);
	}
	
	public Color[] getStyleColors()
	{
		return styleColors;
	}
	public String[] getStyleFonts()
	{
		return styleFonts;
	}
	
	public void setButtonColor(Color buttonColor) 
	{
		this.buttonColor = buttonColor;
	}
	
	public void setHintButtonColor(Color hintButtonColor) 
	{
		this.hintButtonColor = hintButtonColor;
	}
}
