package 数组

//单次遍历，原地将偶数放到前面，但时间只超过了7%
func exchange0(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		if nums[i]%2 == 1 {
			x := nums[i]
			nums = append(nums[:i], nums[i+1:]...)
			//在首插入元素
			nums = append(nums, 0)
			copy(nums[1:], nums[0:])
			nums[0] = x
		}
	}
	return nums
}

//对撞指针 加 原地操作 时间复杂度从原来的O（n）变成了O（n/2），空间复杂度O（1）
func exchange(nums []int) []int {
	left, right := 0, len(nums)-1
	for left < right {
		if nums[left]%2 == 0 && nums[right]%2 == 1 { //左偶数右奇数
			nums[left], nums[right] = nums[right], nums[left]
			left++
			right--
		} else if nums[left]%2 == 1 && nums[right]%2 == 1 { //左奇右奇
			left++
		} else if nums[left]%2 == 0 && nums[right]%2 == 0 { //都是偶数
			right--
		} else {
			left++
			right--
		}
	}
	return nums
}
