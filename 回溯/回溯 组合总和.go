package 回溯

//重复利用candidates中的元素，找到和为target的所有组合

func combinationSum(candidates []int, target int) [][]int {
	var res [][]int
	var backtrack func(startIndex, currentSum int, path []int)
	backtrack = func(startIndex, currentSum int, path []int) {
		if currentSum > target { //剪枝
			return
		}
		if currentSum == target { //找到叶子节点
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
		}
		for i := startIndex; i < len(candidates); i++ {
			//处理当前节点candidates[i]
			path = append(path, candidates[i])

			//是否需要回溯呢？是否需要剪枝呢？是否到达了叶子节点呢？ 是：进入下一步回溯  否：进入递归，进行深度搜索
			backtrack(i,currentSum + candidates[i], path) //因为允许重复元素，所以从当前的i开始搜索

			//回溯

			//currentSum -= candidates[i]，当前和已经被维护，不需要回溯
			path = path[:len(path)-1]
		}
	}
	backtrack(0, 0, []int{})
	return res
}
