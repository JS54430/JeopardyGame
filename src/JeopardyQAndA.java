import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

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
 * Creating an ArrayList with multiple object types in Java. (2021, October 22). GeeksforGeeks. https://www.geeksforgeeks.org/creating-an-arraylist-with-multiple-object-types-in-java/
 * 
 * Hashtable put() method in Java. (2018, June 28). GeeksforGeeks. https://www.geeksforgeeks.org/hashtable-put-method-in-java/
 *  
 * Version/date: Version 1, 5/13/2024
 * 
 * Responsibilities of class:
 * Non-GUI file
 * Data structure file for questions and answers in jeopardy
 */
/**
 */

public class JeopardyQAndA
{
	// JeopardyQAndA has-a hashtable data structure that has a key of the row and column checked by the array being equal, 
	// and an element of an array list containing question, answer, hint, and category in that order
	
	// Use IO scanner section content in order to read from a CSV for data ease
	private Hashtable<Integer, ArrayList<Object>> questionsAndAnswers; // JeopardyQAndA has-a hashtable with integer keys and arraylist object elements corresponding to categories, questions, answers, and hints
	private ArrayList<String> categories; // JeopardyQAndA has-a array list of strings of categories
	
	// Constructor of JeopardyQAndA
	public JeopardyQAndA(String fileName)
	{
		// setup scanner
		Scanner scan = null;
		int count = 0;
		int questionCount = 0;
		String categoryIndicator = "C-";
		this.questionsAndAnswers = new Hashtable<Integer, ArrayList<Object>>();
		this.categories = new ArrayList<String>();
		
		try 
		{
			File myFile = new File(fileName);	
			scan = new Scanner(myFile); //Create a Scanner object using the File object
			ArrayList<Object> categoryQAndA = null;
			ArrayList<String> questionAnswerHintArray = null; // Used for nested ArrayLists
			
			// Obtain content from the file as long as there is content to be obtained 
			while(scan.hasNextLine()) 
			{ 
				 String data = scan.nextLine(); // scan next, variable saved as 'data'
				 
//				 System.out.println(data); // debug
				 
				 // If file reads with the indicator in scan, then
				 if (data.startsWith(categoryIndicator))
				 {
					 // If categoryQAndA has already been through this, add it to the list
					 if (categoryQAndA != null)
					 {
						questionsAndAnswers.put(count, categoryQAndA);
						count++; // increase count for keeping track of categories
					 }
					 categoryQAndA = new ArrayList<Object>(); // Reset categoryQAndA
					 categoryQAndA.add(data.substring(2)); // Adds new category
					 categories.add(data.substring(2));
					 
					 questionCount = 0;
					 questionAnswerHintArray = new ArrayList<String>(); // Reset questionAnswerHintArray
				 }
				 else
				 {
					questionCount++;
					questionAnswerHintArray.add(data);
					
					if (questionCount == 3)
					{
						questionCount = 0;
						categoryQAndA.add(questionAnswerHintArray); // Adds question, answer, hint 
						questionAnswerHintArray = new ArrayList<String>();
					}
					
				 }
			}
			
			questionsAndAnswers.put(count, categoryQAndA); // Adds last category
			count++;
		}
		
		catch (FileNotFoundException e) 
		{  
		    // This block of code runs if the file is not found e.printStackTrace(); 
			e.printStackTrace(); 
		} 
		
		finally 
		{
		   if(scan!=null)
		    {
		       scan.close();
		    } 
		}
		
		
	}
	
	// Returns questions and answers for category number
	public ArrayList<Object> getCategoryQuestionsAndAnswers(int categoryNumber)
	{
		return questionsAndAnswers.get(categoryNumber);
	}
	
	// returns categories
	public ArrayList<String> getCategories()
	{
		return categories;
	}
	
	// returns hashtable with integer keys and arraylist object elements corresponding to categories, questions, answers, and hints
	public Hashtable<Integer, ArrayList<Object>> getQAndA()
	{
		return questionsAndAnswers;
	}

	// returns number of questions per category
	public int getNumberOfQuestionsPerCategory()
	{
		return getCategoryQuestionsAndAnswers(1).size()-1;
	}
	
	// TODO Make this function unnecessary by changing model
	// returns the array list of question content within questionsAndAnswers
	public ArrayList<String> getQuestionContent(int row, int column)
	{
//		System.out.println(questionsAndAnswers.get(row).get(column));
//		System.out.println(questionsAndAnswers.get(row).get(column+1));
		return (ArrayList<String>) questionsAndAnswers.get(row).get(column);
	}
	
}
	