package ArrayModeDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlayerList {
	// 创建任意类型数组
	private static Object[] player = null;
	// 数组中存储的元素
	public  static int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	// 默认构造器
	public PlayerList() {
		this(10);
	}	
	// 构造初始化数组
	public PlayerList(int intialCapacity) {
		if (intialCapacity < 0) {
			throw new IllegalArgumentException("容量不能为0");
		}
		player = new Object[intialCapacity];
	}
	// 2、添加球员
	public void add(Object ele) {
		// players数组自动扩容
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

	// 3、查询指定索引位置的元素
	public static Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		return player[index];
	}

	// 4、查询索引位置
	public static Object getIndexByPlayerNum(Object PlayerNum) {
		for (int index = 0; index < size; index++) {
			if (player[index].equals(PlayerNum)) {
				return index;
			}
		}
		return -1;
	}

	// 5、替换指定索引位置的元素值
	public static void replace(int index, Object newPlayerNum) {
		if (index < 0 || index >= player.length) {
			throw new IllegalArgumentException("索引越界");
		}
		player[index] = newPlayerNum;
		System.out.print("替换后的球员为：");
		player.toString();
	}

	// 6、替换指定元素的元素
	public static void ReplaceByPlayersNum(Object PlayerNum, Object NewPlayers) {

		// for (int index = 0; index < size; index++) {
		// if (players[index].equals(PlayersNum)) {
		// players[index] = NewPlayers;
		// } else {
		// continue;
		// }
		// }
		// System.out.print("替换后的球员为：");
		// print();

		Object index = getIndexByPlayerNum(PlayerNum);
		int a = Integer.parseInt((String) index);
		if (a < 0 || a >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		if (a >= 0) {
			replace(a, NewPlayers);
		}
	}

	// 7、删除指定索引位置的元素
	public static void DeleteByPlayersIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("索引越界");
		}
		for (int i = index; i < size - 1; i++) {
			player[i] = player[i + 1];
		}
		player[size - 1] = null;
		size--;
		System.out.print("剩下的场上球员为：");
		player.toString();
	}

	// 8、打印输出数组元素
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

	// 返回数组的元素个数
	public void isEmpty() {
		if (size == 0)
			System.out.println("为空");
		else
			System.out.println("不为空");
	}

	// 清除数组
	public void clear() {
		this.player = new Object[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}
	//反转数组
}
