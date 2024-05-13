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
 */

/**
 */

 // JeopardyStyle uses StyleOutline
public class JeopardyStyle implements StyleOutline
{
	// Fonts
	private Color backgroundColor; // JeopardyStyle has-a background color
	private Color buttonColor; // JeopardyStyle has-a button color
	private Color finishedButtonColor; // JeopardyStyle has-a finished button color
	private Color hintButtonColor; // JeopardyStyle has-a hint button color
	
	// Fonts
	private Font slideFont; // JeopardyStyle has-a slide font
	private Font headerFont; // JeopardyStyle has-a header font
	private Font buttonFont; // JeopardyStyle has-a button font
	private Font hintButtonFont; // JeopardyStyle has-a hint button font
	private Font categoryFont; // JeopardyStyle has-a category font
	
	private Color styleColors[]; // JeopardyStyle has-a color array
	private Font styleFonts[]; // JeopardyStyle has-a font array
	
	// Constructor for JeopardyStyle with listed parameters
	public JeopardyStyle(Color backgroundColor, Color buttonColor, Color finishedButtonColor, Color hintButtonColor, Font slideFont, Font headerFont, Font buttonFont, Font hintButtonFont, Font categoryFont)
	{
		this.backgroundColor = backgroundColor;
		this.buttonColor = buttonColor;
		this.finishedButtonColor = finishedButtonColor;
		this.hintButtonColor = hintButtonColor;
		
		this.slideFont = slideFont;
		this.headerFont = headerFont;
		this.buttonFont = buttonFont;
		this.hintButtonFont = hintButtonFont;
		this.categoryFont = categoryFont;
		
		setStyleColors();
		setStyleFonts();
	}
	
	// Alternative constructor for JeopardyStyle that uses arrays instead
	public JeopardyStyle(Color colorArray[], Font fontArray[])
	{
		this.backgroundColor = colorArray[0];
		this.buttonColor = colorArray[1];
		this.finishedButtonColor = colorArray[2];
		this.hintButtonColor = colorArray[3];
		
		this.slideFont = fontArray[0];
		this.headerFont = fontArray[1];
		this.buttonFont = fontArray[2];
		this.hintButtonFont = fontArray[3];
		this.categoryFont = fontArray[4];
		
		setStyleColors();
		setStyleFonts();
	}
	
	// Sets the colors of the styleColors array
	public void setStyleColors()
	{
		this.styleColors = new Color[4];
		styleColors[0] = this.backgroundColor;
		styleColors[1] = this.buttonColor;
		styleColors[2] = this.finishedButtonColor;
		styleColors[3] = this.hintButtonColor;
	}
	
	// Sets the fonts of the styleFonts array
	public void setStyleFonts()
	{
		this.styleFonts = new Font[5];
		styleFonts[0] = this.slideFont;
		styleFonts[1] = this.headerFont;
		styleFonts[2] = this.buttonFont;
		styleFonts[3] = this.hintButtonFont;
		styleFonts[4] = this.categoryFont;
	}
	
	// ACCESSING COLORS in order: backgroundColor, buttonColor, finishedButtonColor, hintButtonColor
	public Color[] getStyleColors()
	{
		return styleColors;
	}
	
	// ACCESSING FONTS (Fonts) in order: slideFont, finishedSlideFont, headerFont, buttonFont, hintButtonFont, categoryFont
	public Font[] getStyleFonts()
	{
		return styleFonts;
	}
}
