package MyDeque;

import LinkedListPackage.LinkedListNode;

//基于链表的双向队列
public class MyDequeDemo extends LinkedListNode {
	// 出队操作，删除元素
	public void removeFirst() {
		deleteByEle(this.Last.ele);
	}

	// 插入结点，即入队操作，将元素插入队尾
	public void addFirst(Object ele) {
		super.addFirst(ele);
	}

	// 判断队列非空
	public void isempty() {
		super.isempty();
	}

	// 取队头元素
	public Object getLast() {
		return this.Last.ele;

	}

	// 队列置空
	public void cleanLinked() {
		super.cleanLinked();
	}

	// 获得队列数目
	public void getsize() {
		System.out.println("该对列有" + this.size + "个元素");
	}

	// 遍历队列
	public String toString() {
		return super.toString();
	}

}
