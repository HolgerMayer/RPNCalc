package model;


class DivideByZeroException extends RuntimeException {
	private static final long serialVersionUID = 1L;
};

class SquareRootFromNegativeNumberException extends RuntimeException {
	private static final long serialVersionUID = 2L;
};

class LogFromNegativeNumberException extends RuntimeException {
	private static final long serialVersionUID = 2L;
};

class Log10FromNegativeNumberException extends RuntimeException {
	private static final long serialVersionUID = 2L;
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
	
	
	public void pow() {
		double exponent = stack.pop();
		double base = stack.pop();
		
		stack.push(Math.pow(base, exponent));
	}
	
	
	public void sqrt() {
		double a = stack.pop();
		
		if (a < 0) {
			throw new SquareRootFromNegativeNumberException();
		}
		
		
		stack.push(Math.sqrt(a));
	}
	
	public void log() {
		double a = stack.pop();
		
		if (a == 0) {
			throw new LogFromNegativeNumberException();
		}
		
		
		stack.push(Math.log(a));
	}
	
	public void log10() {
		double a = stack.pop();
		
		if (a == 0) {
			throw new Log10FromNegativeNumberException();
		}
		
		
		stack.push(Math.log10(a));
	}
	
	public void hmmssToDecDegreeConversion() {
		
		double a = stack.pop();
		
		int hours = (int) a;
		int minutes = (int)(( a-  (double) hours ) * 100); 
		double  seconds = ( a - (double) hours) * 100 - ((double) minutes * 100);
		
		double result = (double) hours + (double) minutes / 60 + seconds / 3600;
		
		stack.push(result);
	}
	
	
	public void decDegreeToHMMSSConversion() {
		double a = stack.pop();
		
		int hours = (int) a;
		int minutes = (int)((a - (double) hours) / 60) *3600;
		double seconds = (a - (double) hours) - ((double) minutes) / 60.0 * 3600;
		
		double result = (double) hours + (double) minutes / 100 + seconds / 10000;
		
		stack.push(result);

	}
	
}
