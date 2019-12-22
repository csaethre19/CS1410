package wrapperClass;

import java.util.Arrays;
import java.util.Random;

public class DemoWrapperClass {
	private final static Random rand = new Random();
	
	public static String minMax() {
		return "Byte   : [" + Byte.MIN_VALUE + " , " + Byte.MAX_VALUE + "]\n" +
				"Short  : [" + Short.MIN_VALUE + " , " + Short.MAX_VALUE + "]\n" +
				"Integer: [" + Integer.MIN_VALUE + " , " + Integer.MAX_VALUE + "]\n" + 
				"Long   : [" + Long.MIN_VALUE + " ," + Long.MAX_VALUE + "]\n" +
				"Float  : [" + Float.MIN_VALUE + " , " + Float.MAX_VALUE + "]\n" +
				"Double : [" + Double.MIN_VALUE + " ," + Double.MAX_VALUE + "]\n";		
	}
	
	public static String convert() {
		String conversionStr = "Base 10  Base 16  Base 8   Base 2\n"
				+ "-------  -------  ------   ------\n";
		Integer[] numbers = new Integer[] {9, rand.nextInt(99) + 10, 255, rand.nextInt(9999) + 1000, 12345};
		for (Integer n : numbers) {
			conversionStr += String.format("%-9s", n);
			conversionStr += String.format("%-9s",Integer.toHexString(n));
			conversionStr += String.format("%-9s", Integer.toOctalString(n));
			conversionStr += String.format(Integer.toBinaryString(n) + "\n");
		}
		
		return conversionStr;
	}
	
	public static String charProperties() {
		Character[] characters = new Character[] {'8', ' ', '#', getRandomLetter(),
					getRandomLetter(), getRandomLetter()};
		String charStr = "";
		for (Character c : characters) {
			if (Character.isDigit(c)) {
				charStr += c + " number\n";
			}
			
			else if (Character.isWhitespace(c)) {
				charStr += c + " white space\n";
			}
			
			else if (Character.isLetter(c)) {
				if (Character.isLowerCase(c)) {
					charStr += c + " lowercase letter\n";
				}
				else {
					charStr += c + " uppercase letter\n";
				}
			}
			else {
				charStr += c + "\n";
			}
		}
		return charStr;
	} 
	
	public static String parse() {
		String[] floatingPointNumbers = new String[] { "1.1", "2.2", "3.3", 
				"4.4", "5.5", "6.6", "7.7", "8.8", "9.9"};
		String[] wholeNumbers = new String[10];
		double floatingSum = 0;
		int wholeNumSum = 0;
		for (int i = 0; i < wholeNumbers.length; i++) {
			Integer randomNum = rand.nextInt(89) + 10;
			wholeNumbers[i] = Integer.toString(randomNum);
		}
		
		for (String s : floatingPointNumbers) {
			floatingSum += Double.parseDouble(s);
		}
		
		for (String s : wholeNumbers) {
			wholeNumSum += Integer.parseInt(s);
		}
		return Arrays.toString(floatingPointNumbers) + " .. sum = " + floatingSum + "\n"
				+ Arrays.toString(wholeNumbers) + " .. sum = " + wholeNumSum;
	}
	
	private static char getRandomLetter() {
		int letter = rand.nextInt(24);
		char[] alphabet = new char[] {'a', 'b', 'c',
				'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
				't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		if (rand.nextBoolean()) {
			return Character.toLowerCase(alphabet[letter]);
		}
		else {
			return Character.toUpperCase(alphabet[letter]);
		}
	}
}
