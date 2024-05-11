import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

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
 * Version/date: Version 1, 5/4/2024
 * 
 * Responsibilities of class:
 * GUI file
 */
/**
 */

// JeopardyGame is-a JFrame
public class JeopardyGame extends JFrame implements StyleMethods
{
	private final int WINDOW_HEIGHT = 500;
	private final int WINDOW_WIDTH = 500;
	private JLabel credits;
	private JPanel categoryPanel;
	private JPanel pointQuestionPanel;
	private JPanel pointButtonRow;
	private JLabel playerPoints;
	private JPanel gamePanel;
	private JeopardyButton[][] jeopardyGrid;
	private JeopardyModel jeopardyModel;
	private JeopardyStyle jeopardyStyle;
	private JeopardyQAndA questionsAndAnswers;
	
	private JPanel currentPanel;
	
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
		
		setColors();
		setFonts();
		
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
		this.getContentPane().remove(gamePanel);
		this.currentPanel = loadedSlide;
		this.add(currentPanel, BorderLayout.CENTER);
		this.repaint();
		
		// Setting size updates the GUI for some reason
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT+1);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void loadRegularScreen()
	{
		this.getContentPane().removeAll();
		this.add(gamePanel, BorderLayout.CENTER);
		this.repaint();
		
		// Setting size updates the GUI for some reason
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT+1);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
//		System.out.println(jeopardyModel.checkGameOver()); // Debug
		if(jeopardyModel.checkGameOver())
		{
			// Code to load if game over (all questions ran through)
		}
	}
	
	public static void main (String args[])
	{
		
		Font fontEx1 = new Font("Arial", Font.PLAIN, 20);
		Font fontEx2 = new Font("Times New Roman", Font.PLAIN, 30);
		Color testColors[] = {Color.RED, Color.YELLOW, Color.PINK, Color.BLACK};
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		JeopardyStyle styleExample2 = new JeopardyStyle(testColors, testFonts);
		
		JeopardyStyle styleExample1 = new JeopardyStyle(Color.RED, Color.YELLOW, Color.PINK, Color.BLACK, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2);
					
		JeopardyQAndA exampleQAndA = new JeopardyQAndA("exampleQAndA.csv");
		
		JeopardyModel exampleModel = new JeopardyModel(exampleQAndA);
		
		JeopardyGame exampleGame = new JeopardyGame(styleExample1, exampleModel, exampleQAndA);
	}

	@Override
	public void setColors()
	{
		Color[] colors = this.jeopardyStyle.getStyleColors();
		this.setBackground(colors[0]);
		this.gamePanel.setBackground(colors[0]);
		// Add to as necessary
	}

	@Override
	public void setFonts()
	{
		Font[] fonts = this.jeopardyStyle.getStyleFonts();
//		 System.out.println(Arrays.toString(fonts)); // Debug
		// Set fonts for each panel and item
	}
}