import sys


def main():
    print("This application calculates F(n) - Fibonacci value for the given number.")
    index = process_input()

    print("F({}) = {}".format(index, calculate_fibonacci(index)))


# This function reads users input either from command line arguments or as line input.
def process_input():
    if len(sys.argv) > 1:
        index = sys.argv[1]
    else:
        index = input("Please provide a value n (>= 0): ")

    if not index.isdigit() or int(index) < 0:
        print("Error: The given value must be either a zero or a positive integer.")
        sys.exit(1)

    return int(index)


# By not using recursion it is possible to calculate far larger Fibonacci sequences
# very quickly, e.g. F(10000)
def calculate_fibonacci(index):
    val1 = 0
    val2 = 1
    fib = 0

    for x in range(0, index-1):
        if index == 1:
            return index
        else:
            fib = val1 + val2

            val1 = val2
            val2 = fib

    return fib


# RUn the application
main()
