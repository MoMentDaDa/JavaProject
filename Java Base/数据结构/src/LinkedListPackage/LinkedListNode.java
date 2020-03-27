package LinkedListPackage;

public class LinkedListNode {
	public Node First;// �����һ���ڵ�
	public Node Last;// �������һ���ڵ�
	public int size;// �ڵ�����

	public static class Node {
		// �ڵ�����ڲ���
		Node Prev;// ��һ���ڵ����
		Node Next;// ��һ���ڵ����
		public Object ele;// �ڵ�����

		public Node() {
		}

		public Node(Object ele) {
			this.ele = ele;
		}

	}

// ����Ԫ�ز���Ԫ��
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

// ����Ԫ�ز�������
	public void searchByEle(Object Ele) {
		Node current = this.First;
		for (int i = 0; i < size; i++) {
			if (current.ele.equals(Ele)) {
				System.out.println("��Ԫ�ص�����Ϊ" + i);
				break;
			} else if (current.Next == null) {
				System.out.println("���޴�Ԫ��");
				break;
			} else
				current = current.Next;
		}
	}

// ����ָ��Ԫ�ص�ǰ��
	public Node searchByElePrev(Object Ele) {
		Node current = search(Ele);
		return current.Prev;
	}

// ����ָ��Ԫ�صĺ���
	public Node searchByEleNext(Object Ele) {
		Node current = search(Ele);
		return current.Next;
	}

// ����ָ��������Ԫ��
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
		return current;// ����Ԫ����Ϣ
	}

// ����ָ������Ԫ�ص�ǰ��
	public Node searchByIndexPrev(int Index) {
		Node current = searchByIndex(Index);
		return current.Prev;
	}

// ����ָ������Ԫ�صĺ���
	public Node searchByIndexNext(int Index) {
		Node current = searchByIndex(Index);
		return current.Next;
	}

// ͷ�巨
	public void addFirst(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.First = node;
			this.Last = node;
		} else {
			// ��֮ǰ��һ����Ϊ�����ڵ����һ���ڵ�
			node.Next = this.First;
			// �������ڵ���Ϊ֮ǰ��һ���ڵ����һ���ڵ�
			this.First.Prev = node;
			// �������ڵ���Ϊ��һ���ڵ�
			this.First = node;
		}
		size++;
	}

// β�巨
	public void addLast(Object ele) {
		Node node = new Node(ele);
		if (size == 0) {
			this.First = node;
			this.Last = node;
		} else {
			// �����Ľڵ�������½ڵ�
			this.Last.Next = node;
			// ���½ڵ���ָ��ǰһ�ڵ�
			node.Prev = this.Last;
			// �����ڵ�ָ���½ڵ�
			this.Last = node;
		}
		size++;
	}

// ��ָ��Ԫ��ǰ�����Ԫ��
	public void addinElePrev(Object Ele, Object newele) {
		Node NewNode = new Node(newele);
		Node current = searchByElePrev(Ele);// Ѱ����ӽڵ�
		NewNode.Next = current.Next;
		current.Next = NewNode;
		NewNode.Prev = current;
		NewNode.Next.Prev = NewNode;
		size++;

	}

// ��ָ��Ԫ�غ������Ԫ��
	public void addinEleNext(Object Ele, Object newele) {
		Node NewNode = new Node(newele);
		Node current = searchByEleNext(Ele);
		current.Prev.Next = NewNode;
		NewNode.Prev = current.Prev;
		NewNode.Next = current;
		current.Prev = NewNode;
		size++;
	}

// ��ָ������ǰ�����Ԫ��
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

// ��ָ�������������Ԫ��
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

// ����Ԫ��ɾ������Ԫ��
	public void deleteByEle(Object Ele) {
		Node current = search(Ele);
		try {
			if (current == this.First) {// ��Ϊͷ���
				this.First = current.Next;
				this.First.Prev = null;
			} else if (current == this.Last) {// ��Ϊδ�ڵ�
				this.Last = current.Prev;
				this.Last.Next = null;
			} else {// ��Ϊ�м�
				// ��ɾ����ǰ�ڵ����һ���ڵ���Ϊɾ���ڵ����һ��Next
				current.Prev.Next = current.Next;
				// ��ɾ����ǰ�ڵ����һ���ڵ���Ϊ��ǰɾ�����¸�Prev
				current.Next.Prev = current.Prev;
			}
			size--;
		} catch (NullPointerException e) {
			System.out.println("�������޸�Ԫ��");
		}
	}

// ��������ɾ������Ԫ��
	public void deleteByIndex(int Index) {
		Node current = searchByIndex(Index);
		try {
			if (current == this.First) {// ��Ϊͷ���
				this.First = current.Next;
				this.First.Prev = null;
			} else if (current == this.Last) {// ��Ϊδ�ڵ�
				this.Last = current.Prev;
				this.Last.Next = null;
			} else {// ��Ϊ�м�
				// ��ɾ����ǰ�ڵ����һ���ڵ���Ϊɾ���ڵ����һ��Next
				current.Prev.Next = current.Next;
				// ��ɾ����ǰ�ڵ����һ���ڵ���Ϊ��ǰɾ�����¸�Prev
				current.Next.Prev = current.Prev;
			}
			size--;
		} catch (NullPointerException e) {
			System.out.println("ɾ������Խ��");
		}
	}

//�޸�ָ��������Ԫ��
	public void updateByIndex(int Index, Object Ele) {
		Node current = searchByIndex(Index);
		current.ele = Ele;
	}

//�޸�ָ��Ԫ��
	public void updateByEle(Object oldele, Object newEle) {
		Node current = search(oldele);
		current.ele = newEle;
	}

//�������
	public void cleanLinked() {
		if (size == 0) {
			System.out.println("����Ϊ��,����Ҫ���");
		} else {
			while (size != 0) {
				this.First = this.First.Next;
				size--;
			}
		}
	}

// �жϷǿ�
	public void isempty() {
		if (size != 0)
			System.out.println("����Ϊ��");
		else
			System.out.println("����Ϊ��");
	}

//�������
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

//�������
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
