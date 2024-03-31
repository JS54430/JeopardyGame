import java.awt.Color;

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
/**
 */
public abstract class StyleOutline
{
	// TODO add more to style outline as needed
	
	private Color backgroundColor;
	private Color buttonColor;
	private Color finishedButtonColor;
	private Color hintButtonColor;
	
	private String slideFont;
	private String finishedSlideFont; // When slide is clicked
	
	private String headerFont;
	private String buttonFont;
	private String hintButtonFont;
	private String categoryFont;
	
	abstract void setButtonColor();
	abstract void setHintButtonColor();
}
