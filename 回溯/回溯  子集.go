package 回溯

//找出一个数组的所有子集

//本题目不在叶子节点存放结果，而是应该在搜索的每一步都放入结果
func subsets(nums []int) [][]int {
	var res [][]int
	var path []int
	res = append(res, []int{})
	var backtracking func(startIndex int)
	backtracking = func(startIndex int) {
		//本题其实可以不需要加终止条件，因为startIndex >= nums.size()，本层for循环本来也结束了，本来我们就要遍历整棵树。
		if startIndex == len(nums) { //叶子节点 ，本题其实不需要加入终止条件，因为startIndex == len(nums)是，那个for循环是不会进入的，本层backtracking结束直接回溯了
			return
		}
		for i := startIndex; i < len(nums); i++ {
			//对当前节点的处理阶段
			path = append(path, nums[i])
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			//当前是否到达叶子节点？是否需要回溯？ 是：进行下一步回溯 否：进入递归，扩充path的长度
			backtracking(i + 1)
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}
