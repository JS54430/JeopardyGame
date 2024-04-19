import java.awt.*;
import java.awt.event.*;
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
 * Version/date: Version 1, 4/11/2024
 * 
 * Responsibilities of class:
 * GUI file
 */
/**
 */

// JeopardyGame is-a JFrame
public class JeopardyGame extends JFrame
{
	private final int WINDOW_HEIGHT = 600;
	private final int WINDOW_WIDTH = 300;
	private JButton creditsButton;
	private JPanel categoryPanel;
	private JPanel pointQuestionPanel;
	private JeopardyButton[][] jeopardyGrid;
	private JeopardyModel jeopardyModel;
	private JeopardyStyle jeopardyStyle;
	
	// TODO
	public JeopardyGame(JeopardyStyle style, JeopardyModel model, JeopardyQAndA questionsAndAnswers)
	{
		
	}
	
	public void loadSlide(JeopardySlide loadedSlide)
	{
		
	}
	
	public void loadRegularScreen()
	{
		
	}
	
	public static void main (String args[])
	{
		Font fontEx1 = new Font("Arial", Font.PLAIN, 20);
		Font fontEx2 = new Font("Times New Roman", Font.PLAIN, 30);
		Color testColors[] = {Color.RED, Color.YELLOW, Color.PINK, Color.BLACK};
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		JeopardyStyle styleExample2 = new JeopardyStyle(testColors, testFonts);
		
		// JeopardySlide
		
		// JeopardyAnswerPopup
		JeopardyAnswerPopup popupExample = new JeopardyAnswerPopup(styleExample2, true);
	}
}