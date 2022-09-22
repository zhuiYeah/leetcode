package 双指针

import "sort"

//在确定了i的情况下，取左右指针对撞
func threeSum(nums []int) [][]int {
	var res [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums)-2; i++ {
		//a的去重
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		left, right := i+1, len(nums)-1
		for left < right {

			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				// 找到答案时，双指针同时收缩
				right--
				left++
				//去重很复杂 这里是b和c的去重  去重逻辑应该放在找到一个三元组之后
				for left < right && nums[right] == nums[right+1] {
					right--
				}
				for left < right && nums[left] == nums[left-1] {
					left++
				}

			} else if sum > 0 {
				right--
			} else {
				left++
			}
		}
	}
	return res
}
