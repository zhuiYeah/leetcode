package 回溯

import "sort"

//nums可能包含重复数字 ， 找出nums的所有全排列

func permuteUnique(nums []int) [][]int {
	var res [][]int
	var path []int
	sort.Ints(nums)
	var backtracking func([]int)
	backtracking = func(array []int) {
		if len(path) == len(nums) { //叶子节点
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}
		for i := 0; i < len(array); i++ {
			var trimmedArray []int               //这个数组存放去掉nums[i]之后的trimmedNums，即下一层需要搜索的数组
			if i > 0 && array[i] == array[i-1] { //树层去重
				continue
			} else {
				path = append(path, array[i])
				for j := 0; j < len(array); j++ {
					if j != i {
						trimmedArray = append(trimmedArray, array[j])
					}
				}
			}
			//当前是否到达叶子节点了？
			backtracking(trimmedArray)
			//
			path = path[:len(path)-1]
		}
	}
	backtracking(nums)
	return res
}

//利用used记录nums中已经使用过的元素，题解给的方法
func permuteUnique0(nums []int) [][]int {
	var res [][]int
	var path []int
	sort.Ints(nums)
	used := [8]int{}
	var backtracking func(used [8]int)
	backtracking = func(used [8]int) {
		if len(path) == len(nums) { //叶子节点
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}

		for i := 0; i < len(nums); i++ {
			if i > 0 && nums[i] == nums[i-1] { //横向 树层去重
				continue
			}
			if used[i] == 1 { //这个点我path之前已经用过了哈 纵向
				continue
			}
			path = append(path, nums[i])
			used[i] = 1
			//
			backtracking(used)
			//
			used[i] = 0
			path = path[:len(path)-1]

		}
	}
	backtracking(used)
	return res
}
