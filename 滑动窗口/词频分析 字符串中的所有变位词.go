package 滑动窗口

//s="cbaebabacd , p="abc"  ,找到s中所有p的异位词的起始下标 [0,6]
func findAnagrams(s string, p string) []int {
	var res []int
	windowSize := len(p)
	if windowSize > len(s) {
		return res
	}
	freTarget := make([]int, 26)
	freSlide := make([]int, 26)
	//靶子的词频
	for i := 0; i < len(p); i++ {
		freTarget[p[i]-'a']++
	}
	//初始化滑动窗口的词频
	for i := 0; i < windowSize; i++ {
		freSlide[s[i]-'a']++
	}
	for i := 0; i < len(s)-windowSize; i++ { //i是滑动窗口的左区间
		if isSameArr(freTarget, freSlide) {
			res = append(res, i)
		}
		freSlide[s[i]-'a']--
		freSlide[s[i+windowSize]-'a']++
	}
	if isSameArr(freTarget, freSlide) {
		res = append(res, len(s)-windowSize)
	}
	return res
}
