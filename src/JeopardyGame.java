import java.awt.*;
import java.awt.event.*;
import java.util.*;
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
 * "How to Center JLabel in Jframe Swing?" Stack Overflow, stackoverflow.com/questions/19506769/how-to-center-jlabel-in-jframe-swing.
 * 
 * "Java JFrame Size: How to Set the JFrame Size." Scala, Java, Unix, MacOS Tutorials (page 1) | Alvinalexander.com, 6 Aug. 2022, alvinalexander.com/java/java-set-jframe-size/.
 *  
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * GUI file
 */
/**
 */

// JeopardyGame is-a JFrame
public class JeopardyGame extends JFrame implements StyleMethods
{
	private final int WINDOW_HEIGHT = 350; // JeopardyGame has-a window height
	private final int WINDOW_WIDTH = 500; // JeopardyGame has-a window width
	private final int SLIDE_WIDTH = 1500; // JeopardyGame has-a slide window width
	private JLabel credits; // JeopardyGame has-a credits label
	private JLabel playerPoints; // JeopardyGame has-a player points label
	private JPanel categoryPanel; // JeopardyGame has-a category panel
	private JPanel pointQuestionPanel; // JeopardyGame has-a point questions panel
	private JPanel pointButtonRow; // JeopardyGame has-a point button row
	private JPanel bottomPanel; // JeopardyGame has-a bottom panel
	private JPanel gamePanel; // JeopardyGame has-a game panel
	private JeopardyButton[][] jeopardyGrid; // JeopardyGame has-a jeopardy grid
	private JeopardyModel jeopardyModel; // JeopardyGame has-a jeopardy model
	private JeopardyStyle jeopardyStyle; // JeopardyGame has-a jeopardy style
	private JeopardyQAndA questionsAndAnswers; // JeopardyGame has-a questions and answers
	private JPanel currentPanel; // JeopardyGame has-a current panel
	
	public JeopardyGame(JeopardyStyle style, JeopardyModel model, JeopardyQAndA questionsAndAnswers)
	{
		// TODO Use style attributes
		this.jeopardyStyle = style;
		this.jeopardyModel = model;
		this.questionsAndAnswers = questionsAndAnswers;
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the title of the window
		this.setTitle("Jeopardy Game");
		
	    //this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		// JPanel declarations
		this.categoryPanel = new JPanel(new FlowLayout());
		this.pointQuestionPanel = new JPanel(new GridLayout(this.questionsAndAnswers.getCategories().size(), 1));
		this.pointButtonRow = new JPanel(new GridLayout());
		this.bottomPanel = new JPanel(new BorderLayout());
		this.gamePanel = new JPanel(new BorderLayout());
		
		// Multi-Player declaration
		this.playerPoints = new JLabel("Player 1: " + 0, SwingConstants.CENTER);

		// Author Panel
		this.credits = new JLabel("Created by Jake Salzer and Hernany Torres.", SwingConstants.CENTER);
		
		this.bottomPanel.add(playerPoints, BorderLayout.CENTER);
		this.bottomPanel.add(credits, BorderLayout.SOUTH);
		
		// Creating the grid of jeopardy
		Object[][] grid = jeopardyModel.getGrid();
		this.jeopardyGrid = new JeopardyButton[grid.length][grid[0].length]; // null array
		ArrayList<String> categories = questionsAndAnswers.getCategories();
		
		// For loop that creates the grid of jeopardy buttons (JeopardyButton)
		for (int j = 0; j<grid.length; j++)
		{
			// Point button row colors
			pointButtonRow.setBackground(new Color(6,12,233));
			pointButtonRow.setForeground(Color.WHITE);
			
			// Current category JLabel 
			JLabel currentCategory = new JLabel( (String) categories.get(j) );
			
			// Makes text white
			currentCategory.setForeground(Color.WHITE);
			
			// Adds category to row
			pointButtonRow.add(currentCategory);
			
			// Add JeopardyButtons to rest of row
			for (int k = 0; k<grid[j].length; k++)
			{
//				System.out.println("(j,k): ("+j+","+k+")"); // Debug
				
				JeopardyButton button = new JeopardyButton(j, k, jeopardyStyle, grid[j][k].toString());
				jeopardyGrid[j][k] = button;
				ArrayList<Object> questionContent = jeopardyModel.getQuestionAnswerItem(j, k);
				
				button.addActionListener(new JeopardyButtonListener(jeopardyModel, this, jeopardyStyle, questionContent, button));
				
				pointButtonRow.add(button);
			}
			// Row added
			pointQuestionPanel.add(pointButtonRow);
			// Resets pointButtonRow
			pointButtonRow = new JPanel(new GridLayout());
		}
		
		// Add all subpanels to gamePanel
		gamePanel.add(categoryPanel, BorderLayout.NORTH);
		gamePanel.add(pointQuestionPanel, BorderLayout.CENTER);
		gamePanel.add(bottomPanel, BorderLayout.SOUTH);
		
		// Try and catch for setting colors and fonts in case this non-essential code bugs
		try
		{
			setColors();
			setFonts();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// JeopardyGame adds gamePanel (main game)
		this.add(gamePanel);
		
		// Implement any other final GUI stuff here
		/*
		 * 
		 * 
		 * 
		 * 
		 */
		
		this.pack();
		// Set the size of the window.
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setVisible(true);
	}
	
	// Loads slide with slide content
	public void loadSlide(JeopardySlide loadedSlide)
	{
		this.getContentPane().remove(gamePanel);
		this.currentPanel = loadedSlide;
		this.add(currentPanel, BorderLayout.CENTER);
		this.repaint();
		
		// Setting size updates the GUI for some reason
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT+1);
		this.setSize(SLIDE_WIDTH, WINDOW_HEIGHT);
	}
	
