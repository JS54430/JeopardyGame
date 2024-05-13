import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
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
 * GUI file
 * Displays question when button on board is clicked
 *
 */
/**
 */
public class JeopardySlide extends JPanel implements StyleMethods
{
	private ArrayList<String> questionContent; // element from JeopardyQAndA
	private JeopardyStyle slideStyle;
	private JLabel directions;
	private JLabel questionLabel;
	private JeopardyButton submissionButton;
	private JTextField submissionField;
	private JeopardyButton hintButton;
	private JeopardyGame jeopardyGame;
	private JeopardyModel jeopardyModel;
	private int points;

	// If hint button is pressed, cue JeopardyAnswerPopup to appear
	
	public JeopardySlide (JeopardyStyle style, ArrayList<String> questionContent, JeopardyGame jeopardyGame, JeopardyModel jeopardyModel, int points)
	{
		// GUI stuff
		this.slideStyle = style;
		this.questionContent = questionContent;
		this.setLayout(new BorderLayout());
		
		// Top
		this.directions = new JLabel("Submit the answer to the following question: ", SwingConstants.CENTER);
		this.questionLabel = new JLabel(questionContent.get(0), SwingConstants.CENTER);
		
		// Center
		this.submissionField = new JTextField();
		this.submissionButton = new JeopardyButton(slideStyle, "Submit Answer");
		this.jeopardyGame = jeopardyGame;
		this.jeopardyModel = jeopardyModel;
		this.points = points;
		submissionButton.addActionListener(new SlideButtonListener(slideStyle, submissionButton, "Answer", this.questionContent, submissionField, this.jeopardyGame, this.jeopardyModel, this.points));
		
		// Bottom
		this.hintButton = new JeopardyButton(slideStyle, "Hint");
		hintButton.addActionListener(new SlideButtonListener(slideStyle, hintButton, "Hint", this.questionContent));
		
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
		
		JPanel top = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new GridLayout());
		JPanel bottom = new JPanel();
		
		top.add(directions, BorderLayout.NORTH);
		top.add(questionLabel, BorderLayout.SOUTH);
		center.add(submissionField);
		center.add(submissionButton);
		bottom.add(hintButton);
		
		this.add(top, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	@Override
	public void setColors()
	{
		Color[] colors = this.slideStyle.getStyleColors();
		this.setBackground(colors[0]);
		this.submissionButton.setBackground(colors[1]);
		this.hintButton.setBackground(colors[3]);		
	}

	@Override
	public void setFonts()
	{
		Font[] fonts = this.slideStyle.getStyleFonts();
		this.directions.setFont(fonts[0]);
		this.questionLabel.setFont(fonts[0]);
		this.submissionButton.setFont(fonts[2]);
		this.hintButton.setFont(fonts[3]);

	}
}