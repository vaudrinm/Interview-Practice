package heap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxHeap {
	
	private int mSize;
	private int[] mHeap;
	
	
	
	public MaxHeap () {
		mSize = 0;
		mHeap = new int[4];
		
	}
	
	public int size() {
		return mSize;
	}
	
	public boolean isEmpty() {
		return mSize == 0;
	}
	
	public void add(int val) {
		mHeap[mSize] = val;
		bubbleUp(mSize);
		
		++mSize;
		
		if (mSize >= mHeap.length) {
			int[] tempHeap = new int[mHeap.length * 2];
			
			for (int i = 0; i < mHeap.length; ++i) {
				tempHeap[i] = mHeap[i];
			}
			
			mHeap = tempHeap;
		}
		
		// bubble up
		
	}
	
	public int remove() {
		// get max value (should be index 0)
		if (mSize > 0) {
			int top = mHeap[0];
			
			// swap bottom and then bubble down
			mHeap[0] = mHeap[--mSize];
			
			// bubble down
			bubbleDown(0);
			
			return top;
		}
		return Integer.MIN_VALUE;
	}
	
	public int peek() {
		if (mSize > 0) {
			return mHeap[0];
		}
		return Integer.MIN_VALUE;
	}
	
	private void swap(int index1, int index2) {
		int temp = mHeap[index1];
		mHeap[index1] = mHeap[index2];
		mHeap[index2] = temp;
	}
	
	private int leftChildIndex(int index) {
		return index*2 + 1;
	}
	
	private int rightChildIndex(int index) {
		return index*2 + 2;
	}
	

	private void bubbleDown(int parentIndex) {
		if (parentIndex >= mSize) {
			return;
		}
		
		int leftIndex = leftChildIndex(parentIndex);
		int rightIndex = rightChildIndex(parentIndex);
		
		// determine if right is valid, largest child, and parent is smaller than it
		if (rightIndex < mSize 
				&& mHeap[leftIndex] < mHeap[rightIndex] 
				&& mHeap[parentIndex] < mHeap[rightIndex]) {
			// swap right child
			swap(parentIndex, rightIndex);
			bubbleDown(rightIndex);
			
		// determine if parent is smaller than left child	
		} else if (leftIndex < mSize && mHeap[parentIndex] < mHeap[leftIndex]) {
			// swap
			swap(parentIndex, leftIndex);
			bubbleDown(leftIndex);
		}
	}
	
	private void bubbleUp(int index) {
		if (index < 0) {
			return;
		}
		int parentIndex = (index - 1)/2;
		
		if (parentIndex >= 0 && mHeap[index] > mHeap[parentIndex]) {
			swap(index, parentIndex);
			bubbleUp(parentIndex);
		}
	}
	
	
	// parentIndex must be a valid. Returns true if swap occured

	
	
	// purely for testing, would not exist in actual object
	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap();
		
		Set<Integer> s = new HashSet<Integer>();

		mh.add(1);
		mh.add(2);
		mh.add(3);
		mh.add(4);
		mh.add(-1);
		mh.add(-2);
		mh.add(0);
		mh.add(0);
		mh.add(0);
		mh.add(0);
		mh.add(4);
		mh.add(-1);
		mh.add(-2);
		mh.add(9);
		mh.add(3);
		mh.add(4);
		
		while (mh.size() > 0) {
			System.out.println(mh.remove());
		}
		int test = mh.peek();
		System.out.println(mh.peek());
		System.out.println(mh.remove());
		
		
	}
}
