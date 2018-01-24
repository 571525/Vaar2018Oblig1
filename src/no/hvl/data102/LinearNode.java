package no.hvl.data102;

public class LinearNode <T>{
	
	private LinearNode<T> next;
	private T element;
	
	//oppretter en tom node
	
	public LinearNode() {
		next = null;
		element = null;
	}
	
	//oppretter node med et element
	
	public LinearNode(T elem) {
		next = null;
		element = elem;
	}
	
	//returnerer neste
	
	public LinearNode<T> getNext(){
		return next;
	}
	
	//Setter neste som node
	
	public void setNext(LinearNode<T> node) {
		next = node;
	}
	
	//elementet blir returnert til noden
	
	public T getElement() {
		return element;
	}
	
	//Setter nytt element i noden
	
	public void setElement(T elem) {
		element = elem;
	}
	
}
