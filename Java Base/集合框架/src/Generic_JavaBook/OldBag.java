package Generic_JavaBook;

public class OldBag<T> {

//�޷���֮ǰʾ��
	/*
	 * private Object content;
	 * 
	 * public OldBag(Object content) { this.content = content; }
	 * 
	 * public Object get() { return this.content; }
	 * 
	 * public void set(Object content) { this.content = content; }
	 * 
	 * public static void main(String[] args) { OldBag bag = new OldBag("maybook");
	 * Object content = (Integer)
	 * bag.get();//OldBag����ΪString���ͣ�ǿתΪInteger�׳�java.lang.ClassCastException }
	 */

//���Ͷ����ʹ��
	private T content;// ��content����Ϊ����,TΪ���Ͳ�����������ָcontentʵ����������

	public OldBag(T content) {
		this.content = (T) content;
	}

	public T get() {
		return this.content;
	}

	public void set(T content) {
		this.content = content;
	}

	public static void main(String[] args) {
		OldBag<String> bag = new OldBag<String>("maybook");// ��OldBag����ΪString����
		String content2 = bag.get();
		System.out.println(content2);
		// OldBag����ΪString���ͣ�Integer���ܲ����׳�java.lang.ClassCastException�����ǲ��Ϸ�
		//Integer content1 = bag.get();
	}

}
