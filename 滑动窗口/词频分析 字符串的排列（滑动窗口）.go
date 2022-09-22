package 滑动窗口

//s1的排列能否由s2的某一个子数组表示
//字符频率就用长为26的数组表示   +  滑动窗口
func checkInclusion0(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	windowSize := len(s1)
	hashmap1 := make([]int, 26) //s1中的字符频率，仅需要更新一次
	hashmap2 := make([]int, 26) //s2滑动窗口内的字符频率，需要不断更新
	for i := 0; i < len(s1); i++ {
		hashmap1[s1[i]-'a']++
		hashmap2[s2[i]-'a']++
	}
	for i := windowSize; i < len(s2); i++ { //设置滑窗为左闭右开区间
		if isSameArr(hashmap2, hashmap1) {
			return true
		}
		//窗口滑动
		hashmap2[s2[i-windowSize]-'a']-- //目前窗口最左边的元素减1
		hashmap2[s2[i]-'a']++            //窗口右滑
	}

	// 整个算法采用左闭右开区间，因此最后还有一个窗口没有判断
	return isSameArr(hashmap2, hashmap1)
}
func isSameArr(a, b []int) bool { //这玩意的出现是因为go中没有 []int的==运算符
	if len(a) != len(b) {
		return false
	}

	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
