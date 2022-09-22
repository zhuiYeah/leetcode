package 字符串

import "math"

//制造一个数组，数组[i] 标志了这个位置到达字符c的最短距离
func shortestToChar(s string, c byte) []int {
	res := make([]int, len(s))
	start := 0
	x := 0 //标记位
	for i := 0; i < len(s); i++ {
		if s[i] == c {
			start = i
			x = 1
		}
		if x == 1 {
			res[i] = i - start
		} else {
			res[i] = math.MaxInt32
		}
	}
	x = 0
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == c {
			start = i
			x = 1
		}
		if x == 1 {
			res[i] = min(res[i], start-i)
		}
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
