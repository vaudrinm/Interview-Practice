package ch5_bit_manipulation;

public class Insertion5p1 {
	
	// Problem:
	/*	
	 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
	 * Write a method to insert M into N such that M starts at bit j and ends at bit i. 
	 * You can assume that the bits j thorugh i have enoughs pace to fit all of M. That is,
	 * if M = 10011, you can assume that there are at least 5 bits between j and i. You 
	 * would not, for example, have j = 3 and i = 2, because M could not fully fit between 
	 * bit 3 and bit 2.
	*/
	
	// Example:
	/*
	 * Input:	N = 10000000000, M = 10011, i = 2, j = 6
	 * Output:	N = 10001001100
	 */
	
	// Questions (my own):
	/*
	 * big-endian or little little-endian?
	 * 
	 * signed or unsigned? -> shouldnt matter for this problem
	 * 
	 * are we guaranteed that i to j inserts the entirety of M into N, or are we 
	 * potentially only inserting a portion of M into N? going to assume the latter, 
	 * should still work regardless
	 * 
	 * should I insert directly into N or just return a new value? it seems pointless
	 * to manipulate N directly given that it's passed by value (without returning it)
	 * 
	 * should the method return or print? I'm going to return and then print in main
	 * 
	 * will j or i necessarily be larger? I'm going to assume either could be the upper or lower bound
	 */
	
	// Notes (my own):
	/* 
	 * the range from i to j is inclusive on both ends
	 * the length of range is j - i + 1
	 */
	
	
	// for testing
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(insertion(1000000000, 10011, 2, 6)));
		System.out.println(Integer.toBinaryString(insertion(100000, 110, 0, 3)));
	}
	
	public static int insertion(int N, int M, int i, int j) {
		
		int binN = Integer.parseInt("" + N, 2);
		int binM = Integer.parseInt("" + M, 2);
		// modify N to accept M appropriately
		int mask = createMask(i, j);
		binN &= mask;
		
		// shift and mask M to fit appropriately within N
		binM <<= Math.min(i,j);
		binM &= ~mask;
		
		binN |= binM;
		
		return binN;
	}
	
	private static int createMask(int i, int j) {
		int mask = createMaskBase(i, j);
		
		mask <<= Math.min(i,j);
		mask = ~mask;
		
		return mask;
	}
	
	private static int createMaskBase(int i, int j) {
		int maskLength = Math.max(i,j) - Math.min(i,j) + 1;
		return (int) (Math.pow(2, maskLength) - 1);
	}
}
