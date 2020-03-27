package Generic_JavaBook;

public class MethodTest {
//�������еķ���ֻ�����ڷǾ�̬������Ҫ����̬�������÷��ͣ�����Ϊ��̬���ͷ���
//���ͷ��� printArray()
	public static <E> void printArray(E[] array) {// l���Ͳ���E
		for (E element : array) {
			System.out.println(element);
		}
	}

// ���ͷ���max()
	public static <T extends Comparable<T>> T max(T x, T y) {// ����x,y ��ΪT����
		return x.compareTo(y) > 0 ? x : y;
	}

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		printArray(intArray);
		System.out.println();
		System.out.println(max(12, 24));

	}

}
