package 滑动窗口

func lengthOfLongestSubstring(s string) int {
	seen := map[byte]bool{}
	//用left，right组成一个滑动窗口
	right := 0
	maxLen := 0 //记录无重复子串的最大长度
	for left := 0; left < len(s); left++ {
		if left != 0 { //left的每次滑动都要对应着hash表中的元素删除
			delete(seen, s[left-1])
		}
		for right < len(s) && !seen[s[right]] {
			seen[s[right]] = true
			right++
		}
		maxLen = max(maxLen, right-left)
	}
	return maxLen
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
