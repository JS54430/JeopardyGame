import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

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
 * Hashtable toString() method in Java. (2023, February 20). GeeksforGeeks. https://www.geeksforgeeks.org/hashtable-tostring-method-in-java/
 *  
 * Version/date: Version 1, 5/11/2024
 * 
 * Responsibilities of class:
 * Testing file
 */

class ZJeopardyTest
{
	@Test
	void testJeopardyStyle()
	{
		Font fontEx1 = new Font("Arial", Font.PLAIN, 20);
		Font fontEx2 = new Font("Times New Roman", Font.PLAIN, 30);

		Color testColors[] = {Color.RED, Color.YELLOW, Color.PINK, Color.BLACK};
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		
		// Parameter list constructor
		JeopardyStyle styleExample1 = new JeopardyStyle(Color.RED, Color.YELLOW, Color.PINK, Color.BLACK, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2);
		
		// Array constructor
		JeopardyStyle styleExample2 = new JeopardyStyle(testColors, testFonts);
		
		// Given the same parameters, are the styles' values equal?
		Color colorValue1 = styleExample1.getStyleColors()[2];
		Color colorValue2 = styleExample2.getStyleColors()[2];
		
		Font fontValue1 = styleExample1.getStyleFonts()[3];
		Font fontValue2 = styleExample2.getStyleFonts()[3];
		
		assertEquals(colorValue1, colorValue2);
		assertEquals(fontValue1, fontValue2);
	}
	
	@Test
	void testJeopardyModel()
	{
		JeopardyModel exampleModel = new JeopardyModel(new JeopardyQAndA("exampleQAndA.csv"));
		Object[][] grid = exampleModel.getGrid();
		assertEquals(Arrays.deepToString(grid), "[[Category1, Category2, Category3, Category4, Category5, Category6], [100, 100, 100, 100, 100, 100], [200, 200, 200, 200, 200, 200], [300, 300, 300, 300, 300, 300], [400, 400, 400, 400, 400, 400], [500, 500, 500, 500, 500, 500]]");
	}
	
//	@Test
//	void testJeopardyGame()
//	{
//		
//	}
	
	@Test
	void testJeopardyGUI()
	{
		Font fontEx1 = new Font("Arial", Font.PLAIN, 20);
		Font fontEx2 = new Font("Times New Roman", Font.PLAIN, 30);
		Color testColors[] = {Color.RED, Color.YELLOW, Color.PINK, Color.BLACK};
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		JeopardyStyle styleExample2 = new JeopardyStyle(testColors, testFonts);
		
		// JeopardySlide
		
		// JeopardyAnswerPopup
		JeopardyAnswerPopup popupExample = new JeopardyAnswerPopup(styleExample2, false, "The Correct Answer");
	}
	
	@Test
	void testJeopardyQAndA()
	{
		JeopardyQAndA myExampleAnswersQuestions1 = new JeopardyQAndA("exampleQAndA.csv");
	
		/*
		String consoleQAndA1 = myExampleAnswersQuestions1.getQAndA().toString();
		
		System.out.println(consoleQAndA1);
		
		System.out.println(myExampleAnswersQuestions1.getCategoryQuestionsAndAnswers(1));
		
		System.out.println(myExampleAnswersQuestions1.getQuestionContent(0,0));
		*/
		
		assertEquals(myExampleAnswersQuestions1.getQuestionContent(0,0).toString(), "[1Q1, 1A1, 1H1]");
	}
}