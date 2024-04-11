import java.awt.Color;
import java.awt.Font;

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
 * Goes completely off user-input
 */

/**
 */
public class CustomJeopardyStyle extends JeopardyStyle
{
	// TODO
	public CustomJeopardyStyle(Color backgroundColor, Color buttonColor, Color finishedButtonColor, Color hintButtonColor, Font slideFont, Font finishedSlideFont, Font headerFont, Font buttonFont, Font hintButtonFont, Font categoryFont)
	{
		super(backgroundColor, buttonColor, finishedButtonColor, hintButtonColor, slideFont, finishedSlideFont, headerFont, buttonFont, hintButtonFont, categoryFont);
	}
	
	public CustomJeopardyStyle(Color colorArray[], Font fontArray[])
	{
		super(colorArray[0],colorArray[1],colorArray[2],colorArray[3],fontArray[0],fontArray[1],fontArray[2],fontArray[3],fontArray[4],fontArray[5]);
	}
}
