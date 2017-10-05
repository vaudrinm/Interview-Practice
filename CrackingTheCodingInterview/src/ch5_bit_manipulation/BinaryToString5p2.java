package ch5_bit_manipulation;

public class BinaryToString5p2 {
	
	// Problem:
	/*
	 * Given a real number between 0 and 1 (eg 0.72) that is passed in as a double, 
	 * print the binary representation. If the number cannot be represented accurately in binary
	 * with at most 32 characters, print "ERROR"
	 */
	
	// Questions (my own):
	/*
	 * Do I include the leading 0 and decimal in the character count? I will assume no for now
	 * 
	 */
	
	public static void main(String[] args) {
		
	}
	
	// first hack just repeatedly concatenating strings (wasteful)
	public static void binaryToString(double n) {
		if (n <= 0 || n >= 1) {
			System.out.println("ERROR");
			return;
		}
		String binStr = "0.";
		
		int count = 0;
		while (count < 32 && n != 0) {
			n *= 2;
			
			int leadingDigit = (int) n;
			
			n -= leadingDigit;
			binStr += leadingDigit;
			
			++count;
		}
		
		if (n != 0) {
			System.out.println("ERROR");
		} else {
			System.out.println(binStr);
		}
	}
	
	// second attempt using StringBuilder for efficient String manipulation
	public static void binaryToStringBuilder(double n) {
		
	}

}
