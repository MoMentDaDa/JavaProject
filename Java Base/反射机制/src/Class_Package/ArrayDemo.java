package Class_Package;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] src=new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] des=new int[10];
		System.out.println(Arrays.toString(des));
		arrayCopy(src,3,des,2,5);
		System.out.println(Arrays.toString(des));
	}

	private static void arrayCopy(Object src, int srcPose, Object des, int desPose, int length) {
		if(src==null||des==null){
			throw new NullPointerException("原数组或目标数组为空");
		}
		if(!src.getClass().isArray()||!des.getClass().isArray()){
			throw new ArrayStoreException("源和目标必须为数组");
		}
		if(srcPose<0||desPose<0||srcPose+length>Array.getLength(src)||desPose+length>Array.getLength(des)){
			throw new IndexOutOfBoundsException("索引越界");
		}
		if(src.getClass().getComponentType()!=des.getClass().getComponentType()){
			throw new ArrayStoreException("数组类型不一致");
		}
		
		//拷贝数组
		for(int index=srcPose;index<srcPose+length;index++){
			Object val=Array.get(src, index);
			Array.set(des, desPose, val);
			desPose++;
		}
	}

}
