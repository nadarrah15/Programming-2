import structure5.DoublyLinkedList;
import structure5.SinglyLinkedList;

public class Main {
	
	static <E> void reverse(SinglyLinkedList<E> l){
		SinglyLinkedList<E> temp = new SinglyLinkedList<E>();
		
		for(int i = 0; i < l.size(); i++){
			E elem = l.removeLast();
			temp.add(elem);
		}
		
		l = temp;
	}
	
	static <E> void reverse(DoublyLinkedList<E> l){
		DoublyLinkedList<E> temp = new DoublyLinkedList<E>();
		
		for(int i = 0; i < l.size(); i++){
			E elem = l.removeLast();
			temp.add(elem);
		}
		
		l = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
