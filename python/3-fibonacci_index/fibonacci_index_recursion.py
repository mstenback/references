import sys


# The control function.
def main():
    print("This application calculates F(n) - Fibonacci value for the given number.")
    index = process_input()

    # Python has set a limit for recursion depth.
    if sys.getrecursionlimit() <= index:
        print("Error: The given index [{}] exceeds system's recursion limit [{}]".format(index, sys.getrecursionlimit()))
        sys.exit(1)

    print("F({}) = {}".format(index, calculate_fibonacci_regex(index)))


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


# Recursively calculate Fibonacci: F(n) = F(n-1) + F(n-2)
# While this works, the function is reasonably fast up to N=20.
# Around N=30 process begins to take quite long and at N=35 it will take even longer.
def calculate_fibonacci_regex(index):
    for x in range(0, index):
        if index == 1:
            return index
        else:
            return int(calculate_fibonacci_regex(index - 1)) + int(calculate_fibonacci_regex(index - 2))
    else:
        return index


# Run the application
main()
