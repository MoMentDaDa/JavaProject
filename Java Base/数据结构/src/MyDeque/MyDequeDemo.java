package MyDeque;

import LinkedListPackage.LinkedListNode;

//���������˫�����
public class MyDequeDemo extends LinkedListNode {
	// ���Ӳ�����ɾ��Ԫ��
	public void removeFirst() {
		deleteByEle(this.Last.ele);
	}

	// �����㣬����Ӳ�������Ԫ�ز����β
	public void addFirst(Object ele) {
		super.addFirst(ele);
	}

	// �ж϶��зǿ�
	public void isempty() {
		super.isempty();
	}

	// ȡ��ͷԪ��
	public Object getLast() {
		return this.Last.ele;

	}

	// �����ÿ�
	public void cleanLinked() {
		super.cleanLinked();
	}

	// ��ö�����Ŀ
	public void getsize() {
		System.out.println("�ö�����" + this.size + "��Ԫ��");
	}

	// ��������
	public String toString() {
		return super.toString();
	}

}
