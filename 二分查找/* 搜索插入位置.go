package 二分查找

//找到target插入的下标  本来处于该下标的数字以及后面的数字往后拉一格

func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)-1
	index := len(nums)
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > target {
			right = mid - 1
			index = mid
		}
		if nums[mid] < target {
			left = mid + 1
		}
	}
	return index
}
