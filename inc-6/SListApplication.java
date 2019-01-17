/*
Create a generic, singly linked list class called SList,
which, to keep things simple, does not implement the List interface.
Each Link object in the list should contain a reference to the next element in the list,
but not the previous one (LinkedList, in contrast, is a doubly linked list,
which means it maintains links in both directions).
Create your own SListIterator which, again for simplicity, does not implement ListIterator.
The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
The only way to insert and remove elements from an SList is through SListIterator.
Write code to demonstrate SList.
*/
import java.util.*;
class SList<T> {
	Link<T> firstLink = new Link<T>(null);
	public SListIterator<T> iterator() {
		return new SListIterator<T>(firstLink);
	}
	public String toString() {
		if(firstLink == null)
			return "[]";
		System.out.print("[");
		SListIterator<T> sListIterator = this.iterator();
		StringBuilder stringBuilder = new StringBuilder();
		while(sListIterator.hasNext()) {
			stringBuilder.append(sListIterator.next() + (sListIterator.hasNext() ? ", " : ""));
		}
		return stringBuilder + "]";
	}
}

class Link<T> {
	T t;
	Link<T> next;
	Link(T t) {
		this(t,null);
	}
	Link(T t,Link<T> next) {
		this.t = t;
		this.next = next;
	}
	public String toString() {
		if(t == null) return "null";
		return t.toString();
	}
}

class SListIterator<T> {
	Link<T> current;
	SListIterator(Link<T> link) {
		current = link;
	}
	public Link<T> next() {
		current = current.next;
		return current;
	}
	public boolean hasNext() {
		return (current.next != null);
	}
	public void add(T t) {
		current.next = new Link<T>(t, current.next);
	}
	public void remove() {
		if(current.next != null)
			current.next = current.next.next;
	}
}

public class SListApplication {

	public static void main(String[] args) {
		SList<String> slist = new SList<String>();
		SListIterator<String> iterator = slist.iterator();
		//System.out.println("Enter your choice");
		Scanner scanner=new Scanner(System.in);
		iterator.add("One");
		System.out.println(slist);
		iterator.next();
		iterator.add("Two");
		System.out.println(slist);
		SList<Integer> slist2 = new SList<Integer>();
		SListIterator<Integer> iterator2 = slist2.iterator();
		for(int i = 0; i < 5; i++) {
			iterator2.add(i);
			iterator2.next();
		}
		System.out.println(slist2);
		SListIterator<Integer> iterator3 = slist2.iterator();
		iterator3.remove();
		System.out.println(slist2);
		while(iterator3.hasNext())
			iterator3.remove();
		System.out.println(slist2);
	}

}

