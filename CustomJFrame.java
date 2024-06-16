import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * The CustomJFrame class extends JFrame and contains the instance variables as well as methods 
 * used to construct a CustomJFrame object.
 */
public class CustomJFrame extends JFrame {
	// Variable declaration
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;
	private JSpinner waterIntakeSpinner;
	private JSlider mealSlider;
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	private JComboBox walkComboBox;
	private String[] walkOptions;
	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton;
	private JButton submitButton;
	private FileHandler fileHandler;
	
	/**
	 * Public constructor used to create the object, initialize all the class variable components, as
	 * well as configure them properly, and then add the components using a layout manager.
	 */
	public CustomJFrame() {
		
		// Creates new FileHandler object
		this.fileHandler = new FileHandler();
		
		// Creates new labels
		this.setTitle("Dietary Survey");
		this.headingLabel = new JLabel("Personal Information");
		this.firstNameLabel = new JLabel("First Name:");
		this.lastNameLabel = new JLabel("Last Name:");
		this.phoneNumberLabel = new JLabel("Phone Number:");
		this.emailLabel = new JLabel("Email:");
		
		// Creates new labels
		this.dietaryLabel = new JLabel("Dietary Questions");
		this.genderLabel = new JLabel("Sex:");
		this.waterLabel = new JLabel("How many cups of water on average do you drink per day?");
		this.mealsLabel = new JLabel("How many meals on average do you eat a day?");
		this.checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
		this.walkLabel = new JLabel("On average how many miles do you walk in a day?");
		this.weightLabel = new JLabel("How much do you weigh?");
		
		// Creates new text fields and set their number of columns to 15
		this.firstNameTextField = new JTextField(15);
		this.lastNameTextField = new JTextField(15);
		this.phoneNumberTextField = new JTextField(15);
		this.emailTextField = new JTextField(15);
		
		// Creates new radio buttons and adds them to the radio button group
		this.maleRadioButton = new JRadioButton("Male");
		this.maleRadioButton.setSelected(false);
		this.femaleRadioButton = new JRadioButton("Female");
		this.femaleRadioButton.setSelected(false);
		this.preferRadioButton = new JRadioButton("Prefer not to say");
		this.preferRadioButton.setSelected(false);
		this.radioButtonGroup = new ButtonGroup();
		this.radioButtonGroup.add(this.maleRadioButton);
		this.radioButtonGroup.add(this.femaleRadioButton);
		this.radioButtonGroup.add(this.preferRadioButton);
		
		// Adds the radio buttons to a Box object so that they can be displayed vertically
		Box genderVerticalBox = Box.createVerticalBox();
		genderVerticalBox.add(this.maleRadioButton);
		genderVerticalBox.add(this.femaleRadioButton);
		genderVerticalBox.add(this.preferRadioButton);
		
		// Creates new JSpinner and sets the default, minimum, maximum, and increment values for water
		this.waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
		this.mealSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 10, 3);
		this.mealSlider.setMajorTickSpacing(1);
		this.mealSlider.setPaintTicks(true); // Makes the ticks visible
		this.mealSlider.setPaintLabels(true); // Makes the labels visible
		this.mealSlider.setSnapToTicks(true); // Makes it so the slider snaps to each number tick
		
		// Creates wheat check box
		this.wheatCheckBox = new JCheckBox("Wheat");
		this.wheatCheckBox.setSelected(false);
		
		// Creates sugar check box
		this.sugarCheckBox = new JCheckBox("Sugar");
		this.sugarCheckBox.setSelected(false);
		
		// Creates dairy check box
		this.dairyCheckBox = new JCheckBox("Dairy");
		this.dairyCheckBox.setSelected(false);
		
		// Adds the check boxes to a new JPanel object
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.add(dairyCheckBox);
		checkBoxPanel.add(wheatCheckBox);
		checkBoxPanel.add(sugarCheckBox);
		
		// Creates the options for the walking distance combo box in the form of a String array
		this.walkOptions = new String[4];
		this.walkOptions[0] = "Less than 1 Mile";
		this.walkOptions[1] = "More than 1 mile but less than 2 miles";
		this.walkOptions[2] = "More than 2 miles but less than 3 miles";
		this.walkOptions[3] = "More than 3 miles";
		this.walkComboBox = new JComboBox<String>(this.walkOptions);
		
		// Creates a text field that limits user typed data to only numbers
		NumberFormat numberFormatter = NumberFormat.getNumberInstance();
		this.weightFormattedTextField = new JFormattedTextField(numberFormatter);
		this.weightFormattedTextField.setColumns(15);
		
		// Creates the Submit and Clear buttons
		this.submitButton = new JButton("Submit");
		this.clearButton = new JButton("Clear");
		this.clearButton.setBackground(Color.YELLOW); // Sets Clear button to yellow
		this.submitButton.setBackground(Color.GREEN); // Sets Submit button to green
		
		// Adds action listeners to each of the buttons as well as adds the name for the button
		InnerActionListener actionListener = new InnerActionListener();
		this.submitButton.addActionListener(actionListener);
		this.submitButton.setName("Submit");
		this.clearButton.addActionListener(actionListener);
		this.clearButton.setName("Clear");
		
		// Lets the program know that the GridBagLayout manager will be used for this custom frame
		this.setLayout(new GridBagLayout());
		// Creates GridBagConstraints object
		GridBagConstraints layoutManager = new GridBagConstraints();
	
		// Sets the layoutManager axis to 0,0
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		// Sets the amount of spacing between the different components
		layoutManager.insets = new Insets(5, 5, 10, 10); 
		
		// Adds heading label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		this.add(this.headingLabel, layoutManager);
		
		// Adds first name label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		this.add (this.firstNameLabel, layoutManager);
		
