import java.util.ArrayList;
import java.util.Hashtable;
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
 * Version/date: Version 1, 4/11/2024
 * 
 * Responsibilities of class:
 * Non-GUI file
 * Data structure file for questions and answers in jeopardy
 */
/**
 */
public class JeopardyQAndA
{
	// TODO
	
	// JeopardyQAndA has-a hashtable data structure that has a key of the row and column checked by the array being equal, 
	// and an element of an array list containing question, answer, hint, and category in that order
	
	// Use IO scanner section content in order to read from a CSV for data ease
	private Hashtable<Integer, ArrayList<String>> questionsAndAnswers;
	private int questionCount = 0;
	
	public JeopardyQAndA()
	{
		
	}
	
	public String getElement(int questionNumber)
	{
		// TODO
		return null;
	}
	
	public void addQuestion(String[] questionAnswerHint)
	{
		// TODO
	}
	
	public ArrayList<String> getCategories()
	{
		// TODO
		return null;
	}
}
	
