3-fibonacci_index
=================

fibonacci_index
---------------
A non-recursive implementation of the calculation.
It should be noted that by not using recursion it
is possible to calculate significantly larger sequences
than it is with recursion.

fibonacci_index_recursion
-------------------------
Recursive implementation of `F(n) = F(n-1) + F(n-2)`.
It should be noted that Python 3 has a system variable,
`sys.getrecursionlimit()` that sets the limit for how deep recursion
can run. It seems that the default value is `1000`.

However, the processing begins to slow down at `F(30)` and dramatically
slows down from there. With `F(35)` is just about to highest one might
be willing to wait and with `F(100)` the application is a good as frozen. 

Surprising result - with most other languages recursion remains very
efficient even with large values of `n`.