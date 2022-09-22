package 递归

import "fmt"

func myPow0(x float64, n int) float64 {
	if n >= 0 {
		return dfsPow(x, n)
	} else {
		return 1 / dfsPow(x, n)
	}

}

func dfsPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}
	y := dfsPow(x, n/2)

	if n%2 == 0 {
		return y * y
	} else {
		return y * y * x
	}

}

func main() {
	fmt.Printf("%v\n", myPow(5, -1))
}
