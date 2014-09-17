/*
Michael Helms


What up.  This is just a super basic program to calculate the millisecond value of musical rhythms based off of the BPM

Meh, it works
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

//start public GUI class BPMWindow
public class BPMWindow extends JFrame {
	// Size
	private final int WINDOW_WIDTH = 200;
	private final int WINDOW_HEIGHT = 250;

	// Panels and Container
	private JPanel panel;

	private Container contentPane;

	// Labels
	private JLabel labelBPM; // label for the BPM
	private JLabel labelQuarterNote; // label for the 1/4 ms value
	private JLabel labelEighthNote; // label for the 1/8 ms value
	private JLabel labelSixteenthNote; // label for the 1/16 ms value
	private JLabel labelThirtySecondNote; // label for the 1/16 ms value

	// Text Fields
	private JTextField textBPM; // text field that holds the BPM
	private JTextField textQuarterNote; // text field that holds the 1/4 ms
										// value
	private JTextField textEighthNote; // text field that holds the 1/8 ms value
	private JTextField textSixteenthNote; // text field that holds the 1/16 ms
											// value
	private JTextField textThirstySecondNote; // text field that holds the 1/32
												// ms value

	// Buttons
	private JButton calculate; // creates a calculate button for the user to
								// click

	// Constructor
	public BPMWindow() {
		super("BPM2MS");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sets the name of the labels
		labelBPM = new JLabel("       BPM:              ");
		labelQuarterNote = new JLabel("1/4 Note MS:       ");
		labelEighthNote = new JLabel("1/8 Note MS:       ");
		labelSixteenthNote = new JLabel("1/16th Note MS: ");
		labelThirtySecondNote = new JLabel("1/32th Note MS: ");

		// sets the size of the text fields
		textBPM = new JTextField(4);
		textQuarterNote = new JTextField(4);
		textQuarterNote.setEditable(false);
		textEighthNote = new JTextField(4);
		textEighthNote.setEditable(false);
		textSixteenthNote = new JTextField(4);
		textSixteenthNote.setEditable(false);
		textThirstySecondNote = new JTextField(4);
		textThirstySecondNote.setEditable(false);

		calculate = new JButton("Calculate");
		calculate.addActionListener(new calculateListener()); // creates a
																// listener for
																// the calculate
																// button

		panel = new JPanel();

		panel.add(labelBPM);
		panel.add(textBPM);

		panel.add(labelQuarterNote);
		panel.add(textQuarterNote);

		panel.add(labelEighthNote);
		panel.add(textEighthNote);

		panel.add(labelSixteenthNote);
		panel.add(textSixteenthNote);

		panel.add(labelThirtySecondNote);
		panel.add(textThirstySecondNote);

		panel.add(calculate);

		contentPane = getContentPane();
		contentPane.add(panel);

		setVisible(true);
		
		// go away snazz

	}

	// Event Handler
	private class calculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DecimalFormat df = new DecimalFormat("#"); // formats the decimal
															// output
			double BPM = Double.parseDouble(textBPM.getText()); // gets the
																// price user
																// enters in
																// text field

			double Quarter_Note = 0;
			double Eighth_Note = 0;
			double Sixteenth_Note = 0;
			double ThirtySecond_Note = 0;

			Quarter_Note = (60000 / BPM);
			Eighth_Note = (Quarter_Note / 2);
			Sixteenth_Note = (Eighth_Note / 2);
			ThirtySecond_Note = (Sixteenth_Note / 2);

			textQuarterNote.setText(df.format(Quarter_Note) + " ");
			textEighthNote.setText(df.format(Eighth_Note) + " ");
			textSixteenthNote.setText(df.format(Sixteenth_Note) + " ");
			textThirstySecondNote.setText(df.format(ThirtySecond_Note) + " ");

		}
	}
}


