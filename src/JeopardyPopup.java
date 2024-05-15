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
 * Version/date: Version 1, 5/14/2024
 * 
 * Responsibilities of class:
 * GUI file
 *
 */
/**
 * Abstract popup class
 */

//JeopardyPopup is-a JFrame
public abstract class JeopardyPopup extends JFrame implements StyleMethods
{
	private final int POPUP_WIDTH = 999; // JeopardyPopup has-a width
	private final int POPUP_HEIGHT = 999; // JeopardyPopup has-a height
	private final int DURATION = 99; // seconds for popup to exist before closing
	
	private JeopardyStyle style; // JeopardyPopup has-a style
	private JLabel textToPopup; // JeopardyPopup has-a text to popup
	
	public abstract void setColors();
	public abstract void setFonts();
}