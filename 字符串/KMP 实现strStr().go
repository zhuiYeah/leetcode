package 字符串

//前缀表统一减1
func strStr(haystack string, needle string) int {
	//先构造前缀表next数组
	next := make([]int, len(needle))
	j := -1 // j+1表示前缀的末尾 ,前缀的末尾的初始值应当为0
	i := 1  // i表示后缀的末尾 ，后缀的末尾初始值应当为1
	next[0] = -1
	for ; i < len(needle); i++ {
		for j >= 0 && needle[i] != needle[j+1] {
			j = next[j]
		}
		if needle[i] == needle[j+1] {
			j++
		}
		next[i] = j
	}

	//下面开始匹配文本串和模式串
	j = -1 //使用j+1指向模式串的首地址
	i = 0  //使用i指向文本串的首地址
	for ; i < len(haystack); i++ {
		for j >= 0 && needle[j+1] != haystack[i] { //不匹配 ；j+1是模式串的当前位置，j是模式串的前一个位置
			j = next[j] //j+1寻找之前匹配的位置
		}
		if needle[j+1] == haystack[i] { //当前位置文本串字符串匹配
			j++
		}
		if j+1 == len(needle) {
			return i - len(needle) + 1
		}
	}
	return -1
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//滑动窗口比较方法
func strStr1(haystack string, needle string) int {
	n := len(needle)
	m := -1
	for i := 0; i < len(haystack)-n+1; i++ {
		if haystack[i:i+n] == needle { //字符串子串的比较
			m = i
			break
		}
	}
	return m
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
//前缀表不变
func strStr2(haystack string, needle string) int {
	//先构造前缀表next数组
	next := make([]int, len(needle))
	j := 0 // j表示前缀的末尾 ,前缀的末尾的初始值应当为0
	i := 1 // i表示后缀的末尾 ，后缀的末尾初始值应当为1
	next[0] = 0
	for ; i < len(needle); i++ {
	    //不相同的情况
		for j > 0 && needle[i] != needle[j] {
			j = next[j-1]
		}
		//相同的情况
		if needle[i] == needle[j] {
			j++
		}
		//更新前缀表
		next[i] = j
	}

	//下面开始匹配文本串和模式串
	j = 0 //使用j指向模式串的首地址
	i = 0 //使用i指向文本串的首地址
	for ; i < len(haystack); i++ {
		for j > 0 && needle[j] != haystack[i] { //不匹配 ；j是模式串的当前位置，j-1是模式串的前一个位置
			j = next[j-1] //j寻找之前匹配的位置
		}
		if needle[j] == haystack[i] { //当前位置文本串字符串匹配
			j++
		}
		if j == len(needle) {
			return i - len(needle) + 1
		}
	}
	return -1
}
