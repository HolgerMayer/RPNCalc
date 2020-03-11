package model;

/**
 *  This class represents a stack with for elements (x,y,z,t) of type double. 
 *  
 *  The elements are initialized to 0.0
 *  <ul>
 *  <li>the push() function moves x to y, y to z, z to t and removes the old t value. The pushed value is the new x
 *  <li>the pop() function returns x, moves y to x , z to y, t to y and keeps the original t value. pop() does not change 
 *  the lastX variable
 *  <li>the saveToLastXAndPop() function copys the value from the  x variable into the lastX variable and then behaves like pop()  
 *  </ul>
 *  
 * @author Holger Mayer
 *
 */
public class ShortStack {
	private double x;
	private double y;
	private double z;
	private double t;

	private double lastX;
	
	ShortStack() {
		clear();
	}
	
	/**
	 * Sets all elements of the stack and the lastX variable to 0.0
	 */
	public void clear() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
		t = 0.0;
		lastX = 0.0;
		
	}
	
	/**
	 * Puts a value on the stack and moves all other elements one down. The value of the last element in the stack (t) is lost,.
	 * 
	 * @param value the new top element (x) on the stack
	 */
	public void push(double value) {
		t = z;
		z = y;
		y = x;
		x = value;
	}
	
	/**
	 * Returns the top element of the stack and moves all other elements one up. the value of the last element (t) stays the same.
	 * 
	 * @return the value of the top element (x) of the stack
	 */
	public double pop() {
	   double result = x;
	   x = y;
	   y = z;
	   z = t;
	   return result;
	}
	
	/**
	 *  Copys the value of  the top element (x) into the lastX variable and returns the top element of the stack and moves all other elements one up. the value of the last element (t) stays the same.
	 * 
	 * @return  the value of the top element (x) of the stack
	 */
	public double saveToLastXAndPop() {
		lastX = x;
		
		return pop();
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getT() {
		return t;
	}
	
	public double getLastX() {
		return lastX;
	}
}
