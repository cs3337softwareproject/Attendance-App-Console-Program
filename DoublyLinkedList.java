package cardReader;



class DoubleNode<E>{
	private E value;
	private DoubleNode<E> prev;
	private DoubleNode<E> next;

	DoubleNode( E value){
		this.value = value;
	}

	DoubleNode(E value, DoubleNode<E> prev, DoubleNode<E> next){
		this.value = value;
		setPrev(prev);
		setNext(next);
	}


	DoubleNode<E> getPrev(){
		return prev;
	}

	DoubleNode<E> getNext(){
		return next;
	}

	void setPrev(DoubleNode<E> prev){
		this.prev = prev;
	}

	void setNext(DoubleNode<E> next){
		this.next = next;
	}


	E getValue(){
		return value;
	}


}

public class DoublyLinkedList<E> {

	private DoubleNode<E> head = new DoubleNode<E>(null);
	private DoubleNode<E> tail = new DoubleNode<E>(null);  
	private int size = 0;

	public DoublyLinkedList(){
		head.setPrev(null);
		head.setNext(tail);
		tail.setPrev(head);
		tail.setNext(null);
	}


	public int size(){
		return size;
	}


	public boolean isEmpty(){
		return size == 0;
	}

	private DoubleNode<E> getNode(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			DoubleNode<E> node = head;
			for (int i = 0; i < index; i++){
				node = node.getNext();
			}
			return node;

		}
	}

	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}else{
			DoubleNode<E> node = head;
			for (int i = 0; i <= index; i++){
				node = node.getNext();
			}
			return node.getValue();
		}
	}
	public void add(E value) {
		DoubleNode<E> node = tail.getPrev();
		DoubleNode<E> newNode = new DoubleNode<E>(value);
		newNode.setPrev(node);
		newNode.setNext(node.getNext());
		node.getNext().setPrev(newNode);;
		node.setNext(newNode);;
		size++;



	}


	public void add(int index, E value) throws IndexOutOfBoundsException {
		DoubleNode<E> node = getNode(index);
		DoubleNode<E> newNode = new DoubleNode<E>(value);
		newNode.setPrev(node);
		newNode.setNext(node.getNext());
		node.getNext().setPrev(newNode);
		node.setNext(newNode);;
		size++;


	}



	public E remove(int index) throws IndexOutOfBoundsException{
		DoubleNode<E> result = getNode(index + 1);
		result.getNext().setPrev(result.getPrev());
		result.getPrev().setNext(result.getNext());
		size--;
		return result.getValue();
	}







}
