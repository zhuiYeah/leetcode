package 滑动窗口

//判断 s2 是否包含 s1 的某个字符变位词。
func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	windowSize := len(s1)
	freTarget := make([]int, 26)
	for i := 0; i < len(s1); i++ {
		freTarget[s1[i]-'a']++
	}
	freSlide := make([]int, 26)
	//初始化滑动窗口词频
	for i := 0; i < windowSize; i++ {
		freSlide[s2[i]-'a']++
	}
	for i := 0; i < len(s2)-windowSize; i++ {
		if isSameArr(freSlide, freTarget) {
			return true
		}
		freSlide[s2[i]-'a']--
		freSlide[s2[i+windowSize]-'a']++
	}
	if isSameArr(freSlide, freTarget) {
		return true
	}
	return false
}

// func IsSameArr(a, b []int) bool { //这玩意的出现是因为go中没有 []int的==运算符
// 	if len(a) != len(b) {
// 		return false
// 	}

// 	for i := 0; i < len(a); i++ {
// 		if a[i] != b[i] {
// 			return false
// 		}
// 	}
// 	return true
// }
