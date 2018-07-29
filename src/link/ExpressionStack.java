package link;

public class ExpressionStack {
	private ExpressionNode top;
	
	public ExpressionStack(){
		top = null;
	}

	public boolean isEmpty(){
		return top == null;
	}
	
	public boolean isFull(){
		return new ExpressionNode() == null;
	}
	
	public void push(double e){
		if(isFull()) throw new StackOverflowError("The stack is full");
		top = new ExpressionNode(e, top);
	}
	
	public double pop(){
		if(isEmpty()) return 0.0;
		
		double temp = top.getOperand();
		top = top.getLink();
		return temp;
	}	
}
