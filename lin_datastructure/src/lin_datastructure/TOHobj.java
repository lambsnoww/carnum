package lin_datastructure;

import java.util.Scanner;

class Item {
	public int num;
	public int from;
	public int to;
	public int mid;
	
	Item(int n, int a, int b, int c) {
		num = n;
		from = a;
		to = b;
		mid = c;
	}
	
}

class TOHobj {

	
	public static void main(String args[]) {
		
		LStack<Item> s = new LStack<Item>();
		s.clear();
		int n;
		System.out.println("Please enter the number of plates: ");
		Scanner in = new Scanner(System.in);
		n = Integer.parseInt(in.next());
		
		Item i = new Item(n, 1, 3, 2);
		s.push(i);
		while (true) {
			if (s.length() == 0)
				break;
			Item it = s.pop();
			if (it.num == 1)
				printOut(it);
			else {
				s.push(new Item(it.num - 1, it.mid, it.to, it.from));
				s.push(new Item(1, it.from, it.to, it.mid));
				s.push(new Item(it.num - 1, it.from, it.mid, it.to));
			}
		}
	}
	public static void printOut(Item i) {
		System.out.println(i.from + " -> " + i.to);
	}
}
