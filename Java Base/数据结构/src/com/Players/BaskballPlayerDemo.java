package com.Players;

import java.util.Arrays;

//���������˶�Ա�ϳ�
public class BaskballPlayerDemo {
	public static void main(String[] args) {
		// 1):��ʼ������Ϊ5�������б�
		PlayerListDemo.init(5);
		// 2��:����5����Ա�ϳ�
		PlayerListDemo.add(11);
		PlayerListDemo.add(22);
		PlayerListDemo.add(33);
		PlayerListDemo.add(44);
		PlayerListDemo.add(55);
		PlayerListDemo.add(66);
		PlayerListDemo.print();
		// ��ѯ����λ��Ϊ2�����º����ǣ�33
		// Integer a=get(2);
		// System.out.println("����Ϊ2�����º���Ϊ"+a);

		// 44���ºŵ���Ա�ڳ��ϵ�����λ���ǣ�3
		// int b=getIndexByPlayerNum(44);
		// System.out.println("44��Ա������Ϊ"+b);

		// ������Ϊ2����Ա�滻Ϊ333
		// replace(2,333);

		// �滻���º���Ϊ22����Ա���滻��Ϊ222
		// ReplaceByPlayersNum(22, 222);

		// 7���ѳ�������Ϊ3����Ա���³�������û�в�λ
		PlayerListDemo.DeleteByPlayersIndex(3);
	}

}
