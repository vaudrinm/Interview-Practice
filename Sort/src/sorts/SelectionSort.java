package sorts;

import util.Util;

public class SelectionSort {
	public void sort(int[] arr) {
		
		for (int i = 0; i < arr.length; ++i) {
			
			int minPos = Util.indexOfMinValue(arr,i);
			
			if (minPos != i) {
				Util.swap(arr, i, minPos);
			}
		}
	}
}
