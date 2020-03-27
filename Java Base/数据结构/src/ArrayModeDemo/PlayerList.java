package ArrayModeDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayerList {
	// ����������������
	private static Object[] player = null;
	// �����д洢��Ԫ��
	public  static int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	// Ĭ�Ϲ�����
	public PlayerList() {
		this(10);
	}	
	// �����ʼ������
	public PlayerList(int intialCapacity) {
		if (intialCapacity < 0) {
			throw new IllegalArgumentException("��������Ϊ0");
		}
		player = new Object[intialCapacity];
	}
	// 2�������Ա
	public void add(Object ele) {
		// players�����Զ�����
		if (size == player.length) {
			Object[] temp = Arrays.copyOf(player, player.length * 2);
			player = temp;
		}
		if(size==0) {
			player[size]=ele;
			size++;
		}else {
			size++;	
			player[size-1] = null;	
			int a=(size-1);	//1	
			int b=(size-2);//0
			System.out.println(b);
			while(b>0) {
				player[a]=player[b];
				b--;
				a--;
				}
			player[0]=ele;	
		}
		
	}

	// 3����ѯָ������λ�õ�Ԫ��
	public static Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		return player[index];
	}

	// 4����ѯ����λ��
	public static Object getIndexByPlayerNum(Object PlayerNum) {
		for (int index = 0; index < size; index++) {
			if (player[index].equals(PlayerNum)) {
				return index;
			}
		}
		return -1;
	}

	// 5���滻ָ������λ�õ�Ԫ��ֵ
	public static void replace(int index, Object newPlayerNum) {
		if (index < 0 || index >= player.length) {
			throw new IllegalArgumentException("����Խ��");
		}
		player[index] = newPlayerNum;
		System.out.print("�滻�����ԱΪ��");
		player.toString();
	}

	// 6���滻ָ��Ԫ�ص�Ԫ��
	public static void ReplaceByPlayersNum(Object PlayerNum, Object NewPlayers) {

		// for (int index = 0; index < size; index++) {
		// if (players[index].equals(PlayersNum)) {
		// players[index] = NewPlayers;
		// } else {
		// continue;
		// }
		// }
		// System.out.print("�滻�����ԱΪ��");
		// print();

		Object index = getIndexByPlayerNum(PlayerNum);
		int a = Integer.parseInt((String) index);
		if (a < 0 || a >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		if (a >= 0) {
			replace(a, NewPlayers);
		}
	}

	// 7��ɾ��ָ������λ�õ�Ԫ��
	public static void DeleteByPlayersIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		for (int i = index; i < size - 1; i++) {
			player[i] = player[i + 1];
		}
		player[size - 1] = null;
		size--;
		System.out.print("ʣ�µĳ�����ԱΪ��");
		player.toString();
	}

	// 8����ӡ�������Ԫ��
	public String toString() {
		if (player == null) {
			return "null";
		}
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder(size * 2 + 1);
		sb.append("[");
		for (int index = 0; index < size; index++) {
			sb.append(player[index]);
			if (index != size - 1) {
				sb.append(",");
			} else {
				sb.append("]");
			}
		}
		return sb.toString();
	}

	// ���������Ԫ�ظ���
	public void isEmpty() {
		if (size == 0)
			System.out.println("Ϊ��");
		else
			System.out.println("��Ϊ��");
	}

	// �������
	public void clear() {
		this.player = new Object[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}
	//��ת����
}
