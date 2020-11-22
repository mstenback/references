package com.markstenback;

/**
 * <h1>2-fibonacci</h1>
 * <p>This script calculates the Fibonacci number sequence, F(n) where n &ge; 0.
 * The sequence begins with F(0) and ends with F(20).</p>
 * <p><a href="https://github.com/mstenback/practice_java">https://github.com/mstenback/practice_java</a></p>
 * @author Mark Stenbäck, 2019
 */
public class Fibonacci
{
    /** Fixed range for calculating Fibonacci. */
    private static final int MAX_VALUES = 20;

    private static int val1 = 0;
    private static int val2 = 1;


    /**
     * <p>The main method that prints out the Fibonacci sequence from F(0) to F(20).</p>
     *
     * @param args  No command line arguments
     */
    public static void main (String[] args)
    {
	    System.out.println("This script calculates F(n) - Fibonacci sequence, from F(0) to F(20).");

	    for (int i = 0; i <= MAX_VALUES; i++)
        {
            if (i == 0 || i == 1)
                System.out.println ("F(" + i + ") = " + i);
            else
            {
                System.out.println ("F(" + i + ") = " + calculateFibonacci());
            }
        }
    }


    /**
     * <p>This simple method calculates the next Fibonacci in the sequence.</p>
     *
     * @return fibonacci
     */
    private static int calculateFibonacci ()
    {
        int sum = val1 + val2;

        val1 = val2;
        val2 = sum;

        return sum;
    }
}
