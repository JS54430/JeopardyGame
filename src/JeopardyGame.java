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
 * How to remove all components from a JFrame in Java? (n.d.). Stack Overflow. https://stackoverflow.com/questions/9347076/how-to-remove-all-components-from-a-jframe-in-java
 *  
 * Version/date: Version 1, 5/1/2024
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
	private final int WINDOW_WIDTH = 600;
	private JButton creditsButton;
	private JPanel categoryPanel;
	private JPanel pointQuestionPanel;
	private JPanel pointButtonRow;
	private JPanel gamePanel;
	private JeopardyButton[][] jeopardyGrid;
	private JeopardyModel jeopardyModel;
	private JeopardyStyle jeopardyStyle;
	private JeopardyQAndA questionsAndAnswers;
	
	// TODO
	public JeopardyGame(JeopardyStyle style, JeopardyModel model, JeopardyQAndA questionsAndAnswers)
	{
		// TODO Use style attributes
		this.jeopardyStyle = style;
		this.jeopardyModel = model;
		this.questionsAndAnswers = questionsAndAnswers; // Redundant
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
		// Set the title of the window
		this.setTitle("Jeopardy Game");
		
		// Set the size of the window.
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// JPanel declarations
		categoryPanel = new JPanel(new GridLayout());
		pointQuestionPanel = new JPanel();
		pointButtonRow = new JPanel(new GridLayout());
		gamePanel = new JPanel(new BorderLayout());
		
		
		Object[][] grid = jeopardyModel.getGrid();
		jeopardyGrid = new JeopardyButton[grid.length][grid[0].length]; // null array
		
		for (int j = 0; j<grid.length; j++)
		{
			if (j == 0)
			 {
				for (int i = 0; i<grid[0].length; i++)
				{
					JLabel currentCategory = new JLabel( (String) grid[0][i] );
					categoryPanel.add(currentCategory);
				}
			}
			else
			{
				for (int k = 0; k<grid[j].length; k++)
				{
					JeopardyButton button = new JeopardyButton(j, k, jeopardyStyle, grid[j][k].toString());
					jeopardyGrid[j][k] = button;
					
					button.addActionListener(new JeopardyButtonListener(jeopardyModel, this, this.questionsAndAnswers, jeopardyStyle, button));
					
					pointButtonRow.add(button);
				}
				pointQuestionPanel.add(pointButtonRow);
				pointButtonRow = new JPanel(new GridLayout());
			}
		}
		
		gamePanel.add(categoryPanel, BorderLayout.NORTH);
		gamePanel.add(pointQuestionPanel, BorderLayout.CENTER);
		
		this.add(gamePanel);
		
		// Implement any other final GUI stuff here
		/*
		 * 
		 * 
		 * 
		 * 
		 */
		
		this.setVisible(true);
	}
	
	public void loadSlide(JeopardySlide loadedSlide)
	{
		 this.getContentPane().removeAll();
		 this.repaint();
		 this.add(loadedSlide, BorderLayout.CENTER);
	}
	
	public void loadRegularScreen()
	{
		this.getContentPane().removeAll();
		this.repaint();
		this.add(gamePanel, BorderLayout.CENTER);
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
		/*
		JeopardyAnswerPopup popupExample = new JeopardyAnswerPopup(styleExample2, true);
		*/
		
		JeopardyQAndA exampleQAndA = new JeopardyQAndA("exampleQAndA.csv");
		
		JeopardyModel exampleModel = new JeopardyModel(exampleQAndA);
		
		JeopardyGame exampleGame = new JeopardyGame(styleExample2, exampleModel, exampleQAndA);
	}
}