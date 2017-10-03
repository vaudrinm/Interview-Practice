package util;

public class Util {
	
	public static int indexOfMinValue(int[] arr, int start) {
		
		int minPos = start;
		
		for (int i = start + 1; i < arr.length; ++i) {
			
			if (arr[i] < arr[minPos]) {
				minPos = i;
			}
		}
		
		return minPos;
	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	
	public static void printArr(int[] arr) {
		System.out.print("[");
		
		if (arr.length > 0) {
			System.out.print(arr[0]);
		}
		
		for (int i = 1; i < arr.length; ++i) {
			System.out.print(", " + arr[i]);
		}

		System.out.println("]");
	}

}