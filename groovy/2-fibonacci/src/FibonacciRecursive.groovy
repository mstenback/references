/**
 * <h1>2-fibonacci</h1>
 *
 * <p>This script calculates the Fibonacci number sequence, F(n) where n &ge; 0.
 * The sequence begins with F(0) and ends with F(20).</p>
 *
 * <p><a href="https://github.com/mstenback/reference_groovy">https://github.com/mstenback/reference_java</a></p>
 *
 * @author Mark Stenbäck, 2019
 */
class FibonacciRecursive {
    private static final int MAX_VALUES = 20
    private static int val1 = 0
    private static int val2 = 1

    /**
     *
     * @param args No arguments
     */
    static void main (String[] args) {
        println "This application calculates F(n) - Fibonacci sequence, from F(0) to F(20)."

        for (int n = 0; n <= MAX_VALUES; n++) {
                println "F($n) = ${calculateFibonacci(n)}"
        }
    }


    /**
     *
     * @return fib  Fibonacci number
     */
    private static int calculateFibonacci(int n) {
        if (n == 0 || n == 1)
            return n
        else
            return calculateFibonacci(n-1) + calculateFibonacci(n-2)
    }
}