		// Adds last name label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 2;
		this.add (this.lastNameLabel, layoutManager);
		
		// Adds phone number label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 3;
		this.add(this.phoneNumberLabel, layoutManager);
		
		// Adds email label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 4;
		this.add(this.emailLabel, layoutManager);
		
		// Adds gender label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 5;
		this.add(this.genderLabel, layoutManager);
		
		// Adds diet label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 6;
		this.add(this.dietaryLabel, layoutManager);
		
		// Adds water label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 7;
		this.add(this.waterLabel, layoutManager);
		
		// Adds water amount spinner to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 8;
		this.add(this.waterIntakeSpinner, layoutManager);
		
		// Adds number of meals label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 9;
		this.add(this.mealsLabel, layoutManager);
		
		// Adds the meal slider to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 10;
		this.add(this.mealSlider, layoutManager);
		
		// Adds check box label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 11;
		this.add(this.checkBoxLabel, layoutManager);
		
		// Adds the meals check box to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 12;
		this.add(checkBoxPanel, layoutManager);
		
		// Adds the walking question label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 13;
		this.add(this.walkLabel, layoutManager);
		
		// Adds the walking distance combo box to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 14;
		this.add(this.walkComboBox, layoutManager);
		
		// Adds weight question label to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 15;
		this.add(this.weightLabel, layoutManager);
		
		// Adds the weight text field that only accepts numbers to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 16;
		this.add(this.weightFormattedTextField, layoutManager);
		
		// Adds the form clear button to the corresponding coordinates
		layoutManager.gridx = 0;
		layoutManager.gridy = 17;
		this.add(this.clearButton, layoutManager);
		
		// Adds the form submit to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 17;
		this.add(this.submitButton, layoutManager);
		
		// Adds the first name text field to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 1;
		this.add(this.firstNameTextField, layoutManager);
		
		// Adds the last name text field to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 2;
		this.add(this.lastNameTextField, layoutManager);
		
		// Adds the phone number text field to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 3;
		this.add(this.phoneNumberTextField, layoutManager);
		
		// Adds the email text field to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 4;
		this.add(this.emailTextField, layoutManager);
		
		// Adds the box component containing the gender radio buttons to the corresponding coordinates
		layoutManager.gridx = 1;
		layoutManager.gridy = 5;
		this.add(genderVerticalBox, layoutManager);		
	}
	
	/**
	 * The InnerActionListener class implements the ActionListener interface and is an inner class of 
	 * the CustomJFrame object.
	 */
	class InnerActionListener implements ActionListener{
		
		/**
		 * The method that is invoked whenever an action from the survey form occurs.
		 * @param ActionEvent The event that has been done by the user.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton button = (JButton) e.getSource(); // Gets the source of the action
			
			// Gets the name of the button and stores it in the name variable
			String name = button.getName();
			
			// Checks if the name of the button is Submit
			if(name.equals("Submit")) {
				// Variable declaration
				String firstName = firstNameTextField.getText(); // Stores first name from field
				String lastName = lastNameTextField.getText(); // Stores last name from field
				String phoneNumber = phoneNumberTextField.getText(); // Stores phone number from field
				String email = emailTextField.getText(); // Stores email from the field
				String gender = "";
				String dairy = "";
				String wheat = "";
				String sugar = "";
				String weight = "";
		
				weight = weightFormattedTextField.getText(); // Stores the weight that was entered
				
				// For radio buttons
				if(weight.equals("")) {
					weight = "null"; // If weight was not entered, null will be stored in weight
				}
				
				if(maleRadioButton.isSelected()) {
					gender = "Male"; // If male radio button is selected Male will be stored in gender
				}
				else if(femaleRadioButton.isSelected()) {
					gender = "Female"; // If female radio button is selected female will be stored
				}
				else if(preferRadioButton.isSelected()){
					gender = "Prefer not to say"; // If prefer not to say button is selected
				}
				else {
					gender = null; // If no radio button is selected gender will be null
				}
				
				// For check box
				if(dairyCheckBox.isSelected()) {
					dairy = "true"; // If dairy check box is selected true will be stored in dairy
				}
				else {
					dairy = "false"; // If it is not selected false will be stored in dairy
				}
				if(wheatCheckBox.isSelected()) {
					wheat = "true"; // If wheat check box is selected true will be stored in wheat
				}
				else {
					wheat = "false"; // If it is not selected false will be stored in wheat
				}
				if(sugarCheckBox.isSelected()) {
					sugar = "true"; // If sugar check box is selected true will be stored in sugar
				}
				else {
					sugar = "false"; // If it is not selected false will be stored in sugar
				}
				
				// Stores number of water cups drunk by the user on average in waterCuper variable
				int waterCups = (int) waterIntakeSpinner.getValue();
				// Stores number of meals eaten by the user on average in numMeals variable
				int numMeals = (int) mealSlider.getValue();
				
				// Stores the user combo box choice in the walkDistance variable
				String walkDistance = (String) walkComboBox.getSelectedItem();
				
				// Writes all the data to the output file while also making sure it is comma separated
				fileHandler.writeResults("," + firstName + "," + lastName + "," + phoneNumber + "," + email + "," + gender + "," + waterCups + "," + numMeals + "," + wheat + "," + sugar + "," + dairy + "," + walkDistance + "," + weight);
						
				clearForm(); // Calls method to clear the form and go back to its default values
			}
			
			else {
				// If clear is pressed calls method to clear the form and go to its default values
				clearForm();
			}
		}
		
		/**
		 * Clears all the fields in the survey back to the default values for the next user.
		 */
		private void clearForm() {
		
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			weightFormattedTextField.setText("");
			radioButtonGroup.clearSelection();
			dairyCheckBox.setSelected(false);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
		}
	}
}
