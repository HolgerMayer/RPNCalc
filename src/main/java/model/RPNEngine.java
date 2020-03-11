package model;


class DivideByZeroException extends RuntimeException {
	private static final long serialVersionUID = 1L;
};

class SquareRootFromNegativeNumberException extends RuntimeException {
	private static final long serialVersionUID = 2L;
};

class LogFromZeroException extends RuntimeException {
	private static final long serialVersionUID = 3L;
};

class Log10FromZeroException extends RuntimeException {
	private static final long serialVersionUID = 4L;
};


enum TrigonometricMode {
	DEG,RAD,GRAD
}

public class RPNEngine {

	TrigonometricMode trigonometricMode = TrigonometricMode.RAD;
	
	private ShortStack stack;
	
	RPNEngine() {
		stack = new ShortStack();
	}
	
	public void push(double value) {
		stack.push(value);
	}
	
	public double getTop() {
		return stack.getX();
	}
	
	public double getLastX() {
		return stack.getLastX();
	}
	
	public double pop() {
		return stack.pop();
	}
	
	public void add() {
		double a = stack.saveToLastXAndPop();
		double b = stack.pop();
		
		stack.push(b+a);
	}
	
	public void subtract() {
		double a = stack.saveToLastXAndPop();
		double b = stack.pop();
		
		stack.push(b-a);
	}
	
	public void multiply() {
		double a = stack.saveToLastXAndPop();
		double b = stack.pop();
		
		stack.push(b*a);
	}
	
	public void divide() {
		double a = stack.saveToLastXAndPop();
		double b = stack.pop();
		
		if (a == 0) {
			throw new DivideByZeroException();
		}
		
		stack.push(b/a);
	}
	
	
	public void abs() {
		double a = stack.saveToLastXAndPop();
		
		
		stack.push(Math.abs(a));
	}
	
	
	public void pow() {
		double exponent = stack.saveToLastXAndPop();
		double base = stack.pop();
		
		stack.push(Math.pow(base, exponent));
	}
	
	
	public void sqrt() {
		double a = stack.saveToLastXAndPop();
		
		if (a < 0) {
			throw new SquareRootFromNegativeNumberException();
		}
		
		
		stack.push(Math.sqrt(a));
	}
	
	public void log() {
		double a = stack.saveToLastXAndPop();
		
		if (a == 0) {
			throw new LogFromZeroException();
		}
		
		
		stack.push(Math.log(a));
	}
	
	public void log10() {
		double a = stack.saveToLastXAndPop();
		
		if (a == 0) {
			throw new Log10FromZeroException();
		}
		
		
		stack.push(Math.log10(a));
	}
	
	public void hmmssToDecDegreeConversion() {
		
		double a = stack.saveToLastXAndPop();
		
		int hours = (int) a;
		int minutes = (int)(( a -  (double) hours ) * 100); 
		double  seconds = ( a - (double) hours) * 100 - ((double) minutes * 100);
		
		double result = (double) hours + (double) minutes / 60 + seconds / 3600;
		
		stack.push(result);
	}
	
	
	public void decDegreeToHMMSSConversion() {
		double a = stack.saveToLastXAndPop();
		
		int hours = (int) a;
		int minutes = (int)((a - (double) hours) / 60) *3600;
		double seconds = (a - (double) hours) - ((double) minutes) / 60.0 * 3600;
		
		double result = (double) hours + (double) minutes / 100 + seconds / 10000;
		
		stack.push(result);

	}
	
	public void polarConversion() {
		double x = stack.saveToLastXAndPop();
		double y = stack.pop();
		
		if (x == 0) {
			throw new DivideByZeroException();
		}
		
		double squareSums = x * x + y * y;
		double r = Math.sqrt(squareSums);
		double aRad  = Math.atan(y / x);
		double angle =  convertFromRad(aRad);
		stack.push(angle);
		stack.push(r);
	}
	
	public void rectangularConversion() {
		double r = stack.saveToLastXAndPop();
		double a = stack.pop();
		double b = convertToRad(a);
		double x = Math.cos(b) * r;
		double y = Math.sin(b) * r;
		
		stack.push(y);
		stack.push(x);
	}
	
	private double convertToRad( double value) {
		switch (trigonometricMode) {
		case DEG:
			return Math.toRadians(value);
		case RAD:
			return value;
		case GRAD:
			return  0.0157079633 * value;
		}
		return 0;
	}
	
	private double convertFromRad(double value) {
		switch (trigonometricMode) {
		case DEG:
			return Math.toDegrees(value);
		case RAD:
			return value;
		case GRAD:
			return 63.6619772368 * value;
		}
		return 0;
	}
	
}
