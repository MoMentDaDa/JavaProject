package Generic_JavaBook;

import java.util.*;

public class LimitBag<T extends Number> {
//����extends�������Ͳ�������������
	private T content;

	public LimitBag(T content) {
		this.content = content;
	}

	private void set() {
		this.content = content;

	}

	private T get(T content) {
		return this.content;

	}

	public static void main(String[] args) {	
		LimitBag<Integer> bag2 = new LimitBag<Integer>(12);//�Ϸ�����Ϊ�̳е���Number������T����Ϊָ����������ࡣ��Ϊ�ӿ�������Ϊָ���ӿڵ�ʵ����
		//���Ϸ�����ΪList����Number������
		//Limit<List> bag1 = new LimitBag<List>(new ArrayList());

	}

}
