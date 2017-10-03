package fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Fibonnaci {
	
	public static void main(String[] args) {
		System.out.println(fibNotDynamic(9));
		System.out.println(fibNotDynIt(8));
		
		Map<Integer, Integer> memoized = new HashMap<Integer, Integer>();
		
		System.out.println(fibDynamicRec(8, memoized));
		System.out.println(fibDynamicRec(7, memoized));
		
		test1();
	
	}

	public static int fibNotDynamic(int n) {
		
		if (n <= 2) {
			return 1; 
		} else {
			return fibNotDynamic(n - 1) + fibNotDynamic(n - 2);
		}
	}
	
	
	public static void test1() {
		int[] arr = {1,2,3,4};
		test2(arr);
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]);
			
		}
		System.out.println();
	}
	public static void test2(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			arr[i] *= 2;
		}
	}
	
	public static int fibNotDynIt(int n) {
		
		if (n <= 2) {
			return 1;
		}
		
		int prev1 = 1, prev2 = 1, val = 1;
		
		for (int i = 3; i <= n; ++i) {
			val = prev1 + prev2;
			prev2 = prev1;
			prev1 = val;
		}
		
		return val;
	}
	
	public static int fibDynamicRec(int n, Map<Integer, Integer> mem) {
		
		if (mem.containsKey(n)) {
			return mem.get(n);
		} else if (n <= 2) {
			mem.put(n, 1);
			return 1;
		} else {
			int f = fibDynamicRec(n - 1, mem) + fibDynamicRec(n - 2, mem);
			mem.put(n, f);
			return f;
		}
	}
	
	public static int fibDynBottomUp(int n, Map<Integer, Integer> mem) {
		boolean lol = true;
		lol &= false;
		return -1;
	}
}













