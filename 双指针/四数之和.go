package 双指针

import "sort"

//和三数之和的逻辑一样，但是在二重循环之下 再来个双指针
func fourSum(nums []int, target int) [][]int {
	var res [][]int
	n := len(nums)
	sort.Ints(nums)
	for i := 0; i < n-3; i++ { //必须预留三个数供后面的选择
		//对a的去重
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < n-2; j++ {
			//对b的去重
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			left := j + 1
			right := n - 1
			for left < right {
				sum := nums[i] + nums[j] + nums[left] + nums[right]
				if sum > target {
					right--
				} else if sum < target {
					left++
				} else {
					//找到一个四元组了
					res = append(res, []int{nums[i], nums[j], nums[left], nums[right]})
					left++
					right--
					//对c d的去重
					for left < right && nums[left] == nums[left-1] {
						left++
					}
					for left < right && nums[right] == nums[right+1] {
						right--
					}
				}
			}
		}
	}
	return res
}
