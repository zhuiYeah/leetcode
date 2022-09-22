package 滑动窗口

//找到s中所有p的异位词的子串的开始位置

//滑动窗口 + 字符频率的表示方法
func findAnagrams0(s string, p string) []int {
	windowsize := len(p)
	var res []int
	if len(p) > len(s) {
		return res
	}
	hashmap1 := make([]int, 26) //表示p的频率，只需要初始化一次
	hashmap2 := make([]int, 26) //表示s在滑动窗口内的频率
	//接下来是初始化
	for i := 0; i < windowsize; i++ {
		hashmap1[p[i]-'a']++
		hashmap2[s[i]-'a']++
	}
	if isSameArr(hashmap2, hashmap1) {
		res = append(res, 0)
	}
	//
	for i := windowsize; i < len(s); i++ {
		//滑动窗口，更新向右滑动一个后窗口内的频率
		hashmap2[s[i]-'a']++
		hashmap2[s[i-windowsize]-'a']--
		if isSameArr(hashmap1, hashmap2) {
			res = append(res, i-windowsize+1)
		}
	}
	return res
}
