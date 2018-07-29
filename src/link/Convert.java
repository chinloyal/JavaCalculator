package link;

public class Convert {
	private final static int MULTIPLY = 2;
	private final static int DIVIDE = 2;
	private final static int PLUS = 1;
	private final static int MINUS = 1;
	
	public Queue convertToPostfixQueue(StringBuilder infixEXP) {
		CharStack stack = new CharStack();
		StringBuilder postfix = new StringBuilder("");
		Queue postfixQueue = new Queue();
		
		for (int i = 0; i < (infixEXP.length()); i++) {
			switch (infixEXP.charAt(i)) {
			case '0':case '1':case '2':
			case '3':case '4':case '5':
			case '6':case '7':case '8':
			case '9':case '.':
				postfix.append(infixEXP.charAt(i));
				break;
			case '+':case '*':
			case '-':case '/':
				if(postfix.length() > 0){
					postfixQueue.enqueue(postfix.toString());
					postfix = new StringBuilder();
				}
				if ((!stack.isEmpty())) {
					if(stack.getTop().getData() == '('){
						stack.push(infixEXP.charAt(i));
						break;
					}
						
					if(precedence(stack.getTop().getData()) >= precedence(infixEXP.charAt(i))){
						while((!stack.isEmpty())){
							if(precedence(stack.getTop().getData()) >= precedence(infixEXP.charAt(i))
							&& infixEXP.charAt(i) != '(')
								postfixQueue.enqueue(String.valueOf(stack.pop()));
							else
								break;
						}
						stack.push(infixEXP.charAt(i));
						
					}else{
						stack.push(infixEXP.charAt(i));
					}
				} else {
					stack.push(infixEXP.charAt(i));
				}

				break;
			case '(':
				stack.push(infixEXP.charAt(i));
				break;
			case ')':
				if(postfix.length() > 0){
					postfixQueue.enqueue(postfix.toString());
					postfix = new StringBuilder();
				}
				while(stack.getTop().getData() != '('){
					if(stack.getTop().getData() == '(')
						break;
					postfixQueue.enqueue(String.valueOf(stack.pop()));
				}
				stack.pop();
				break;
			}

		}
		if(postfix.length() > 0){
			postfixQueue.enqueue(postfix.toString());
			postfix = new StringBuilder();
		}
		while ((!stack.isEmpty())) {
			postfixQueue.enqueue(String.valueOf(stack.pop()));
		}
		return postfixQueue;
	}

	public int precedence(char sign) {
		switch(sign){
		case '(' : return 5;
		case '*': return MULTIPLY;
		case '/': return DIVIDE;
		case '+': return PLUS;
		case '-': return MINUS;
		default: return 0;
		}
	}
	
	public boolean isSign(String s) {
		return (s.equals("+")|| s.equals("*")||s.equals("-")||s.equals("/"));
	}
	public boolean isNumeric(String n) {
		return Character.isDigit(n.toCharArray()[0]);
	}	
} 
