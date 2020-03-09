package model;

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
		
		stack.push(a+b);
	}
	
	
}
