package 字符串

func reverseStr(s string, k int) string {
	b := []byte(s)
	start := 0
	end := k
	for end <= len(s) {
		rdewdw(b[start:end])
		start = end + k
		end += 2 * k
	}
	if start < len(s) {
		rdewdw(b[start:])
	}
	return string(b)
}

func rdewdw(s []byte) {
	left, right := 0, len(s)-1
	for left < right {
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}
}
