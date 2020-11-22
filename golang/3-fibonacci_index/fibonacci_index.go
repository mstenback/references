// Package main contains just one class.
package main

import (
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strconv"
	"strings"
)

// re is a regular expression that checks if the input contains only numerical values.
var re = regexp.MustCompile("^[0-9]+")

// main takes user input, validates it and then calls for the Fibonacci calculation.
func main() {
	fmt.Println("This script calculates F(n) - Fibonacci value for the given number.")
	fmt.Println("Please provide a value n (>= 0):")

	// read the user input
	reader := bufio.NewReader(os.Stdin)
	text, _ := reader.ReadString('\n')
	text = strings.Replace(text, "\n", "", -1)

	// use RegExp to validate the input.
	index, err := strconv.ParseUint(text, 10, 16)

	if err != nil {
		fmt.Println("Error: Input conversion failed: ", err)
	}

	// if the input validation is ok, calculate Fibonacci. Otherwise print error message.
	if re.MatchString(text) {
		fmt.Println("F(", index, ") = ", calculateFibonacci(index))
	} else {
		fmt.Println("Error: Please enter either a zero or a positive integer.")
	}
}

// calculateFibonacci uses uint64 to calculate Fibonacci.
// As it is, the largest value for n in F(n) is 65535, which is essentially uint16.
// Might be a bug in func main(), but it still results in pretty large Fibonacci value (it has 18 digits).
func calculateFibonacci(index uint64) uint64 {
	var val1, val2, sum uint64 = 0, 1, 0

	for i := uint64(0); i <= index; i++ {

		if i == 0 || i == 1 {

			if i == index {
				sum = uint64(index)
				break
			}
		} else {
			sum = val1 + val2

			val1 = val2
			val2 = sum
		}
	}

	return sum
}
