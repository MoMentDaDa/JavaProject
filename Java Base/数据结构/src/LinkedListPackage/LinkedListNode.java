package LinkedListPackage;

public class LinkedListNode {
	public Node First;// 链表第一个节点
	public Node Last;// 链表最后一个节点
	public int size;// 节点数量

	public static class Node {
		// 节点对象内部类
		Node Prev;// 上一个节点对象
		Node Next;// 下一个节点对象
		public Object ele;// 节点数据

		public Node() {
		}

		public Node(Object ele) {
			this.ele = ele;
		}

	}

// 根据元素查找元素
	public Node search(Object Ele) {
		Node current = this.First;
		while (!current.ele.equals(Ele)) {
			if (current.Next == null)
				return null;
			else
				current = current.Next;
		}
		return current;
	}

// 根据元素查找索引
	public void searchByEle(Object Ele) {
		Node current = this.First;
		for (int i = 0; i < size; i++) {
			if (current.ele.equals(Ele)) {
				System.out.println("该元素的索引为" + i);
				break;
			} else if (current.Next == null) {
				System.out.println("查无此元素");
				break;
			} else
				current = current.Next;
		}
	}

// 查找指定元素的前驱
	public Node searchByElePrev(Object Ele) {
		Node current = search(Ele);
		return current.Prev;
	}

// 查找指定元素的后驱
	public Node searchByEleNext(Object Ele) {
		Node current = search(Ele);
		return current.Next;
	}

// 查找指定索引的元素
	public Node searchByIndex(int Index) {
		Node current = this.First;
		int i = 0;
		while (Index != i) {
			if (current.Next == null) {
				return null;
			} else {
				current = current.Next;
				i++;
			}
		}
		return current;// 返回元素信息
	}

// 查找指定索引元素的前驱
	public Node searchByIndexPrev(int Index) {
		Node current = searchByIndex(Index);
		return current.Prev;
	}

// 查找指定索引元素的后驱
	public Node searchByIndexNext(int Index) {
		Node current = searchByIndex(Index);
		return current.Next;
	}

// 头插法
	public void addFirst(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.First = node;
			this.Last = node;
		} else {
			// 把之前第一个作为新增节点的下一个节点
			node.Next = this.First;
			// 把新增节点作为之前第一个节点的上一个节点
			this.First.Prev = node;
			// 把新增节点作为第一个节点
			this.First = node;
		}
		size++;
	}

// 尾插法
	public void addLast(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.First = node;
			this.Last = node;
		} else {
			// 在最后的节点上添加新节点
			this.Last.Next = node;
			// 在新节点上指向前一节点
			node.Prev = this.Last;
			// 把最后节点指向新节点
			this.Last = node;
		}
		size++;
	}

// 在指定元素前面添加元素
	public void addinElePrev(Object Ele, Object newele) {
		Node NewNode = new Node(newele);
		Node current = searchByElePrev(Ele);// 寻找添加节点
		NewNode.Next = current.Next;
		current.Next = NewNode;
		NewNode.Prev = current;
		NewNode.Next.Prev = NewNode;
		size++;

	}

// 在指定元素后面添加元素
	public void addinEleNext(Object Ele, Object newele) {
		Node NewNode = new Node(newele);
		Node current = searchByEleNext(Ele);
		current.Prev.Next = NewNode;
		NewNode.Prev = current.Prev;
		NewNode.Next = current;
		current.Prev = NewNode;
		size++;
	}

// 在指定索引前面添加元素
	public void addByIndexPrev(int Index, Object Ele) {
		Node NewNode = new Node(Ele);
		Node current = searchByIndex(Index);
		if (current == this.First) {
			addFirst(Ele);
		} else {
			NewNode.Prev = current.Prev;
			current.Prev.Next = NewNode;
			NewNode.Next = current;
			current.Prev = NewNode;
			size++;
		}
	}

// 在指定索引后面添加元素
	public void addByIndexNext(int Index, Object Ele) {
		Node NewNode = new Node(Ele);
		Node current = searchByIndex(Index);
		if (current == this.Last) {
			addLast(Ele);
		} else {
			NewNode.Next = current.Next;
			NewNode.Prev = current;
			current.Next = NewNode;
			NewNode.Next.Prev = NewNode;
			size++;
		}
	}

// 根据元素删除任意元素
	public void deleteByEle(Object Ele) {
		Node current = search(Ele);
		try {
			if (current == this.First) {// 若为头结点
				this.First = current.Next;
				this.First.Prev = null;
			} else if (current == this.Last) {// 若为未节点
				this.Last = current.Prev;
				this.Last.Next = null;
			} else {// 若为中间
				// 把删除当前节点的下一个节点作为删除节点的上一个Next
				current.Prev.Next = current.Next;
				// 把删除当前节点的上一个节点作为当前删除的下个Prev
				current.Next.Prev = current.Prev;
			}
			size--;
		} catch (NullPointerException e) {
			System.out.println("链表中无该元素");
		}
	}

// 根据索引删除任意元素
	public void deleteByIndex(int Index) {
		Node current = searchByIndex(Index);
		try {
			if (current == this.First) {// 若为头结点
				this.First = current.Next;
				this.First.Prev = null;
			} else if (current == this.Last) {// 若为未节点
				this.Last = current.Prev;
				this.Last.Next = null;
			} else {// 若为中间
				// 把删除当前节点的下一个节点作为删除节点的上一个Next
				current.Prev.Next = current.Next;
				// 把删除当前节点的上一个节点作为当前删除的下个Prev
				current.Next.Prev = current.Prev;
			}
			size--;
		} catch (NullPointerException e) {
			System.out.println("删除索引越界");
		}
	}

//修改指定索引的元素
	public void updateByIndex(int Index, Object Ele) {
		Node current = searchByIndex(Index);
		current.ele = Ele;
	}

//修改指定元素
	public void updateByEle(Object oldele, Object newEle) {
		Node current = search(oldele);
		current.ele = newEle;
	}

//清空链表
	public void cleanLinked() {
		if (size == 0) {
			System.out.println("链表为空,不需要清空");
		} else {
			while (size != 0) {
				this.First = this.First.Next;
				size--;
			}
		}
	}

// 判断非空
	public void isempty() {
		if (size != 0)
			System.out.println("链表不为空");
		else
			System.out.println("链表为空");
	}

//正向遍历
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size * 2 + 1);
		sb.append("[");
		Node current = this.First;
		for (int i = 0; i < size; i++) {
			sb.append(current.ele);
			if (i == size - 1) {
				sb.append("]");
			} else {
				sb.append(",");
				current = current.Next;
			}
		}
		return sb.toString();
	}

//反向遍历
	public void ReseverPrint() {
		Node current = new Node();
		int i = size - 1;
		while (i >= 0) {
			current = searchByIndex(i);
			System.out.print(current.ele + ",");
			i--;
		}
	}

}
