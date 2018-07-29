package link;

public class ExpressionTree {
	private ExpressionStack nums;
	
	public ExpressionTree(){
		nums = new ExpressionStack();
	}
	
	public double calculateExpression(Queue data){
		while(data.getFront() != null){
			String d = data.dequeue();
			
			if(isNumeric(d)){
				nums.push(Double.parseDouble(d));
			}else if(isSign(d)){
				double first = nums.pop();
				double second = nums.pop();
				//The first number popped has to be the second argument in calculateSubTree
				nums.push(calculateSubTree(second, first, d));
			}
		}
		System.out.println();
		return nums.pop();
	}
	
	public boolean isSign(String s){
		return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
	}
	
	public boolean isNumeric(String n){
		int i = n.length() > 1 && n.toCharArray()[0] == '-' ? 1 : 0;
		return Character.isDigit(n.toCharArray()[i]);
	}
	
	private double calculateSubTree(double o1, double o2, String operator){
		switch(operator){
		case "*": return o1 * o2;
		case "/": return o1 / o2;
		case "+": return o1 + o2;
		case "-": return o1 - o2;
		default: return o2;
		}
	}
}
