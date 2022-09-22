package main

func climbStairs(n int) int {
	num1, num2, sum := 0, 0, 1
	for i := 1; i <= n; i++ {
		num1 = num2
		num2 = sum
		sum = num2 + num1
	}
	return sum
}

func main() {
	println(climbStairs(100))
}
