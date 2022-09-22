package 回溯

import "sort"

//nums中可能有重复元素，找出他的所有子集

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	var res [][]int
	var path []int
	res = append(res, []int{})
	var backtracking func(startIndex int)
	backtracking = func(startIndex int) {
		if startIndex == len(nums) { //到达叶子结点了
			return
		}
		for i := startIndex; i < len(nums); i++ {
			//对当前节点的处理阶段
			if i > startIndex && nums[i] == nums[i-1] { //树层去重，在一层中path有不同的选择，如果碰到重复的选择，那么就发生了重复的结果
				continue
			} else {
				path = append(path, nums[i])
				tmp := make([]int, len(path))
				copy(tmp, path)
				res = append(res, tmp)
			}
			//当前是否到达叶子结点？
			backtracking(i + 1) //当前path取到nums【i】了，下面一层从nums【i+1】开始取，当然如果 i+1=len（nums），则说明当前已经在叶子节点了，会直接return
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0)

	return res
}
