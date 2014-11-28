package com.blackcrowsys;

import java.util.Random;

/**
 * Generates a parcel code given two Strings.
 *
 * @author rahulsingh
 *
 */
public class GenerateParcelCode {

	/**
	 * We use a String Builder to build the parcel code
	 * for an order. We add the first String as the prefix,
	 * then add a random number and then append the second
	 * String to the end of the code and return it.
	 *
	 * @param str1 prefix String
	 * @param str2 suffix String
	 * @return String string to be returned
	 */
	public static String getCodeForStrings(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		Random random = new Random();
		int n = random.nextInt(9999999) + 1000000;
		sb.append(n);
		sb.append(str2);
		return sb.toString();
	}
}
