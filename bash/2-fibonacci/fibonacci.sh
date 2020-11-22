#!/bin/bash
# Mark Stenbäck, 2019 (https://github.com/mstenback/practice_bash)
#
# Excercise 2: Calculate the F(n) - Fibonacci sequence, first 20 values.
VALUE=0
MAX_VALUES=20
VAL1=0
VAL2=1

echo "This script calculates F(n) - Fibonacci sequence, from F(0) to F(20)."

while [ $VALUE -le $MAX_VALUES ]
do
    if [ $VALUE -eq 0 ] || [ $VALUE -eq 1 ]; then
      echo "F($VALUE) = $VALUE"
    else
        SUM=$((VAL1+VAL2))
        echo "F($VALUE) = $SUM          ($VAL1 + $VAL2)"

        VAL1=$VAL2
        VAL2=$SUM
    fi

    VALUE=$((VALUE+1))
done
