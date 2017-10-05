package ch1_arrays_and_strings;

public class Ch1p5OneAway {
	
	public static void main(String[] args) {
		
		System.out.println(oneAway("pale","ple"));
		System.out.println(oneAway("pale","pale"));
		System.out.println(oneAway("pale","bale"));
		System.out.println(oneAway("pale","pales"));
		System.out.println(oneAway("p"," "));
		System.out.println(oneAway("p",""));
		System.out.println(oneAway("",""));
		System.out.println(oneAway("pale","bake"));
		
	}
	
	public static boolean oneAway(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		if (Math.abs(aLen - bLen) > 1 || aLen == 0 && bLen > 1 || bLen == 0 && aLen > 1) {
			return false;
		}
		
		if (a.equals(b)) {
			return true;
		}
		
		// at this point, we know that the strings are within 1 in length and neither
		
		if (aLen == bLen) {
			return checkSameLength(a, b);
		}
		
		if (aLen > bLen) {
			return checkDifLength(a, b);
		}
		
		return checkDifLength(b, a);
	}
	
	// assumes strings are same length
	private static boolean checkSameLength(String a, String b) {
		boolean difFound = false;
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) != b.charAt(i)) {
				if (difFound) {
					return false;
				}
				difFound = true;
			}
		}
		return true;
	}
	
	// assumes large is 1 character longer than small
	private static boolean checkDifLength(String large, String small) {
		
		int largeIndex = 0;
		for (int i = 0; i < small.length(); ++i) {
			if (small.charAt(i) != large.charAt(largeIndex)) {
				++largeIndex;
				if (small.charAt(i) != large.charAt(largeIndex) || largeIndex - i > 1) {
					return false;
				}
			}
			++largeIndex;
		}
		return true;
	}
	
	
}
