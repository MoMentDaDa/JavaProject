package MyDeque;

public class TestDemo {

	public static void main(String[] args) {
		MyDequeDemo deque = new MyDequeDemo();
		System.out.println(deque);
		deque.isempty();
		deque.addFirst("A");
		deque.addFirst("B");
		deque.addFirst("C");
		System.out.println(deque);
		deque.isempty();
		deque.getsize();
		System.out.println(deque);
		Object a = deque.getLast();
		System.out.println("队头元素为" + a);
		deque.removeFirst();
		deque.getsize();
		System.out.println(deque);
		deque.cleanLinked();
		deque.isempty();
		deque.getsize();
		System.out.println(deque);
	}

}
