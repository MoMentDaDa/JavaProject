package LinkedListPackage;

public class LinkedListTestDemo {

	public static void main(String[] args) {
		LinkedListNode List = new LinkedListNode();
		List.isempty();// �жϷǿ�
		List.addLast("B");// β�巨
		List.addLast("E");
		System.out.println(List);// ��ӡ���
		List.isempty();
		List.addFirst("A"); // ͷ�巨
		System.out.println(List);
		System.out.println("-----------------");
		List.addinElePrev("E", "D");// ָ��ǰ����
		System.out.println(List);
		System.out.println("-----------------");
		List.addinEleNext("B", "C");// ָ�������
		System.out.println(List);
		System.out.println("-----------------");
		List.addByIndexPrev(0, "F");// ָ������ǰ
		System.out.println(List);
		System.out.println("-----------------");
		List.addByIndexNext(5, "F");// ָ��������
		System.out.println(List);
		System.out.println("-----------------");
		List.searchByEle("B");// ָ��Ԫ�ز�������
		System.out.println("-----------------");
		LinkedListNode.Node a = List.searchByElePrev("B");
		try {
			System.out.println("��Ԫ�ص�ǰ��Ϊ" + a.ele);
		} catch (NullPointerException e) {
			System.out.print("��Ԫ��Ϊͷ��㣬��ǰ��,�����޴�Ԫ��");
		}
		System.out.println("-----------------");

		LinkedListNode.Node b = List.searchByEleNext("B");
		try {
			System.out.println("��Ԫ�ص�ǰ��Ϊ" + b.ele);
		} catch (NullPointerException e) {
			System.out.print("��Ԫ��Ϊβ��㣬�޺���,�����޴�Ԫ��");
		}
		System.out.println("-----------------");

		LinkedListNode.Node c = List.searchByIndex(6);
		try {
			System.out.print("��������Ԫ��Ϊ" + c.ele);
		} catch (NullPointerException e) {
			System.out.print("����Խ��");
		}
		System.out.println("-----------------");

		LinkedListNode.Node d = List.searchByIndexPrev(0);
		try {
			System.out.println("��������Ԫ��Ϊ" + d.ele);
		} catch (NullPointerException e) {
			System.out.println("����Խ�����Ϊͷ���");
		}
		System.out.println("-----------------");

		LinkedListNode.Node f = List.searchByIndexNext(6);
		try {
			System.out.println("��������Ԫ��Ϊ" + f.ele);
		} catch (NullPointerException e) {
			System.out.println("����Խ��");
		}
		System.out.println("-----------------");
		List.deleteByEle("D");
		System.out.println(List);
		List.deleteByIndex(7);
		System.out.println(List);
		System.out.println("-----------------");
		List.updateByIndex(0, "R");
		System.out.println(List);
		List.updateByEle("R", "A");
		System.out.println(List);
		System.out.println("-----------------");
		System.out.println(List);
		List.cleanLinked();
		System.out.println(List);
		List.isempty();
		List.ReseverPrint();
	}

}
