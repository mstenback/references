# The main method calls for the calculation method for specified number of times.
def main():
    max_values = 21

    print("This application calculates F(n) - Fibonacci sequence, from F(0) to F(20)")

    for n in range(max_values):
        print("F(" + str(n) + ") = " + str(calculate_fibonacci(n)))


# The recursive Fibonacci calculation: F(n) = F(n-1) + F(n-2)
def calculate_fibonacci(n):
    if n == 0 or n == 1:
        return n
    else:
        return calculate_fibonacci(n - 1) + calculate_fibonacci(n - 2)


# Call for the main function.
main()
