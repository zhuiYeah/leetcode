package 二分查找

//自己写的二分太垃圾了
func missingNumber(nums []int) int {
	if nums[0] != 0 {
		return 0
	}
	if nums[0] == 0 && len(nums) == 1 {
		return 1
	}
	left, right := 1, len(nums)-1

	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] != nums[mid-1]+1 {
			return mid - 1
		} else if nums[mid] == mid { //	缺失的数字在mid后面
			left = mid + 1
		} else if nums[mid] != mid { //缺失的数字在mid前面
			right = mid
		}
	}
	return len(nums)
}

func missingNumber1(nums []int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == mid {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return left
}
