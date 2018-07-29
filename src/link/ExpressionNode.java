package link;

public class ExpressionNode {
	private double operand;
	private ExpressionNode link;
	
	public ExpressionNode(){
		operand = 0.0;
		link = null;
	}

	public ExpressionNode(double operand, ExpressionNode link) {
		super();
		this.operand = operand;
		this.link = link;
	}

	public ExpressionNode(double operand) {
		super();
		this.operand = operand;
	}

	public double getOperand() {
		return operand;
	}

	public void setOperand(double operand) {
		this.operand = operand;
	}

	public ExpressionNode getLink() {
		return link;
	}

	public void setLink(ExpressionNode link) {
		this.link = link;
	}
}
