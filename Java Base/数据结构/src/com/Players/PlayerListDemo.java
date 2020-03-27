package com.Players;

import java.util.Arrays;

public class PlayerListDemo {
	// 存储上场球员的球衣号码
	private static Integer[] players = null;
	// 场上球员个数
	private static int size = 0;

	// 1、初始容量为s的线性列表，用于存储上的5个球衣号码
	public static void init(int intialCapacity) {
		if (intialCapacity < 0) {
			throw new IllegalArgumentException("容量不能为0");
		}
		players = new Integer[intialCapacity];
	}

	// 2、安排5个球员上场：[11、22、33、44、55]
	public static void add(Integer PlayerNum) {
		// players数组自动扩容
		if (size == players.length) {
			Integer[] temp = Arrays.copyOf(players, players.length * 2);
			players = temp;
		}
		players[size] = PlayerNum;
		size++;
	}

	// 3、查询指定位置的球员的球衣号码是多少，查询索引位置为2的球衣号码是：33
	public static Integer get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		return players[index];
	}

	// 4、根据球衣查询该球员在球场上的索引位置，44球衣号的球员在场上的索引位置是：3
	public static int getIndexByPlayerNum(Integer PlayerNum) {
		for (int index = 0; index < size; index++) {
			if (players[index].equals(PlayerNum)) {
				return index;
			}
		}
		return -1;
	}

	// 5、替换场上索引位置为2的球员，替换后该位置的球衣编号为333，333替换了33
	public static void replace(int index, Integer newPlayerNum) {
		players[index] = newPlayerNum;
		System.out.print("替换后的球员为：");
		print();
	}

	// 6、替换球衣号码为22的球员，替换后为222
	public static void ReplaceByPlayersNum(int PlayersNum, Integer NewPlayers) {

		// for (int index = 0; index < size; index++) {
		// if (players[index].equals(PlayersNum)) {
		// players[index] = NewPlayers;
		// } else {
		// continue;
		// }
		// }
		// System.out.print("替换后的球员为：");
		// print();

		int index = getIndexByPlayerNum(PlayersNum);
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		if (index >= 0) {
			replace(index, NewPlayers);
		}
	}

	// 7、把场上索引为3的球员罚下场，而且没有补位
	public static void DeleteByPlayersIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		for (int i = index; i < size - 1; i++) {
			players[i] = players[i + 1];
		}
		players[size - 1] = null;
		size--;
		System.out.print("剩下的场上球员为：");
		print();
	}

	// 8、按照球员在场上的位置，打印出球衣号码，打印风格：[11,22,33,44,55]
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
