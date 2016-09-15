package datastructure;

public class Main {
	public static void main(String args[]) {
		AnList<Integer> a = new AnList<Integer>(209);
		a.clear();
		for (int i = 0; i < 100; i++) {
			a.append((Integer)(i * 2));
		}
		
		printList(a);
		a.moveToPos(50);
		a.insert((Integer)(3333));
		printList(a);
		a.moveToPos(30);
		System.out.println(a.getValue());
		a.remove(0);
		printList(a);
		
		for(a.moveToStart(); a.currPos() < a.length(); a.next()) {
			a.remove();
		}
		printList(a);
		
	}
	
	public static void printList(AnList<Integer> a) {
		for (a.moveToStart(); a.currPos() < a.length(); a.next()) {
			System.out.print(a.getValue() + " ");	
		}
		System.out.println();
	}
}
