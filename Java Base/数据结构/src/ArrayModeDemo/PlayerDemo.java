package ArrayModeDemo;

public class PlayerDemo {

	public static void main(String[] args) {
		PlayerList List = new PlayerList();
		List.isEmpty();
		List.add(1);
		List.add(2);
		List.add(3);
		List.add('a');
		List.add('A');
		List.add("true");
		System.out.println(List);
		List.isEmpty();
	}

}
