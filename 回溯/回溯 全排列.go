package 回溯

//给定一个无重复数字的nums数组 ，返回他的所有的全排列

func permute(nums []int) [][]int {
	var res [][]int
	var path []int
	var backtracking func()
	backtracking = func() {
		if len(path) == len(nums) { //叶子节点
			tmp := make([]int, len(nums))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}
		for i := 0; i < len(nums); i++ {
			//节点处理
			if !IsThereARepetition(nums[i], path) { //num[i]必须要是当前path中不存在的才能写入path，如果存在的话，往右查找下一个
				path = append(path, nums[i])
			} else {
				continue
			}
			//当前是否到达叶子结点？
			backtracking()
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking()
	return res
}

func IsThereARepetition(num int, path []int) bool { //num这个数包含在path数组中吗？
	for i := 0; i < len(path); i++ {
		if num == path[i] {
			return true
		}
	}
	return false
}
