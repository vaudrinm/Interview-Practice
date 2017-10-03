package sorts;

public class MergeSort {
	private void merge(int[] arr, int from, int mid, int to) {
		
		// from is start index, to is end index, so +1 for the issue we're dealing with an
		// inclusive range rather than a length
		int range = to - from + 1;
		
		int[] mergedArr = new int[range];
	
		int i1 = from;
		
		int i2 = mid + 1;
		
		int mergedIndex = 0;
		
		// merge them for the length of the sub arrays
		while (i1 <= mid && i2 <= to) {
			
			if (arr[i1] <= arr[i2]) {
				mergedArr[mergedIndex] = arr[i1];
				++i1;
			} else {
				mergedArr[mergedIndex] = arr[i2];
				++i2;
			}
			++mergedIndex;
		}
		
		
		// cleanup: make sure any trailing items in 1 of the 2 sub arrays are included
		// ie if the sub arrays are not of equal length
		while (i1 <= mid) {
			mergedArr[mergedIndex] = arr[i1];
			++i1;
			++mergedIndex;
		}
		
		while (i2 <= to) {
			mergedArr[mergedIndex] = arr[i2];
			++i2;
			++mergedIndex;
		}
		
		for(int i = 0; i < mergedArr.length; ++i) {
			arr[from + i] = mergedArr[i];
		}
	}
	
	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public void mergeSort(int[] arr, int from, int to) {
		if (from == to) {
			return;
		}
		
		int mid = (from + to) / 2;
		
		mergeSort(arr, from, mid);
		mergeSort(arr, mid + 1, to);
		merge(arr, from, mid, to);
	}
}
