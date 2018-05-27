/**
 * @author Sedgewick, Wayne
 * statics.java
 * May 27, 2018
 */
package exampleStaticMethods;

/**
 * Testing point for our various static methods
 */
public class statics {
  
  public static void main(String[] args) {
    // testing point for abs()
    int x1 = 24, x2 = -24;
    System.out.println( "x1 = 24, x2 = -24; ");
    System.out.println("abs(x1) = abs(-x2): "+(abs( x1) == abs( -x2))); // true
    // isPrime
    System.out.println( isPrime( x1)); // false
    System.out.println( isPrime( (x1) / 8)); // true
    // sqrt
    System.out.println( "sqrt(2): " + sqrt( 2)); // 1.414213562373095
    System.out.println( "sqrt(-2): " + sqrt( -2.0)); // NaN
    // hypotenuse
    System.out.println( "hypotenuse(1,1): " + hypotenuse( 1, 1));
    System.out.println( "hypotenuse(-1,0): " + hypotenuse( -1, 0));
    // Harmonic number
    System.out.println( "harmonic(x1): "+harmonic(x1));
    System.out.println( "harmonic(x2): "+harmonic(x2));
    
  }
  
  /** @returns true if n is prime, false if n is composite. */
  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i < n; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
  
  /** @return absolute int of i */
  public static int abs(int i) {
    
    if (i < 0) {
      return -i;
    } else
      return i;
  }
  
  /** @return absolute double of i */
  public static double abs(double i) {
    
    if (i < 0) {
      return -i;
    } else
      return i;
  }
  
  /** @returns sqrt of c, using the Newton method */
  public static double sqrt(double c) {
    if (c < 0)
      return Double.NaN;
    double err = 1e-15;
    double t = c;
    while (Math.abs( t - c / t) > err * t)
      t = ((c / t) + t) / 2.0;
    return t;
  }
  
  /** @returns distance across hypotenuse of a right triangle. */
  public static double hypotenuse(double a, double b) {
    return sqrt( a * a + b * b);
  }
  
  /** @returns the nth Harmonic number */
  public static double harmonic(int n) {
    double sum = 0.0;
    for (int i = 1; i <= n; i++) {
      sum += 1.0 / i;
    }
    return sum;
  }
  
}
