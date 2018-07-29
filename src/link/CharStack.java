package link;

public class CharStack {	
	private CharNode top;
	
	public CharStack() {
		top = null;
	}
	public CharStack(CharNode top) {
		this.top = top;
	}
	public CharNode getTop() {
		return top;
	}
	public void setTop(CharNode top) {
		this.top = top;
	}
	public boolean isEmpty() {
		return top == null;
	}
	
	public boolean isFull() {
		return new CharNode() == null;		
	}
	public void push (char value) {
		if(isFull()) System.out.println("Link is Full...");
		top = new CharNode(value, top);
	}
	
	public char pop() {
		if(isEmpty()){
			System.out.println("List is Empty...");
			return '\0';
		}
		char c = top.getData();
		top = top.getLink();
		return c;
	}
}
