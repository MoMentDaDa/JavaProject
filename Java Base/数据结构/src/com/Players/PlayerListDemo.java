package com.Players;

import java.util.Arrays;

public class PlayerListDemo {
	// �洢�ϳ���Ա�����º���
	private static Integer[] players = null;
	// ������Ա����
	private static int size = 0;

	// 1����ʼ����Ϊs�������б����ڴ洢�ϵ�5�����º���
	public static void init(int intialCapacity) {
		if (intialCapacity < 0) {
			throw new IllegalArgumentException("��������Ϊ0");
		}
		players = new Integer[intialCapacity];
	}

	// 2������5����Ա�ϳ���[11��22��33��44��55]
	public static void add(Integer PlayerNum) {
		// players�����Զ�����
		if (size == players.length) {
			Integer[] temp = Arrays.copyOf(players, players.length * 2);
			players = temp;
		}
		players[size] = PlayerNum;
		size++;
	}

	// 3����ѯָ��λ�õ���Ա�����º����Ƕ��٣���ѯ����λ��Ϊ2�����º����ǣ�33
	public static Integer get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		return players[index];
	}

	// 4���������²�ѯ����Ա�����ϵ�����λ�ã�44���ºŵ���Ա�ڳ��ϵ�����λ���ǣ�3
	public static int getIndexByPlayerNum(Integer PlayerNum) {
		for (int index = 0; index < size; index++) {
			if (players[index].equals(PlayerNum)) {
				return index;
			}
		}
		return -1;
	}

	// 5���滻��������λ��Ϊ2����Ա���滻���λ�õ����±��Ϊ333��333�滻��33
	public static void replace(int index, Integer newPlayerNum) {
		players[index] = newPlayerNum;
		System.out.print("�滻�����ԱΪ��");
		print();
	}

	// 6���滻���º���Ϊ22����Ա���滻��Ϊ222
	public static void ReplaceByPlayersNum(int PlayersNum, Integer NewPlayers) {

		// for (int index = 0; index < size; index++) {
		// if (players[index].equals(PlayersNum)) {
		// players[index] = NewPlayers;
		// } else {
		// continue;
		// }
		// }
		// System.out.print("�滻�����ԱΪ��");
		// print();

		int index = getIndexByPlayerNum(PlayersNum);
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		if (index >= 0) {
			replace(index, NewPlayers);
		}
	}

	// 7���ѳ�������Ϊ3����Ա���³�������û�в�λ
	public static void DeleteByPlayersIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("����Խ��");
		}
		for (int i = index; i < size - 1; i++) {
			players[i] = players[i + 1];
		}
		players[size - 1] = null;
		size--;
		System.out.print("ʣ�µĳ�����ԱΪ��");
		print();
	}

	// 8��������Ա�ڳ��ϵ�λ�ã���ӡ�����º��룬��ӡ���[11,22,33,44,55]
	public static void print() {
		if (players == null) {
			System.out.println("null");
			return;
		}
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		StringBuilder sb = new StringBuilder(size * 2 + 1);
		sb.append("[");
		for (int index = 0; index < size; index++) {
			sb.append(players[index]);
			if (index != size - 1) {
				sb.append(",");
			} else {
				sb.append("]");
			}
		}
		System.out.println(sb.toString());
	}
}
