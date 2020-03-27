package LinkedListPackage;

public class LinkedListTestDemo {

	public static void main(String[] args) {
		LinkedListNode List = new LinkedListNode();
		List.isempty();// 判断非空
		List.addLast("B");// 尾插法
		List.addLast("E");
		System.out.println(List);// 打印输出
		List.isempty();
		List.addFirst("A"); // 头插法
		System.out.println(List);
		System.out.println("-----------------");
		List.addinElePrev("E", "D");// 指定前插入
		System.out.println(List);
		System.out.println("-----------------");
		List.addinEleNext("B", "C");// 指定后插入
		System.out.println(List);
		System.out.println("-----------------");
		List.addByIndexPrev(0, "F");// 指定索引前
		System.out.println(List);
		System.out.println("-----------------");
		List.addByIndexNext(5, "F");// 指定索引后
		System.out.println(List);
		System.out.println("-----------------");
		List.searchByEle("B");// 指定元素查找索引
		System.out.println("-----------------");
		LinkedListNode.Node a = List.searchByElePrev("B");
		try {
			System.out.println("该元素的前驱为" + a.ele);
		} catch (NullPointerException e) {
			System.out.print("该元素为头结点，无前驱,或者无此元素");
		}
		System.out.println("-----------------");

		LinkedListNode.Node b = List.searchByEleNext("B");
		try {
			System.out.println("该元素的前驱为" + b.ele);
		} catch (NullPointerException e) {
			System.out.print("该元素为尾结点，无后驱,或者无此元素");
		}
		System.out.println("-----------------");

		LinkedListNode.Node c = List.searchByIndex(6);
		try {
			System.out.print("该索引的元素为" + c.ele);
		} catch (NullPointerException e) {
			System.out.print("索引越界");
		}
		System.out.println("-----------------");

		LinkedListNode.Node d = List.searchByIndexPrev(0);
		try {
			System.out.println("该索引的元素为" + d.ele);
		} catch (NullPointerException e) {
			System.out.println("索引越界或者为头结点");
		}
		System.out.println("-----------------");

		LinkedListNode.Node f = List.searchByIndexNext(6);
		try {
			System.out.println("该索引的元素为" + f.ele);
		} catch (NullPointerException e) {
			System.out.println("索引越界");
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
