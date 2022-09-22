package main

func searchInsert(nums []int, target int) int {
	n := len(nums)
	ans := n
	left, right := 0, n-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] >= target {
			ans = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return ans
}