	// Loads regular screen
	public void loadRegularScreen()
	{
		this.getContentPane().removeAll();
		this.add(gamePanel, BorderLayout.CENTER);
		this.repaint();
		
		// Setting size updates the GUI for some reason
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT+1);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		playerPoints.setText("Player 1: "+jeopardyModel.getPoints()[0]);
		
//		System.out.println(Arrays.deepToString(jeopardyModel.getCheckedGrid())); // Debug
//		System.out.println(jeopardyModel.checkGameOver()); // Debug
		if(jeopardyModel.checkGameOver()/*|| true*/)
		{
			// TODO
			// Code to load if game over (all questions ran through)
			// Load popup declaring winner if multiplayer
			// Load final scores as well in popup
			// Load percent right out of total possible score
			
			double totalPointsPossible = 0;
			for (int i = 0; i<jeopardyModel.getGrid()[0].length; i++)
			{
				totalPointsPossible += Double.valueOf(jeopardyModel.getGrid()[0][i].toString()); // Sum of one row
			}
			totalPointsPossible *= jeopardyModel.getGrid().length; // Number of rows
			double percentRight = (((double) jeopardyModel.getPoints()[0])/totalPointsPossible)*100;
			
			System.out.println(totalPointsPossible);
			System.out.println(percentRight);
		}
	}
	
	// Styles for the Jeopardy Board
	public static void main (String args[])
	{
		Font fontEx1 = new Font("Arial", Font.PLAIN, 20);
		Font fontEx2 = new Font("Times New Roman", Font.PLAIN, 30);
		Color testColors[] = {Color.RED, Color.YELLOW, Color.PINK, Color.BLACK};
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		JeopardyStyle styleExample2 = new JeopardyStyle(testColors, testFonts);
		
		JeopardyStyle styleExample1 = new JeopardyStyle(new Color(6,12,233), Color.YELLOW, Color.PINK, Color.BLACK, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2);

		// Fill with the content for the Questions and Answers			
		
		//JeopardyQAndA JeopardyQAndA = new JeopardyQAndA("exampleQAndA.csv");
		JeopardyQAndA JeopardyQAndA = new JeopardyQAndA("JeopardyQAndA.csv");
		
		JeopardyModel exampleModel = new JeopardyModel(JeopardyQAndA);
		
//		System.out.println(Arrays.deepToString(exampleModel.getGrid()));
		
		JeopardyGame exampleGame = new JeopardyGame(styleExample1, exampleModel, JeopardyQAndA);
	}

	@Override
	public void setColors()
	{
		Color[] colors = this.jeopardyStyle.getStyleColors();
		this.setBackground(colors[0]);
		this.gamePanel.setBackground(colors[0]);
		this.categoryPanel.setBackground(colors[0]);
		this.pointQuestionPanel.setBackground(colors[0]); 
		this.pointButtonRow.setBackground(colors[0]);
		
		this.bottomPanel.setBackground(colors[0]);
		this.bottomPanel.setForeground(Color.WHITE);
		this.bottomPanel.setOpaque(true);
		this.playerPoints.setForeground(Color.WHITE);
		this.credits.setForeground(Color.WHITE);
	}

	@Override
	public void setFonts()
	{
		Font[] fonts = this.jeopardyStyle.getStyleFonts();
//		 System.out.println(Arrays.toString(fonts)); // Debug
		// Set fonts for each panel and item
	}
}