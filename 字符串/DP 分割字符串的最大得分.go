package 字符串

//过于简单不屑于放入dp专题，只要能想到dp本题迎刃而解
func maxScore(s string) int {
	n := len(s)
	dpLeft := make([]int, n-1) //长为n的字符串有n-1种分割方案
	//第i种分割方案（在s[i]后面切割），左边的0字符数量为dpLeft[i]
	dpRight := make([]int, n-1)
	//第i种分割方案（在s[i]后面切割），右边的1字符数量为dpLeft[i]
	//初始化dp数组
	if s[0] == '0' {
		dpLeft[0] = 1
	}
	if s[n-1] == '1' {
		dpRight[n-2] = 1
	}
	for i := 1; i < n-1; i++ {
		if s[i] == '0' {
			dpLeft[i] = dpLeft[i-1] + 1
		} else {
			dpLeft[i] = dpLeft[i-1]
		}
	}
	for i := n - 2; i >= 1; i-- {
		if s[i] == '1' {
			dpRight[i-1] = dpRight[i] + 1
		} else {
			dpRight[i-1] = dpRight[i]
		}
	}
	res := 0
	for i := 0; i < n-1; i++ {
		if dpLeft[i]+dpRight[i] > res {
			res = dpLeft[i] + dpRight[i]
		}
	}
	return res
}
