package 滑动窗口

import "math"

//滑动窗口 窗口[start:end] 左闭右闭
func minSubArrayLen(target int, nums []int) int {
	start, end := 0, 0
	sum := 0
	minLen := math.MaxInt32
	for end < len(nums) {
		sum += nums[end]
		for sum >= target {
			minLen = min(minLen, end-start+1)
			sum -= nums[start]
			start++
		}
		end++
	}
	if minLen == math.MaxInt32 {
		return 0
	}
	return minLen
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
