package 二分查找

//本题是在一个部分有序的数组里面进行二分查找 是一道hard题
func findMin(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right { //左闭右闭，最后收缩到一个点，那个点就是最小值
		mid := left + (right-left)/2
		if nums[mid] > nums[right] {
			left = mid + 1
		} else if nums[mid] < nums[right] {
			right = mid
		} else { //它们的值相同，所以无论nums[right] 是不是最小值，都有一个它的「替代品」nums[mid]，因此我们可以忽略二分查找区间的右端点
			right--
		}
	}
	return nums[right]
}
