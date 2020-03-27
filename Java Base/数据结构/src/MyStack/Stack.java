package MyStack;

public class Stack {

	public static void main(String[] args) {
		MyStackDemo stack=new MyStackDemo();
		stack.isEmpty();
		System.out.println(stack);
		stack.push("a");
		System.out.println(stack);
		stack.push("b");
		System.out.println(stack);
		stack.push("c");
		stack.isEmpty();
		stack.getsize();
		System.out.println(stack);
		stack.getTop();
		stack.Pop();
		stack.getsize();
		System.out.println(stack);
		stack.clean();
		stack.isEmpty();
		stack.getsize();
		System.out.println(stack);
	}

}
