package model;

public class ShortStack {
	double x;
	double y;
	double z;
	double t;

	ShortStack() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
		t = 0.0;
	}
	
	public void push(double value) {
		t = z;
		z = y;
		y = x;
		x = value;
	}
	
	public double pop() {
	   double result = x;
	   x = y;
	   y = z;
	   z = t;
	   return result;
	}
	
}
