import javax.swing.*;

public class Main {
	public static void main(String args[]) {
		Queue q = new Queue();
		Stack s = new Stack();
		List list = new List();
		
		Node p = null;
		byte[] a = {3, 3, 3, 4, 5, 5, 5 , 3, 4, 3, 4, 16, 25 , 9, 16, 25};


		for (int i = 0; i < a.length; i++) {
			if ((Math.sqrt(a[i]) % 0.5) == 0) {
				try {
					q.Insert(p, a[i]);
					s.Insert(s.head, a[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}


		System.out.print(" Queue: ");
		list.print(q.head);
		System.out.print(" Stack: ");
		list.print(s.head);
		
		byte k = 2;
		byte z = 16;
		try {
			if (q.AddOneElement(q.head, k, z))
				System.out.print("Добавление " + k + "-ого элемента в очередь после " + z + "-ого :");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		list.print(q.head);

		System.out.println("\nУдаление всех дубликатов Queue: ");

		try {
			q.DeleteDuplicateItems(q.head);
		} catch (Exception e) {
			e.printStackTrace();
		}

		list.print(q.head);
		System.out.println("\nКол-во элементов в Queue: " + list.Amount(q.head));
		
		
//		byte b = 1;
//
//		s.head = null;
//		q.head = null;
//
//		for (int i = 0; i < 10; i++) {
//			s.Insert(s.head, b);
//			q.Insert(q.head, b);
//			++b;
//		}
//
////
//		list.Print(q.head);
////
//
//		System.out.println();
//		list.Print(q.head);
//		

		

		
//		new Gui(s.head, q.head);
		
		
	}
}
