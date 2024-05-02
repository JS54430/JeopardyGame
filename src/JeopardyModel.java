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
 * Version/date: Version 1, 5/1/2024
 * 
 * Responsibilities of class:
 * Non-GUI file
 * Non-GUI implementation of jeopardy game
 */
/**
 */
public class JeopardyModel
{
	// TODO
	// Adjust grid lengths as necessary
	private int gridHeight;
	private int gridWidth;
	private Object[][] grid;
	private ArrayList<String> categories;
	private int incrementPointValue = 100;
	private JeopardyQAndA questionsAndAnswers;
	
	public JeopardyModel(JeopardyQAndA QandA)
	{
		this.questionsAndAnswers = QandA;
		this.categories = questionsAndAnswers.getCategories();
		this.gridHeight = questionsAndAnswers.getNumberOfQuestionsPerCategory();
		this.gridWidth = categories.size();

		makeGrid();
	}
	
	public void makeGrid()
	{
		this.grid = new Object[gridHeight][gridWidth]; 
		
		for(int i = 0; i < gridWidth; i++) 
		{
			for(int j = 0; j < gridHeight; j++) 
			{
				if (i == 0) 
				{
					this.grid[i][j] = categories.get(j);
				}
				else 
				{
					this.grid[i][j] = i*incrementPointValue;
				}
			}
		}
	}
	
	public Object[][] getGrid()
	{
		return this.grid;
	}
	
	public void updatePoints(int player, int points)
	{
		// TODO

		// if player gets question right, it adds the points
		// from the question to the players points 
	}
	
	public void gameOver()
	{
		// TODO
		
		// when you go through all of the questions, the game is over
	}
}
	
