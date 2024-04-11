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
 * Font (Java platform SE 8 ). (2024, January 8). Moved. https://docs.oracle.com/javase/8/docs/api/java/awt/Font.html
 * 
 * Java Font. (n.d.). Code Ease. https://www.codeease.net/programming/java/java-font
 * 
 * Version/date: Version 1, 4/11/2024
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
	
	private Font slideFont;
	private Font finishedSlideFont; // When slide is clicked
	
	private Font headerFont;
	private Font buttonFont;
	private Font hintButtonFont;
	private Font categoryFont;
	
	// Constructor for style outline with parameter list
	public StyleOutline (Color backgroundColor, Color buttonColor, Color finishedButtonColor, Color hintButtonColor, Font slideFont, Font finishedSlideFont, Font headerFont, Font buttonFont, Font hintButtonFont, Font categoryFont)
	{
		this.backgroundColor = backgroundColor;
		this.buttonColor = buttonColor;
		this.finishedButtonColor = finishedButtonColor;
		this.hintButtonColor = hintButtonColor;
		
		this.slideFont = slideFont;
		this.finishedSlideFont = finishedSlideFont;
		this.headerFont = headerFont;
		this.buttonFont = buttonFont;
		this.hintButtonFont = hintButtonFont;
		this.categoryFont = categoryFont;
		
		// Sets the arrays for the colors and font arrays respectively
		setStyleColors();
		setStyleFonts();
	}
	
	public abstract void setStyleColors();
	public abstract void setStyleFonts();
	
	public abstract Color[] getStyleColors();
	public abstract Font[] getStyleFonts();	
}
