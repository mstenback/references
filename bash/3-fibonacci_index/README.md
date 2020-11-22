3-fibonacci_index
=================
A variation from previous _2-fibonacci_ script. Instead of listing multiple Fibonacci values, it prints out
the specific number for the given value of F(n). For example, F(6) equals 8.

This script processes user input as command line parameter  
&ensp; E.g. `./fibonacci_index.sh 5`  
Alternatively it will query user for the value, if the script is executed without any parameters.  
&ensp; `./fibonacci_index.sh`

This script also includes rudimentary input validation and some sanity checks. For example,
it will not calculate Fibonacci past 92nd value as the 93rd would exceed the maximum value for
signed 64-bit integer, which would flip to negative value and corrupt subsequent calculations.
