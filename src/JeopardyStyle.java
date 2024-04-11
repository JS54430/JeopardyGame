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
public class JeopardyStyle extends StyleOutline
{
	// TODO
	
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
	
	private Color styleColors[];
	private Font styleFonts[];
	
	public JeopardyStyle(Color backgroundColor, Color buttonColor, Color finishedButtonColor, Color hintButtonColor, Font slideFont, Font finishedSlideFont, Font headerFont, Font buttonFont, Font hintButtonFont, Font categoryFont)
	{
		super(backgroundColor, buttonColor, finishedButtonColor, hintButtonColor, slideFont, finishedSlideFont, headerFont, buttonFont, hintButtonFont, categoryFont);
	}
	
	public JeopardyStyle(Color colorArray[], Font fontArray[])
	{
		super(colorArray[0],colorArray[1],colorArray[2],colorArray[3],fontArray[0],fontArray[1],fontArray[2],fontArray[3],fontArray[4],fontArray[5]);
	}
	
	public void setStyleColors()
	{
		this.styleColors = new Color[4];
		styleColors[0] = this.backgroundColor;
		styleColors[1] = this.buttonColor;
		styleColors[2] = this.finishedButtonColor;
		styleColors[3] = this.hintButtonColor;
	}
	
	public void setStyleFonts()
	{
		this.styleFonts = new Font[6];
		styleFonts[0] = this.slideFont;
		styleFonts[1] = this.finishedSlideFont;
		styleFonts[2] = this.headerFont;;
		styleFonts[3] = this.buttonFont;
		styleFonts[4] = this.hintButtonFont;
		styleFonts[5] = this.categoryFont;

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
