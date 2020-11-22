3-fibonacci_index (Golang)
==========================
This implementation reads user input from command line and uses
Regular Expressions to validate the input. The accepted input for *n* is
zero or a positive integer, which in this case is `uint16`.

As it happens, the maximum value for *n* in `F(n)` is 65535,
which results in Fibonacci value that has 18 digits 
(the actual value is `uint64`).

Code documentation should be in line with Godoc.