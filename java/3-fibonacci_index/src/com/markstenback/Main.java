package com.markstenback;

/**
 * <h1>3-fibonacci</h1>
 * <p></p>A variation from previous 2-fibonacci script.</p>
 *
 * <p>Instead of listing multiple Fibonacci values, it prints out the specific number for the
 * given value of <code>F(n)</code>. For example, <code>F(6)</code> equals <b>8</b>.<p></p>
 *
 * <p>This script processes user input as command line parameter.</p>
 *
 * <p>This script also includes rudimentary input validation and some sanity checks.
 * For example, it will not calculate Fibonacci past 92nd value as the 93rd would exceed the maximum
 * value for signed 64-bit integer, which would flip to negative value and corrupt subsequent calculations.</p>
 *
 * <p><a href="https://github.com/mstenback/practice_java">https://github.com/mstenback/practice_java</a></p>
 *
 * @author Mark Stenbäck, 2019
 */
public class Main
{
    /** Exit code for successful completion of the application. */
    private static final int EXIT_CODE_CLEAN = 0;

    /** Exit code for aborted execution of the application. */
    private static final int EXIT_CODE_ERROR = 1;

    private static Long val1 = 0L;
    private static Long val2 = 1L;
    private static Long sum  = 0L;


    /**
     * <p>The main method of the application. Does not contain much actual logic, but calls proper methods in order.</p>
     *
     * @param args  No command line arguments
     */
    public static void main (String[] args)
    {
        System.out.println("This application calculates F(n) - Fibonacci value for the given number.");

        if (args.length == 0)
        {
            System.out.println ("Please provide a value n for F(n), where n >= 0");
            System.out.println ("For example, 'java main 6' result is F(6) = 8");
            System.exit(EXIT_CODE_CLEAN);
        }
        else
            calculateFibonacci (parseCLI(args));
    }


    /**
     * <p>This method parses the command line input and verifies, that the first value is either
     * a zero or a positive integer. If the given value is a negative, decimal or literal, the
     * application aborts.</p>
     *
     * @param args cli
     * @return index    The value of <em>n</em> in <code>F(n)</code>.
     */
    private static Integer parseCLI (String[] args)
    {
        Integer index = 0;

        try
        {
            index = Integer.parseInt(args[0]);

            if (index < 0)
            {
                System.err.println ("Error: The given value must be either a zero or a positive integer.");
                System.exit(EXIT_CODE_ERROR);
            }
        }

        catch (NumberFormatException nfe)
        {
            System.err.println("Error: Unable to convert command line value [" + args[0] + "] to Integer.");
            System.err.println("Please enter either a zero or a positive integer.");
            System.exit(EXIT_CODE_ERROR);
        }

        return index;
    }


    /**
     * <p>This simple method calculates the Fibonacci for the given value.</p>
     *
     * @param index     The value of <em>n</em> in <code>F(n)</code>.
     */
    private static void calculateFibonacci (Integer index)
    {
        for (int i = 0; i <= index; i++)
        {
            if (i == 0 || i == 1)
            {
                if (i == index)
                    sum = Integer.toUnsignedLong(index);
            }
            else
            {
                sum = Long.sum(val1, val2);

                val1 = val2;
                val2 = sum;
            }
        }

        System.out.println ("F(" + index + ") = " + sum);
    }
}
