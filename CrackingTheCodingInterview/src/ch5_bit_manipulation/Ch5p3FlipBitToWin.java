package ch5_bit_manipulation;

public class Ch5p3FlipBitToWin {

	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(1775));
		System.out.println(longestWithFlipStringManip(1775));
		System.out.println(longestWithFlip(1775));
		System.out.println();
		System.out.println(Integer.toBinaryString(13));
		System.out.println(longestWithFlipStringManip(13));
		System.out.println(longestWithFlip(13));
		System.out.println();
		System.out.println(Integer.toBinaryString(0));
		System.out.println(longestWithFlipStringManip(0));
		System.out.println(longestWithFlip(0));
		System.out.println();
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(longestWithFlipStringManip(Integer.MAX_VALUE));
		System.out.println(longestWithFlip(Integer.MAX_VALUE));
	}
	
	// silly string manip way that is simple but wastes space
	public static int longestWithFlipStringManip(int n) {
		if (n == 0) {
			return 1;
		}
		String binStr = Integer.toBinaryString(n);
		
		String[] binStrArr = binStr.split("0");
		
		int max = binStrArr[0].length() + 1;
		
		for (int i = 1; i < binStrArr.length; ++i) {
			int front = binStrArr[i - 1].length();
			int back = binStrArr[i].length();
			int total = front + back + 1;
			
			if (total > max) {
				max = total;
			}
		}
		
		return max;
	}
	
	// minimal space usage, space complexity is constant (not O(b) where b == # of bits)
	public static int longestWithFlip(int n) {
		// if every bit is 1, we already have the longest bit (there are no bits to flip)
		if (~n == 0) {
			return Integer.BYTES * 8;
		}
		int max = 1;
		
		int prev = 0;
		int next = 0;
		
		while (n != 0) {

			if ((n & 1) == 1) {
				++next;
			} else {
				max = checkNewMax(prev, next, max);
				prev = next;
				next = 0;
			}
			
			n >>>= 1;
		}
		
		// have to check a final time
		max = checkNewMax(prev, next, max);
		
		return max;
	}
	
	private static int checkNewMax(int prev, int next, int max) {
		return Math.max(prev + next + 1, max);
	}
}
