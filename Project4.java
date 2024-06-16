/*
 * Author:	  Sai Rohan Daram
 * Course:	  COP3503
 * Project #: 4
 * Title:	  Dietary Survey Form
 * Due Date:  5/1/2023
 * 
 * Opens up a dietary survey form which consists of multiple diet and health related questions for the
 * user. Program will then clear or submit user responses based on their selection. If user has clicked
 * submit, the program will then write the user data to a CSV file. If user has clicked clear, the
 * program will then clear all responses back to their default fields for the next set of responses.
 */

import javax.swing.JFrame;

/**
 * Program will open up a dietary survey form which consists of multiple diet and health related 
 * questions for the user. Program will then process the information entered in by the user by calling
 * upon multiple methods and then it will finally write the data to a file.
 */
public class Project4 {
	
	public static void main(String[] args) {
		
		// Creates a new CustomJFrame object
		CustomJFrame surveyFrame = new CustomJFrame();
		surveyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets up the default close method
		surveyFrame.pack(); // Makes sure to resize the window according to how many components placed
		surveyFrame.setVisible(true); // Makes sure to set the frame to be visible to the user
	}
}
