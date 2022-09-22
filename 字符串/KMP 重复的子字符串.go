package 字符串

//s能否由他的某一子串重复n次构成
func repeatedSubstringPattern(s string) bool {
	if len(s) == 1 {
		return false
	}
	next := getNextG(s)
	x := next[len(next)-1] //x表示字符串的 最长相同前后缀长度
	//数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
	//如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
	y := len(next) - x //y表示一个周期的长度

	if x == 0 || len(next)%y != 0 {
		return false
	} else {
		return true
	}
}

func getNextG(s string) []int {
	next := make([]int, len(s))
	next[0] = 0
	j := 0 //j表示前缀末尾
	i := 1 //i表示后缀末尾
	for i = 1; i < len(s); i++ {
		for j > 0 && s[j] != s[i] {
			j = next[j-1]
		}
		if s[j] == s[i] {
			j++
		}
		next[i] = j
	}
	return next
}
