package Queue_JavaBook;

import java.util.*;

public class DequeTestDemo {

	public static void main(String[] args) {
//��������ʵ��˫����нṹ������ͷβ����ͷ
		Deque<String> queue =new ArrayDeque<>();
		queue.add("�϶�");//�����ĩβ���Ԫ��
		queue.addFirst("�ϴ�");//�����ͷ�����Ԫ��
		queue.addLast("����");//�����β�����Ԫ��
		queue.add("����");
		System.out.println(queue);//��ӡ�������
		queue.removeLast();//ɾ���������һ��Ԫ��
		System.out.println(queue);
		System.out.println("---------------------");
//����PriorityQueue��ʵ�����ȼ����У�����Ԫ�ؽ�������
		Queue<Integer> queue2=new PriorityQueue<>();
		queue2.add(67);
		queue2.add(12);
		queue2.add(33);
		System.out.println(queue2);
//һ�ΰ��ն���Ԫ�����ȼ�ɾ��Ԫ��
		while(!queue2.isEmpty()) {
			System.out.println(queue2.remove()+"  ");
			System.out.println(queue2);
		}
	}

}
