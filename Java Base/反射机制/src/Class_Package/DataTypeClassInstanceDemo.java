package Class_Package;

public class DataTypeClassInstanceDemo {
	public static void main(String[] args) {
		//8�������������Classʵ��
		Class booleanClass=boolean.class;
		Class intClass=int.class;
		//�ж�booleanClass��intClass�Ƿ���ͬ���ó�Integer��int�ǲ�ͬ����������
		System.out.println(intClass==booleanClass);//false
		System.out.println(booleanClass==Boolean.TYPE);//true
		System.out.println(Integer.class==int.class);//false
		System.out.println(Integer.TYPE==int.class);//true
		System.out.println("-------------------");
	/*	�������ʾ�����Classʵ��:
			��ʽ1:��������.class
			��ʽ2:�������.getClass();*/
		int[] arr1={1,2,3};
		int[][] arr2={}; 
		int[] arr3={0,2,4};
		String[] arr4={};
		Class arr2Class=int[].class;
		Class arr1Class=arr1.getClass();
		System.out.println(arr1Class); //class [I
		System.out.println(arr3.getClass());//class [I
		System.out.println(arr2.getClass());//class [[I
		System.out.println(arr1Class==arr2.getClass());//�ж��Ƿ�Ϊͬһ���ֽ����ļ�false
		System.out.println(arr1Class==arr2Class);//true
		System.out.println(arr1Class==arr3.getClass());//true
		System.out.println(arr1Class==arr2.getClass());//false
		System.out.println(arr1Class==arr4.getClass());//false
		}  

	}

