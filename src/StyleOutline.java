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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * GUI file
 * Used in JeopardyStyle
 */
/**
 */
public interface StyleOutline
{
	// Sets the style's colors
	public abstract void setStyleColors();
	
	// Sets the style's fonts
	public abstract void setStyleFonts();
	
	// Returns an array of the style's colors
	public abstract Color[] getStyleColors();
	
	// Returns an array of the style's fonts
	public abstract Font[] getStyleFonts();	
}
