package 字符串

func reverseLeftWords(s string, n int) string {
	n = n % len(s)
	b := []byte(s)
	//不使用额外空间，仅仅在本串上操作
	// 1. 反转前n个字符
	// 2. 反转第n到end字符
	// 3. 反转整个字符
	redefce(b, 0, n-1)
	redefce(b, n, len(s)-1)
	redefce(b, 0, len(s)-1)
	return string(b)
}

func redefce(b []byte, left int, right int) { //切片是引用传递
	for left < right {
		b[left], b[right] = b[right], b[left]
	}
}
