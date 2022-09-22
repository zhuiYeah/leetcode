package 数组

//旋转数组k次

func rotate0(nums []int, k int) {
	for i := 0; i < k%len(nums); i++ {
		last := nums[len(nums)-1]                              //保存最后一位
		nums = append(nums[:len(nums)-1], nums[len(nums):]...) //删掉最后一位
		//第一位插入元素
		nums = append(nums, 0)
		copy(nums[1:], nums[0:])
		nums[0] = last
	}
}
