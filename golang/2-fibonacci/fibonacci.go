// Package main contains only one file with two functions.
package main

import "fmt"

// maxValues constant determines the length of the Fibonacci sequence.
const maxValues int = 20

var val1 uint16 = 0
var val2 uint16 = 1

// main controls the calculations.
func main() {
	fmt.Println("This script calculates F(n) - Fibonacci sequence, from F(0) to F(20).")

	for i := 0; i <= maxValues; i++ {
		if i == 0 || i == 1 {
			fmt.Println("F(", i, ") = ", i)
		} else {
			fmt.Println("F(", i, ") = ", calculateFibonacci())
		}
	}
}

// calculateFibonacci performs a single calculation by relying on global variables.
// It returns the next Fibonacci in the sequence.
func calculateFibonacci() uint16 {
	var sum uint16 = 0
	sum = val1 + val2

	val1 = val2
	val2 = sum

	return sum
}
