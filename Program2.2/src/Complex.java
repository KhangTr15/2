/**
 * @author Khang Tran 2-23-2016
 * This is my complex class that implements comparable. The purpose of this class is to mimic a complex number: one number is real and one number is imaginary 
 */
public class Complex implements Comparable<Complex>{
	private final double re;
	private final double im;
	
	public Complex(double real, double imag){
		re = real;
		im = imag;
		
	}
	/**
	 * ToString method that returns the real number and the imaginary plus an i to signify that that number is imaginary
	 */
	public String toString(){
		if (im == 0)
			return re + " ";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + "-" + (-im) + "i";
		return re + "+" + im + "i";
	}
	/**
	 * CompareTo method that compares two complex objects against each other. If the object is less than the comparison then it returns a negative value and so on.
	 */
	public int compareTo(Complex obj) {
		if(this.re < obj.re)
			return -1;
		if(this.re > obj.re)
			return 1;
		else
			return 0;
	}

}
