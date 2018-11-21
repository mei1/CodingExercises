package org.qimei.exercises;

public class TaxCalculation {

	final static double FIRST_RANGE = 18200.00;
	final static double SECOND_RANGE = 37000.00;
	final static double THIRD_RANGE = 90000.00;
	final static double FORTH_RANGE = 180000.00;

	final static double ZERO_RATE = 0.00;
	final static double FIRST_RATE = 0.19;
	final static double SECOND_RATE = 0.325;
	final static double THIRD_RATE = 0.37;
	final static double FORTH_RATE = 0.45;

	final static double FIRST_TAX_AMOUNT = FIRST_RANGE * ZERO_RATE;
	final static double SECOND_TAX_AMOUNT = (SECOND_RANGE - FIRST_RANGE) * FIRST_RATE;
	final static double THIRD_TAX_AMOUNT = SECOND_TAX_AMOUNT + ((THIRD_RANGE - SECOND_RANGE) * SECOND_RATE);
	final static double FORTH_TAX_AMOUNT = THIRD_TAX_AMOUNT + ((FORTH_RANGE - THIRD_RANGE) * THIRD_RATE);

	public static void main(String[] args) {
		System.out.println("FIRST_TAX_AMOUNT:" + FIRST_TAX_AMOUNT);
		System.out.println("SECOND_TAX_AMOUNT:" + SECOND_TAX_AMOUNT);
		System.out.println("THIRD_TAX_AMOUNT:" + THIRD_TAX_AMOUNT);
		System.out.println("FORTH_TAX_AMOUNT:" + FORTH_TAX_AMOUNT);

		System.out.println("tax to pay:" + getTaxAmount(75000));
	}

	public static float getTaxAmount(float income) {

		float taxAmount = 0;

		if (income > FIRST_RANGE && income < SECOND_RANGE) {
			taxAmount = (float) (FIRST_TAX_AMOUNT + (income - FIRST_RANGE) * FIRST_RATE);
		}

		if (income > SECOND_RANGE && income < THIRD_RANGE) {
			taxAmount = (float) (SECOND_TAX_AMOUNT + (income - SECOND_RANGE) * SECOND_RATE);
		}

		if (income > THIRD_RANGE && income < FORTH_RANGE) {
			taxAmount = (float) (THIRD_TAX_AMOUNT + (income - THIRD_RANGE) * THIRD_RATE);
		}
		
		if (income > FORTH_RANGE) {
			taxAmount = (float) (FORTH_TAX_AMOUNT + (income - FORTH_RANGE) * FORTH_RATE);
		}
		return taxAmount;
	}

}
