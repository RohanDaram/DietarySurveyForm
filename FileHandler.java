import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The FileHandler class has the method and constructor that are responsible for writing the survey 
 * data to the survey results file. The class will also append to the results file as long as the 
 * survey form has not been close. Once a new survey form is opened, the data in the survey results
 * file will be overridden with the new user data from the form.
 */
public class FileHandler {
	
	// Variable declaration
	private String surveyFile;
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	/**
	 * Public constructor used to create the object. This constructor will write the survey results 
	 * header to the file.
	 */
	public FileHandler() {
		
		// Stores the name of the output file in the respective variable
		this.surveyFile = "survey_results.csv";
		
		// Try block to catch any exceptions that may occur
		try {
			this.printWriter = new PrintWriter(surveyFile);
		// All exceptions that are handled
		} catch (FileNotFoundException e) {
			System.out.println("*File does not exist or could not be created.*");
		}
		
		// Writes the header to the output file
		this.printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		
		this.printWriter.close(); // Closes the output file so that there are no issues
	}
	
	/**
	 * Writes any thing passed to the method to the survey data file along with the current date and 
	 * time in a certain format, the file will be appended to rather than overwritten.
	 * @param surveyData The String containing the data that needs to be written to the file
	 */
	public void writeResults(String surveyData) {
		
		// Creates new Date object and formats the date into the required form
		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String currentFormatted = sdf.format(current);
		
		// Try block to catch any exceptions that may occur
		try {
			this.fileOutput = new FileWriter(this.surveyFile, true);
			this.printWriter = new PrintWriter(this.fileOutput);
			this.printWriter.println(currentFormatted + surveyData);
			
		// All exceptions that are handled
		} catch (IOException e) {
			System.out.println("File could not be written or appended to");
		}
		
		this.printWriter.close(); // Closes the output so that there are no issues
	}	
}
