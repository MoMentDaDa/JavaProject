package Queue_JavaBook;

import java.util.*;

public class DequeTestDemo {

	public static void main(String[] args) {
//利用数组实现双向队列结构，数组头尾队列头
		Deque<String> queue =new ArrayDeque<>();
		queue.add("老二");//向队列末尾添加元素
		queue.addFirst("老大");//向队列头部添加元素
		queue.addLast("老三");//向队列尾部添加元素
		queue.add("老四");
		System.out.println(queue);//打印输出队列
		queue.removeLast();//删除队列最后一个元素
		System.out.println(queue);
		System.out.println("---------------------");
//运用PriorityQueue类实现优先级队列，即对元素进行排序
		Queue<Integer> queue2=new PriorityQueue<>();
		queue2.add(67);
		queue2.add(12);
		queue2.add(33);
		System.out.println(queue2);
//一次按照队列元素优先级删除元素
		while(!queue2.isEmpty()) {
			System.out.println(queue2.remove()+"  ");
			System.out.println(queue2);
		}
	}

}
