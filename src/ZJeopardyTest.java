import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

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
 * Version/date: Version 1, 4/10/2024
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
		Font testFonts[] = {fontEx1, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2};
		
		// Parameter list constructor
		JeopardyStyle styleExample1 = new JeopardyStyle(Color.RED, Color.YELLOW, Color.PINK, Color.BLACK, fontEx1, fontEx1, fontEx1, fontEx1, fontEx2, fontEx2);
		
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
		
	}
	
	@Test
	void testJeopardyGame()
	{
		
	}
	
	@Test
	void testJeopardyQAndA()
	{
		
	}
}