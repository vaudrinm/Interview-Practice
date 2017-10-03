package search;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 6, 7, 9, 11, 13, 16, 18};
		BinarySearch bs = new BinarySearch();
		
		System.out.println(bs.itBinarySearch(arr, 6));
		
		System.out.println(bs.itBinarySearch(arr, 3));
		
		System.out.println(bs.recBinarySearch(arr, 6));
		
		System.out.println(bs.recBinarySearch(arr, 3));
		
		
	}
	
	public int itBinarySearch(int[] arr, int numToFind) {
		
		int low = 0, high = arr.length - 1, mid = arr.length / 2;
		
		while (low < high) {
			
			if (numToFind == arr[mid]) {
				return mid;
				
			} else if (numToFind < arr[mid]) {
				high = mid - 1;
				
			} else {
				low = mid + 1;
				
			}
			mid = (low + high) / 2;
		}
		
		return -1;
		
	}
	
	public int recBinarySearch(int[] arr, int numToFind) {
		return binarySearchHelper(arr, numToFind, 0, arr.length - 1);
	}
	
	private int binarySearchHelper(int[] arr, int numToFind, int low, int high) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high) / 2;
		
		if (arr[mid] == numToFind) {
			return mid;
			

		} else if (numToFind < arr[mid]) {
			return binarySearchHelper(arr, numToFind, low, mid - 1);
			
		} else {
			return binarySearchHelper(arr, numToFind, mid + 1, high);
		}
	}

}
