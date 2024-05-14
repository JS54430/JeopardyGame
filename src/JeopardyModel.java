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
	private ArrayList<Object> questionAnswerGrid; // JeopardyModel has-a question answer grid
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
		
		/*
		this.gridWidth = categories.size();
		//this.gridHeight = questionsAndAnswers.getCategoryQuestionsAndAnswers(1).size();
		this.gridHeight = questionsAndAnswers.getNumberOfQuestionsPerCategory();
		*/
		this.gridWidth = questionsAndAnswers.getNumberOfQuestionsPerCategory();
		//this.gridHeight = questionsAndAnswers.getCategoryQuestionsAndAnswers(1).size();
		this.gridHeight = categories.size();
		
		this.playerCount = 1;
		this.playerScores = new int[this.playerCount];
		
//		System.out.println("Model width: "+gridWidth);
//		System.out.println("Model height: "+gridHeight);
//		System.out.println(questionsAndAnswers.getCategoryQuestionsAndAnswers(1).toString());
//		System.out.println(questionsAndAnswers.getQAndA().toString());

		makeGrid();
		
//		System.out.println(Arrays.deepToString(grid)); // debug
//		System.out.println(getQuestionAnswerGrid().toString()); // debug
//		System.out.println(getQuestionAnswerRow(0).toString()); // debug
//		System.out.println(getQuestionAnswerItem(0,0)); // debug
	}
	 
	// Makes the grid for JeopardyGame, checkedGrid, and questionAnswerGrid
	public void makeGrid()
	{
		this.grid = new Object[gridHeight][gridWidth]; // Grid for categories and point values
		this.checkedGrid = new boolean[gridHeight][gridWidth]; // Grid for checking if all the questions have been answered
		this.questionAnswerGrid = new ArrayList<Object>(); // Grid for storing all of the answers for JeopardyGame
		
//		System.out.println(Arrays.deepToString(grid));
		
//		for(int j = 0; j < gridWidth; j++) 
//		{
//			this.grid[0][j] = categories.get(j); // Add category
//		}

		for(int i = 0; i < gridHeight; i++) 
		{
			ArrayList<Object> row = new ArrayList<Object>();
			for(int j = 0; j < gridWidth; j++) 
			{
//				System.out.println("(i,j): ("+i+","+j+")"); // Debug
				
				this.grid[i][j] = (j+1)*incrementPointValue; // Add point value
				this.checkedGrid[i][j] = false; // initialize all values on checked grid to false, no values have gone through yet
				
//				System.out.println(questionsAndAnswers.getQuestionContent(i, j+1)); // Debug
				
				row.add(questionsAndAnswers.getQuestionContent(i, j+1));
			}
			questionAnswerGrid.add(row);
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
	
	// Returns the questionAnswerGrid
	public ArrayList<Object> getQuestionAnswerGrid()
	{
		return questionAnswerGrid;
	}
	
	// Returns the questionAnswerGrid row specified
	public ArrayList<Object> getQuestionAnswerRow(int row)
	{
		return (ArrayList<Object>) questionAnswerGrid.get(row);
	}
	
	// Returns the questionAnswerGrid ArrayList<Object> at row and column specified (the question's content)
	public ArrayList<Object> getQuestionAnswerItem(int row, int column)
	{
		return (ArrayList<Object>) getQuestionAnswerRow(row).get(column);
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
	
