package model;

public class MathTool {

	  public static double  factorial(double value) {
	       double  result = 1.0;
	       for (int i = 1; i <= value; i++) {
	           result = result * (double)i;
	       }
	       return result;
	   }
	
}
