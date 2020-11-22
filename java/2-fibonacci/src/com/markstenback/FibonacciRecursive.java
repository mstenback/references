package com.markstenback;

/**
 * <h1>2b-fibonacci_recursive</h1>
 *
 * <p>This cleaner implementation utilises recursive method to calculates the Fibonacci number sequence,
 * <code>F(n) = F(n-1) + F(n-2)</code>, where n &ge; 0. The sequence begins with F(0) and ends with F(20).</p>
 *
 * <p><a href="https://github.com/mstenback/practice_java">https://github.com/mstenback/practice_java</a></p>
 *
 * @author Mark Stenbäck, 2019
 */
public class FibonacciRecursive
{
    /** Fixed range for calculating Fibonacci. */
    private static final int MAX_VALUES = 20;


    /**
     * <p>The main method that prints out the Fibonacci sequence from F(0) to F(20).</p>
     *
     * @param args  No command line arguments
     */
    public static void main (String[] args)
    {
        System.out.println("This script calculates F(n) - Fibonacci sequence, from F(0) to F(20).");

        for (int n = 0; n <= MAX_VALUES; n++)
        {
            System.out.println ("F(" + n + ") = " + calculateFibonacci(n));
        }
    }


    /**
     * <p>This recursive method is the proper implementation of <code>F(n) = F(n-1) + F(n-2)</code>.</p>
     *
     * @return fibonacci
     */
    private static int calculateFibonacci (int n)
    {
        if (n == 0 || n == 1)
            return n;
        else
        {
            return calculateFibonacci(n- 1 ) + calculateFibonacci(n - 2);
        }
    }
}
