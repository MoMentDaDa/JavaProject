package Class_Package;

public class DataTypeClassInstanceDemo {
	public static void main(String[] args) {
		//8大基本数据类型Class实例
		Class booleanClass=boolean.class;
		Class intClass=int.class;
		//判断booleanClass和intClass是否相同，得出Integer和int是不同的数据类型
		System.out.println(intClass==booleanClass);//false
		System.out.println(booleanClass==Boolean.TYPE);//true
		System.out.println(Integer.class==int.class);//false
		System.out.println(Integer.TYPE==int.class);//true
		System.out.println("-------------------");
	/*	如何来表示数组的Class实例:
			方式1:数组类型.class
			方式2:数组对象.getClass();*/
		int[] arr1={1,2,3};
		int[][] arr2={}; 
		int[] arr3={0,2,4};
		String[] arr4={};
		Class arr2Class=int[].class;
		Class arr1Class=arr1.getClass();
		System.out.println(arr1Class); //class [I
		System.out.println(arr3.getClass());//class [I
		System.out.println(arr2.getClass());//class [[I
		System.out.println(arr1Class==arr2.getClass());//判断是否为同一份字节码文件false
		System.out.println(arr1Class==arr2Class);//true
		System.out.println(arr1Class==arr3.getClass());//true
		System.out.println(arr1Class==arr2.getClass());//false
		System.out.println(arr1Class==arr4.getClass());//false
		}  

	}

