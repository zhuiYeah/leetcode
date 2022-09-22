package 字符串

import "strings"

//goal是否是s的旋转字符串

//库函数 0分
func rotateString0(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	return strings.Contains(s+s, goal)
}

//KMP
func rotateString(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	s += s
	next := getNext(goal)

	i := 0 //s
	j := 0 //goal
	for i = 0; i < len(s); i++ {
		for j > 0 && s[i] != goal[j] {
			j = next[j-1]
		}
		if s[i] == goal[j] {
			j++
		}
		if j == len(goal) {
			return true
		}
	}

	return false
}

func nextxwfcecw(s string) []int {
	next := make([]int, len(s))
	next[0] = 0
	i := 1 //i表示后缀的末尾
	j := 0 //j表示前缀的某位
	for i = 1; i < len(s); i++ {
		for j > 0 && s[i] != s[j] {
			j = next[j-1]
		}
		if s[i] == s[j] {
			j++
		}
		next[i] = j
	}
	return next
}
