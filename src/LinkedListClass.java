import java.util.NoSuchElementException;

public class LinkedListClass {
	
	public class Node {
		private int value; 
		private Node next;
		
		public Node(int value) {
			this.value = value;
			
		}
	}

	private Node first;
	private Node last;
	
	public void addLast(int item) {
		Node node = new Node(item);
		if(isEmpty()) {
			first = node;
			last = node;	
		} else {
			last.next = node;
			last = node;
		
		}
	}
	
	public void addFirst(int item) {
		Node node = new Node(item);
		if(isEmpty()) {
			first = node;
			last = node;	
		} else {
			node.next = first;
			first = node;
		}
		
		
	}
	
	public int indexOf(int item) {
		
		Node current = first;
		int index = 0;
		while(current != null) {
			if(current.value == item) return index;

			current = current.next;
			index++;
		
		}
		return -1;
		
	}
	
	public void removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if(first == last) {
			first = last = null;
			return;
		}
		
		Node node = first.next;
		first.next = null;
		first = node;
	}

	public void removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		if(first == last) {
			first = last = null;
			return;
		}
		Node previous = getPrevious(last);
		last = previous;
		last.next = null;
		
	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	
	private boolean isEmpty() {
		return first==null;
	}
	
	public void print() {
		Node current = first;
		System.out.print("[");
		while(current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.print("]");

	
	}
	private Node getPrevious(Node node) {
		Node current = first;
		
		while(current!=null) {
			if(current.next == last )return current;
			current = current.next;
		}
		return null;
	}

}
