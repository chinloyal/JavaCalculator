package link;

public class Stack {
	private Node top;
	
	public Stack(){
		top = null;
	}
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public boolean isFull(){
		return (new Node() == null);
	}
	
	public Node getTop(){
		return top;
	}
	
	public void push(Flag data){
		if(isFull()) System.out.println("The stack is full");
		 top = new Node(data, top);
	}
	
	public Flag pop(){
		if(isEmpty()) return null;
		
		Flag temp = top.getData();
		top = top.getLink();
		return temp;
	}
	
	public void destroy() {
		while(pop() != null);
	}
}
