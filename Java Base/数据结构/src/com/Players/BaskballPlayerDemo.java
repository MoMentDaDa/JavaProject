package com.Players;

import java.util.Arrays;

//安排篮球运动员上场
public class BaskballPlayerDemo {
	public static void main(String[] args) {
		// 1):初始化容量为5的线性列表
		PlayerListDemo.init(5);
		// 2）:安排5个球员上场
		PlayerListDemo.add(11);
		PlayerListDemo.add(22);
		PlayerListDemo.add(33);
		PlayerListDemo.add(44);
		PlayerListDemo.add(55);
		PlayerListDemo.add(66);
		PlayerListDemo.print();
		// 查询索引位置为2的球衣号码是：33
		// Integer a=get(2);
		// System.out.println("索引为2的球衣号码为"+a);

		// 44球衣号的球员在场上的索引位置是：3
		// int b=getIndexByPlayerNum(44);
		// System.out.println("44球员的索引为"+b);

		// 把索引为2的球员替换为333
		// replace(2,333);

		// 替换球衣号码为22的球员，替换后为222
		// ReplaceByPlayersNum(22, 222);

		// 7、把场上索引为3的球员罚下场，而且没有补位
		PlayerListDemo.DeleteByPlayersIndex(3);
	}

}
