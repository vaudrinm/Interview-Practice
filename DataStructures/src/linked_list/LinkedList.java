package linked_list;

public class LinkedList<T> {
	
	public class Node {
		T value;
		Node next;
		Node prev;
		
		public Node(T val, Node next, Node prev) {
			this.next = next;
			this.prev = prev;
			value = val;
			
		}
	}
	
	

}

