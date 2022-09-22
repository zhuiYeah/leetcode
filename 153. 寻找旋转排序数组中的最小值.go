package main

//因为数组的复杂性，这是一个很特殊的二分查找
func findMin(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := left + (right-left)>>1
		if mid == 0 {
			return nums[0]
		}
		if nums[mid] < nums[right] {
			right = mid
		} else if nums[mid] > nums[right] {
			left = mid + 1
		}
	}
	return nums[left]
}
