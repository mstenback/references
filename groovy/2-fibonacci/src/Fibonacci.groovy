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
class Fibonacci {
    private static final int MAX_VALUES = 20
    private static int val1 = 0
    private static int val2 = 1

    /**
     *
     * @param args No arguments
     */
    static void main (String[] args) {
        println "This application calculates F(n) - Fibonacci sequence, from F(0) to F(20)."

        for (int i = 0; i <= MAX_VALUES; i++) {
            if (i == 0 || i == 1)
                println "F($i) = $i"
            else
                println "F($i) = ${calculateFibonacci()}"
        }
    }


    /**
     *
     * @return fib  Fibonacci number
     */
    private static int calculateFibonacci() {
        int fib = val1 + val2

        val1 = val2
        val2 = fib

        return fib
    }
}
