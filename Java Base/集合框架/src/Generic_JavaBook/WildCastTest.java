package Generic_JavaBook;

import java.util.*;
import java.util.List;

public class WildCastTest {

	public static void main(String[] args) throws Exception {
		List<Integer> listInteger = new ArrayList<Integer>();
		listInteger.add(11);
		//print(listInteger);  ����������������ͣ�
		printNew(listInteger);//��Ϊcollection<?>��ʾͨ��������Կ��Դ��ݸ�����
	}

	public static void print(Collection<Object> collection) {
		for (Object obj : collection) {
			System.err.println(obj);
		}
	}

	public static void printNew(Collection<?> collection) {
		//ͨ�����������extends��super���ã������������޺�����   Tree<?extends ����1>x=new TreeSet<����2>();���ͱ�ʾ�ض����ͣ�����2λ���������������1
		for (Object obj : collection) {
			System.err.println(obj);
		}
	}

}
