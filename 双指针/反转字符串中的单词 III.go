package 双指针

//start指针
//go语言中字符串string类型是无法被原地修改的
func reverseWords(s string) string {
	var res string
	start := 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			res += xwdwdw(s[start:i]) + " "
			start = i + 1
		}
	}
	res += xwdwdw(s[start:len(s)])
	return s
}

//对撞指针
func xwdwdw(ss string) string {
	s := []byte(ss)
	left, right := 0, len(s)-1
	for left < right {
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}

	return string(s)
}
