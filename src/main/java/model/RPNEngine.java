package model;


class DivideByZeroException extends RuntimeException {
	private static final long serialVersionUID = 1L;
};

public class RPNEngine {
	ShortStack stack;
	
	RPNEngine() {
		stack = new ShortStack();
	}
	
	public void push(double value) {
		stack.push(value);
	}
	
	public double top() {
		return stack.x;
	}
	
	public double pop() {
		return stack.pop();
	}
	
	public void add() {
		double a = stack.pop();
		double b = stack.pop();
		
		stack.push(b+a);
	}
	
	public void subtract() {
		double a = stack.pop();
		double b = stack.pop();
		
		stack.push(b-a);
	}
	
	public void multiply() {
		double a = stack.pop();
		double b = stack.pop();
		
		stack.push(b*a);
	}
	
	public void divide() {
		double a = stack.pop();
		double b = stack.pop();
		
		if (a == 0) {
			throw new DivideByZeroException();
		}
		
		stack.push(b/a);
	}
	
	
	public void abs() {
		double a = stack.pop();
		
		
		stack.push(Math.abs(a));
	}
	
	
}
