package nine;

public class SortLinkedDriver {
	public static void main(String[] args) {
		SortedLinked sorted = new SortedLinked();
		System.out.println("========================================Testing all Functions with a Linked List================================================");
		sorted.insert(15);
		sorted.insert(14);
		sorted.insert(13);
		sorted.insert(12);
		sorted.insert(11);
		sorted.insert(10);
		sorted.insert(9);
		sorted.insert(100);
		sorted.display();
		System.out.println("Testing Delete Item" + sorted.delete(15));
		sorted.display();
		System.out.println("Testing Delete Item" + sorted.delete(9));
		sorted.display();
		System.out.println("Testing Delete Item" + sorted.delete(100));
		System.out.println("Testing Middle Item" + sorted.middleItem());
		sorted.display();
		System.out.println("========================================Testing a Middle Item================================================");
		sorted.clear();
		sorted.insert(15);
		sorted.insert(14);
		sorted.insert(13);
		sorted.insert(12);
		sorted.insert(11);
		sorted.insert(10);
		sorted.insert(9);
		sorted.insert(100);
		sorted.display();
		sorted.display();
		System.out.println("Testing Delete Item" + sorted.delete(9));
		sorted.display();
		System.out.println("Testing Delete Item" + sorted.delete(100));
		System.out.println("Testing Middle Item" + sorted.middleItem());
		sorted.clear();
		System.out.println("========================================Testing a short linked================================================");
		sorted.insert(15);
		sorted.insert(14);
		sorted.insert(13);
		sorted.insert(12);
		System.out.println("Testing Delete Item" + sorted.delete(15));
		System.out.println("Testing Delete Item" + sorted.delete(13));
		System.out.println("Testing Middle Item" + sorted.middleItem());
	}
}
