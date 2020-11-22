#!/bin/bash
# Mark Stenbäck, 2019 (https://github.com/mstenback/practice_bash)
#
# Excercise 3: Calculate F(n) - Fibonacci value for the given number.
# E.g. the 6th Fibonacci (n=6) is 8.
# The maximum Fibonacci that can be calculated with a signed 64-bit integer
# is the 92th Fibonacci, 7540113804746346429.

INDEX=0
MAX_FIBONACCI=7540113804746346429
ROUND=2
VAL1=0
VAL2=1
SUM=0
RE='^[0-9]+$'

# If user has given no command line parameters so ask for them. Verify that values are numbers.
if [[ $# -ne 1 ]]; then
    echo "This script calculates F(n) - Fibonacci value for the given number."
    echo "Please provide a value n (>= 0):"
    read INDEX
else
    INDEX=$1
fi

# Validate the user input.
if ! [[ $INDEX =~ $RE ]]; then
    echo "Error: For function F(n) the value of n must be >= 0." >&2; exit 1
fi

# Calculate the sequence up to the specified index.
if [ $INDEX -eq 0 ] || [ $INDEX -eq 1 ]; then
    echo "F($INDEX) = $INDEX"
else
    while [ $ROUND -le $INDEX ]
    do
        SUM=$((VAL1+VAL2))

        # If we go beyond this point the SInt64 value will flip to negative for the next Fibonacci.
        if [ $SUM -ge $MAX_FIBONACCI ]; then
            echo "F($ROUND) = $SUM   <- the maximum F(n) for signed 64-bit integer."; exit 1
        fi

        ROUND=$((ROUND+1))

        VAL1=$VAL2
        VAL2=$SUM
    done
    echo "F($INDEX) = $SUM"
fi
exit 0
