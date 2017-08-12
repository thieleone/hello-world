package proinf;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<T extends Comparable<T>> implements Iterable<T> {

	private Node first, last;
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(T value) {
		Node node = new Node(value);
		if (isEmpty())
			first = node;
		else
			last.next = node;
		last = node;
		size++;
	}

	public T dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			T wert = first.value;
			first = first.next;
			return wert;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	/////////// inner class ListIterator //////////////
	public class ListIterator implements Iterator<T> {

		private Node current;

		public ListIterator() {
			current = SimpleList.this.first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T value = current.value;
				current = current.next;
				return value;
			} else
				return null;
		}
		public void remove(){

		}
	}

	/////////// inner class Node //////////////
	class Node implements Comparable<T> {
		private T value;
		private Node next = null;

		public Node(T value2) {
			value = value2;
		}

		@Override
		public int compareTo(T wert) {
			return this.value.compareTo(wert);
		}
	}

/////////// main //////////////
	public static void main(String[] args) {
		SimpleList<Integer> liste = new SimpleList<Integer>();
		for (int i = 0; i < 5; i++)
			liste.enqueue(2 * i + 4);
		Iterator<Integer> ite = liste.iterator();
		while (ite.hasNext()) {
			Integer curr = ite.next();
			System.out.println(curr);
		}
	}
}