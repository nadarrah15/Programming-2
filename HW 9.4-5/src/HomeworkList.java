import java.util.Iterator;

import structure5.AbstractList;
import structure5.List;

public class HomeworkList<E> extends AbstractList<E>{

	public boolean equals(List<E> l){
		if(this.size() != l.size()){
			return false;
		}
		else{
			List<E> temp1 = this;
			List<E> temp2 = l;
			for(int i = 0; i < this.size(); i++){
				E tempA = this.removeFirst();
				E tempB = l.removeFirst();
				if(tempA != tempB)
					return false;
			}
			
			return true;
		}
	}
	
	public void splice(int index, List<E> other){
		for(int i = 0; i < other.size(); i++){
			this.add(index + i, other.get(i));
		}
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int i, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}