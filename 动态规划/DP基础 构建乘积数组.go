package 动态规划

func constructArr(a []int) []int {
	n := len(a)
	var res []int
	left := make([]int, len(a)) //left[i]：a[i]左边所有元素的乘积
	right := make([]int, len(a))
	left[0] = 1
	right[n-1] = 1
	for i := 1; i < len(a); i++ {
		left[i] = left[i-1] * a[i-1]
	}
	for j := n - 2; j >= 0; j-- {
		right[j] = right[j+1] * a[j+1]
	}

	for i := 0; i < len(a); i++ {
		res = append(res, left[i]*right[i])
	}
	return res
}
