package 回溯

import "math"

//回溯超时
func minCut(s string) int {
	num := math.MaxInt
	path := 0 //代表目前已经切到手多少块了

	var backtracking func(startIndex int) //从startIndex开始切割
	backtracking = func(startIndex int) {
		if startIndex == len(s) { //叶子节点，上一次已经切割到最后了
			num = min(num, path-1)
		}
		for i := startIndex + 1; i < len(s); i++ { //不能切割空片，所以i初始为  +1
			if isP(s[startIndex:i]) { //如果是回文子串的话 就切
				path++
			} else { //不是的话不切，切下一块
				continue
			}
			///是否到了叶子结点？是否回溯？  是：下一步回溯  否：深入递归，增加path的长度
			backtracking(i) //当前已经切到i了，i作为下一次切割的起点
			///回溯
			path--
		}
	}
	backtracking(0)
	return num
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
