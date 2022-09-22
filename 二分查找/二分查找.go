package 二分查找

//二分查找的模板 秒杀

//二分查找，左闭右闭 [left,right]
func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1 // 定义target在左闭右闭的区间里，[left, right]
	for left <= right {    //当left==right，区间[left, right]依然有效，所以用 <=
		mid := left + (right-left)/2
		if nums[mid] > target {
			right = mid - 1 //
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			return mid
		}
	}
	return -1
}

//二分查找  左闭右开 [left,right)
func search0(nums []int, target int) int {
	left := 0
	right := len(nums)
	for left < right { //left==right时，对于左闭右开区间，这是没有意义的
		mid := left + (right-left)/2
		if nums[mid] > target {
			right = mid //target 在左区间，在[left, mid)中
		} else if nums[mid] < target {
			left = mid + 1 //target 在右区间，在[mid + 1, right)中
		} else {
			return mid //
		}
	}
	return -1
}
