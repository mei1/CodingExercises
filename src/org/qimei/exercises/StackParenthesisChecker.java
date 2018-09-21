package org.qimei.codingGames;

import java.util.Stack;

public class StackParenthesisChecker {

	public static void main(String[] args) {

		System.out.println("({[<>]}) - " + isParanthesisBalanced("({[<>]})")); // true
		System.out.println("[({[({<>})]})] - " + isParanthesisBalanced("[({[({<>})]})]")); // true
		System.out.println("]{><}[ - " + isParanthesisBalanced("]{><}[")); // false
		System.out.println(")]}{[( - " + isParanthesisBalanced(")]}{[(")); // false
		System.out.println("([>} - " + isParanthesisBalanced("([>}")); // false
		System.out.println("({)} - " + isParanthesisBalanced("({)}")); // false
		System.out.println("hwu2y1231{}() - " + isParanthesisBalanced("hwu2y1231{}()")); // true
		System.out.println("hwu2y1231{) - " + isParanthesisBalanced("hwu2y1231{)")); // false
		System.out.println(
				"isParanthesisBalanced('testStr') - " + isParanthesisBalanced("isParanthesisBalanced('testStr')")); // true

	}

	private static boolean isParanthesisBalanced(String inputStr) {

		final String openingParenthesis = "({[<";
		final String closingParenthesis = ")}]>";

		Stack<String> openParenthesisAccumalator = new Stack<String>();

		String previousElement = null;
		String currentElement = null;

		for (int i = 0; i < inputStr.length(); i++) {

			currentElement = inputStr.substring(i, i + 1);
			// System.out.println(currentElement);

			// ignore the characters that are not parenthesis
			if (-1 == openingParenthesis.indexOf(currentElement) && -1 == closingParenthesis.indexOf(currentElement)) {
				continue;
			}

			// cannot open with a closing element when the stack is empty
			if (openParenthesisAccumalator.isEmpty() && -1 != closingParenthesis.indexOf(currentElement)) {
				return false;
			}

			// if its a opening parenthesis, just add it to stack
			if (-1 != openingParenthesis.indexOf(currentElement)) {
				openParenthesisAccumalator.push(currentElement);
			}

			// if its a closing element, ensure the correct bracket types are
			// matched.
			// cannot use indexof openingParenthesis, as we need to ensure
			// correct types as well.
			if (-1 != closingParenthesis.indexOf(currentElement)) {

				previousElement = openParenthesisAccumalator.peek();

				// System.out.println("currentElement - " + currentElement + "
				// previousElement - " + previousElement);

				// if a correct match is found, remove the element from stack.
				if ((currentElement.equals(")") && previousElement.equals("("))
						|| (currentElement.equals("}") && previousElement.equals("{"))
						|| (currentElement.equals("]") && previousElement.equals("["))
						|| (currentElement.equals(">") && previousElement.equals("<"))) {

					// System.out.println("removing matched item - " +
					// previousElement);
					openParenthesisAccumalator.pop();
				} else {
					return false;
				}
			}

		}

		// if the input string is fully balanced, then the stack will be
		// empty by the time the for loop finishes.
		return openParenthesisAccumalator.isEmpty();
	}

}
