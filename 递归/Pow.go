package 递归

//呵呵，想考我递归，被我秒杀了
func myPow(x float64, n int) float64 {
	if n < 0 {
		return 1 / myPowHelp(x, -n)
	} else {
		return myPowHelp(x, n)
	}
}

func myPowHelp(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}
	mid := myPow(x, n/2)

	if n%2 == 0 {
		return mid * mid
	} else {
		return mid * mid * x
	}
}
