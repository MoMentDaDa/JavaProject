package MyStack;

import java.util.Arrays;

import ArrayModeDemo.PlayerList;

//基于数组的栈结构,即顺序栈,规定数组尾为栈底
public class MyStackDemo extends PlayerList{
	//入栈操作
	public void push(Object ele) {
		super.add(ele);
	}
	//出栈操作，即删除栈顶元素
	public void Pop() {
		DeleteByPlayersIndex(0);
	}
	//获得栈的元素数量
	public void getsize() {
		System.out.println("栈中元素有："+super.size+"个");
	};
	//获得栈顶元素
	public void getTop() {
		System.out.println("栈顶元素为"+super.get(0));
	}
	//清空栈中元素
	public void clean() {
		super.clear();
	}
	//判断非空
	public void isEmpty() {
		super.isEmpty();
	}
	//打印输出栈元素
	public String printf() {
		return super.toString();
	}
}
