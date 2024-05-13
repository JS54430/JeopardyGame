import java.util.*;

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
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * Non-GUI file
 * Non-GUI implementation of jeopardy game
 */
/**
 */

public class JeopardyModel
{
	// Adjust grid lengths as necessary
	private int gridHeight; // JeopardyModel has-a grid height
	private int gridWidth; // JeopardyModel has-a grid width
	private Object[][] grid; // JeopardyModel has-a grid (2D array)
	private boolean[][] checkedGrid; // JeopardyModel has-a boolean grid (2D array)
	private ArrayList<String> categories; // JeopardyModel has-a ArrayList of strings which are categories
	private int incrementPointValue = 100; // JeopardyModel has-a increment point value
	private JeopardyQAndA questionsAndAnswers; // JeopardyModel has-a JeopardyQAndA
	private int playerCount; // JeopardyModel has-a player count
	private int[] playerScores; // JeopardyModel has-a player scores
	
	// Constructor for JeopardyModel
	public JeopardyModel(JeopardyQAndA QandA)
	{
		this.questionsAndAnswers = QandA;
		this.categories = questionsAndAnswers.getCategories();
		this.gridHeight = questionsAndAnswers.getNumberOfQuestionsPerCategory();
		this.gridWidth = categories.size();
		this.playerCount = 1;
		this.playerScores = new int[this.playerCount];

		makeGrid();
	}
	
	// Makes the grid for Jeopardy as well as the checkedGrid
	public void makeGrid()
	{
		this.grid = new Object[gridHeight][gridWidth]; // Grid for categories and point values
		this.checkedGrid = new boolean[gridHeight][gridWidth]; // Grid for checking if all the questions have been answered
		
		for(int i = 0; i < gridWidth; i++) 
		{
			for(int j = 0; j < gridHeight; j++) 
			{
				if (i == 0) 
				{
					this.grid[i][j] = categories.get(j); // Add category
					this.checkedGrid[i][j] = true; // Category row should be set to true
				}
				else 
				{
					this.grid[i][j] = i*incrementPointValue; // Add point value
					this.checkedGrid[i][j] = false; // initialize all values on checked grid to false, no values have gone through yet
				}
			}
		}
	}
	
	// Returns the normal grid
	public Object[][] getGrid()
	{
		return grid;
	}
	
	// Returns the checkedGrid
	public boolean[][] getCheckedGrid()
	{
		return checkedGrid;
	}
	
	// Sets checkedGrid button row and column to true
	public void setButtonChecked(int row, int column)
	{
		this.checkedGrid[row][column] = true;
	}
	
	// Returns the score board of the players
	public int[] getPoints()
	{
		return playerScores;
	}
	
	// Updates a player's points
	public void updatePoints(int player, int points)
	{
		// if player gets question right, it adds the points
		// from the question to the players points 
		playerScores[player-1]+=points;
		//System.out.println(playerScores[player-1]); // Debug
	}
	
	public boolean checkGameOver()
	{
		// When you go through all of the questions, the game is over
		for(int i = 1; i < gridWidth; i++) // Ignores 0th row as it is categories
		{
			for(int j = 0; j < gridHeight; j++) 
			{
				// If question is left still unchecked, return false
				if(!checkedGrid[i][j])
				{
					return false;
				}
			}
		}
		
		return true; // Otherwise return true, game is over
	}	
	
}
	
