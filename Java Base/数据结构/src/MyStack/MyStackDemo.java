package MyStack;

import java.util.Arrays;

import ArrayModeDemo.PlayerList;

//���������ջ�ṹ,��˳��ջ,�涨����βΪջ��
public class MyStackDemo extends PlayerList{
	//��ջ����
	public void push(Object ele) {
		super.add(ele);
	}
	//��ջ��������ɾ��ջ��Ԫ��
	public void Pop() {
		DeleteByPlayersIndex(0);
	}
	//���ջ��Ԫ������
	public void getsize() {
		System.out.println("ջ��Ԫ���У�"+super.size+"��");
	};
	//���ջ��Ԫ��
	public void getTop() {
		System.out.println("ջ��Ԫ��Ϊ"+super.get(0));
	}
	//���ջ��Ԫ��
	public void clean() {
		super.clear();
	}
	//�жϷǿ�
	public void isEmpty() {
		super.isEmpty();
	}
	//��ӡ���ջԪ��
	public String printf() {
		return super.toString();
	}
}
