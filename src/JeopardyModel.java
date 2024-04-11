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
 * Non-GUI file
 * Non-GUI implementation of jeopardy game
 */
/**
 */
public class JeopardyModel
{
	// TODO
	// Adjust grid lengths as necessary
	private int gridHeight = 6;
	private int gridWidth = 5;
	private int[][] grid;
	private String[] categories;
	private int incrementPointValue = 100;
	private JeopardyQAndA questionsAndAnswers;
	
	public JeopardyModel(JeopardyQAndA questionsAndAnswers)
	{
		this.questionsAndAnswers = questionsAndAnswers;
		categories = questionsAndAnswers.getCategories();

		makeGrid();
	}
	
	public void makeGrid()
	{
		//grid = new int[gridHeight][gridWidth]; 
		// TODO
		/*
		for( int i = 0; i < gridHeight; i++) {
			for( int j = 0; j < gridWidth; j++) {
				if (i == 0) {
					grid [i][j] = categories[j];
				}
				else {
					// TODO
				}
			}
		}
		*/


	}
	
	public void updatePoints()
	{
		// TODO

		// if player gets question right, it adds the points
		// from the question to the players points 


	}
	
	public void gameOver()
	{
		// when you go through all of the questions, the game is over
	}
}
	
