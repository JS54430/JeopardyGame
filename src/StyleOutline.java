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
	
	protected Color backgroundColor;
	protected Color buttonColor;
	protected Color finishedButtonColor;
	protected Color hintButtonColor;
	
	protected String slideFont;
	protected String finishedSlideFont; // When slide is clicked
	
	protected String headerFont;
	protected String buttonFont;
	protected String hintButtonFont;
	protected String categoryFont;
	
	protected Color styleColors[];
	protected String styleFonts[];
	
	// Constructor for style outline
	// ACCESSING COLORS in order: backgroundColor, buttonColor, finishedButtonColor, hintButtonColor
	// ACCESSING FONTS (Strings) in order: slideFont, finishedSlideFont, headerFont, buttonFont, hintButtonFont, categoryFont
	public StyleOutline (Color[] styleColors, String[] styleFonts)
	{
		this.backgroundColor = styleColors[0];
		this.buttonColor = styleColors[1];
		this.finishedButtonColor = styleColors[2];
		this.hintButtonColor = styleColors[3];
		
		this.slideFont = styleFonts[0];
		this.finishedSlideFont = styleFonts[1];
		this.headerFont = styleFonts[2];
		this.buttonFont = styleFonts[3];
		this.hintButtonFont = styleFonts[4];
		this.categoryFont = styleFonts[5];
		
		this.styleColors = styleColors;
		this.styleFonts = styleFonts;
	}
	
	public abstract Color[] getStyleColors();
	public abstract String[] getStyleFonts();
	
	public abstract void setButtonColor(Color givenColor);
	public abstract void setHintButtonColor(Color givenColor);
	
}
