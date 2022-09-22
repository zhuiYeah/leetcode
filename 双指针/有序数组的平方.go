package 双指针

import "sort"

//自己想的垃圾双指针，从内向外 （缺点在于要先找到内，浪费了时间复杂度）
func sortedSquares(nums []int) []int {
	minAbsNum := abs(nums[0])
	indexMinAbs := 0
	for i := 1; i < len(nums); i++ {
		if abs(nums[i]) < minAbsNum {
			minAbsNum = abs(nums[i])
			indexMinAbs = i
		}
	}

	p, q := indexMinAbs-1, indexMinAbs+1 //	p往左，q往右
	res := []int{minAbsNum * minAbsNum}
	for p >= 0 && q < len(nums) {
		if abs(nums[p]) >= abs(nums[q]) {
			res = append(res, nums[q]*nums[q])
			q++
		} else {
			res = append(res, nums[p]*nums[p])
			p--
		}
	}
	for p >= 0 {
		res = append(res, nums[p]*nums[p])
		p--
	}
	for q < len(nums) {
		res = append(res, nums[q]*nums[q])
		q++
	}
	return res
}

func abs(x int) int {
	if x < 0 {
		return -x
	} else {
		return x
	}
}

//双指针，升级版本
//一次遍历
func sortedSquares0(nums []int) []int {
	res := make([]int, len(nums))
	k := len(res) - 1
	left, right := 0, len(nums)-1
	for left <= right {
		if abs(nums[left]) >= abs(nums[right]) {
			res[k] = nums[left] * nums[left]
			k--
			left++
		} else {
			res[k] = nums[right] * nums[right]
			k--
			right--
		}
	}
	return res
}

func sortedSquares1(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		nums[i] = nums[i] * nums[i]
	}
	sort.Ints(nums)
	return nums
}
