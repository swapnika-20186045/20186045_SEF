package calculator;

import java.util.Scanner;

/**
 * <p>
 * Title: CalculatorValue Class.
 * </p>
 * 
 * <p>
 * Description: A component of a JavaFX demonstration application that performs
 * computations
 * </p>
 * 
 * <p>
 * Copyright: Lynn Robert Carter © 2019
 * </p>
 * 
 * @author Lynn Robert Carter
 * @author Swapnika Vakacharla
 * 
 * @version 4.01 2019-02-08 Minor documentation update
 * @version 4.00 2017-10-18 Long integer implementation of the CalculatorValue
 *          class
 * 
 */
public class CalculatorValue {

	/**********************************************************************************************
	 * 
	 * Attributes
	 * 
	 **********************************************************************************************/

	// These are the major values that define a calculator value
	long measuredValue = 0;
	String errorMessage = "";

	/**********************************************************************************************
	 * 
	 * Constructors
	 * 
	 **********************************************************************************************/

	/*****
	 * This is the default constructor
	 */
	public CalculatorValue() {
	}

	/*****
	 * This constructor creates a calculator value based on a long integer. For
	 * future calculators, it is best to avoid using this constructor.
	 */
	public CalculatorValue(long v) {
		measuredValue = v;
	}

	/*****
	 * This copy constructor creates a duplicate of an already existing calculator
	 * value
	 */
	public CalculatorValue(CalculatorValue v) {
		measuredValue = v.measuredValue;
		errorMessage = v.errorMessage;
	}

	/*****
	 * This constructor creates a calculator value from a string... Due to the
	 * nature of the input, there is a high probability that the input has errors,
	 * so the routine returns the value with the error message value set to empty or
	 * the string of an error message.
	 */
	public CalculatorValue(String s) {
		measuredValue = 0;
		if (s.length() == 0) { // If there is nothing there,
			errorMessage = "***Error*** Input is empty"; // signal an error
			return;
		}
		// If the first character is a plus sign, ignore it.
		int start = 0; // Start at character position zero
		boolean negative = false; // Assume the value is not negative
		if (s.charAt(start) == '+') // See if the first character is '+'
			start++; // If so, skip it and ignore it

		// If the first character is a minus sign, skip over it, but remember it
		else if (s.charAt(start) == '-') { // See if the first character is '-'
			start++; // if so, skip it
			negative = true; // but do not ignore it
		}

		// See if the user-entered string can be converted into an integer value
		Scanner tempScanner = new Scanner(s.substring(start));// Create scanner for the digits
		if (!tempScanner.hasNextLong()) { // See if the next token is a valid
			errorMessage = "***Error*** Invalid value"; // integer value. If not, signal
			tempScanner.close(); // return a zero
			return;
		}

		// Convert the user-entered string to a integer value and see if something else
		// is following it
		measuredValue = tempScanner.nextLong(); // Convert the value and check to see
		if (tempScanner.hasNext()) { // that there is nothing else is
			errorMessage = "***Error*** Excess data"; // following the value. If so, it
			tempScanner.close(); // is an error. Therefore we must
			measuredValue = 0; // return a zero value.
			return;
		}
		tempScanner.close();
		errorMessage = "";
		if (negative) // Return the proper value based
			measuredValue = -measuredValue; // on the state of the flag that
	}

	/**********************************************************************************************
	 * 
	 * Getters and Setters
	 * 
	 **********************************************************************************************/

	/*****
	 * This is the start of the getters and setters
	 * 
	 * Get the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/*****
	 * Set the current value of a calculator value to a specific long integer
	 */
	public void setValue(long v) {
		measuredValue = v;
	}

	/*****
	 * Set the current value of a calculator error message to a specific string
	 */
	public void setErrorMessage(String m) {
		errorMessage = m;
	}

	/*****
	 * Set the current value of a calculator value to the value of another (copy)
	 */
	public void setValue(CalculatorValue v) {
		measuredValue = v.measuredValue;
		errorMessage = v.errorMessage;
	}

	/**********************************************************************************************
	 * 
	 * The toString() Method
	 * 
	 **********************************************************************************************/

	/*****
	 * This is the default toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be
	 * updated
	 */
	public String toString() {
		return measuredValue + "";
	}

	/*****
	 * This is the debug toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be
	 * updated
	 */
	public String debugToString() {
		return "measuredValue = " + measuredValue + "\nerrorMessage = " + errorMessage + "\n";
	}

	/**********************************************************************************************
	 * 
	 * The computation methods
	 * 
	 **********************************************************************************************/

	/**********************************************************************************************
	 * The following methods implement computation on the calculator values. These
	 * routines assume that the caller has verified that things are okay for the
	 * operation to take place. These methods understand the technical details of
	 * the values and their reputations, hiding those details from the business
	 * +logic and user interface modules.
	 * 
	 * Since this is addition and we do not yet support units, we don't recognize
	 * any errors.
	 */
	public void add(CalculatorValue v) {
		measuredValue += v.measuredValue;
		errorMessage = "";
	}

	/**********************************************************************************************
	 * The following methods implement computation on the calculator values. These
	 * routines assume that the caller has verified that things are okay for the
	 * operation to take place. These methods understand the technical details of
	 * the values and their reputations, hiding those details from the business
	 * +logic and user interface modules.
	 * 
	 * Since this is subtraction and we do not yet support units, we don't recognize
	 * any errors.
	 */
	public void sub(CalculatorValue v) {
		measuredValue -= v.measuredValue;
		errorMessage = "";
	}

	/**********************************************************************************************
	 * The following methods implement computation on the calculator values. These
	 * routines assume that the caller has verified that things are okay for the
	 * operation to take place. These methods understand the technical details of
	 * the values and their reputations, hiding those details from the business
	 * +logic and user interface modules.
	 * 
	 * Since this is multiplication and we do not yet support units, we don't
	 * recognize any errors.
	 */
	public void mpy(CalculatorValue v) {
		measuredValue *= v.measuredValue;
		errorMessage = "";
	}

	/**********************************************************************************************
	 * The following methods implement computation on the calculator values. These
	 * routines assume that the caller has verified that things are okay for the
	 * operation to take place. These methods understand the technical details of
	 * the values and their reputations, hiding those details from the business
	 * +logic and user interface modules.
	 * 
	 * Since this is division and we do not yet support units, we don't recognize
	 * any errors.
	 */
	public void div(CalculatorValue v) {
		if (v.measuredValue == 0) {
			errorMessage = "Invalid Input";
		} else {
			measuredValue /= v.measuredValue;
			errorMessage = "";
		}
	}
}
