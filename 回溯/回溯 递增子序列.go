package 回溯

//给定一个！无序！的数组，找出他的所有递增子序列

//nums[i]==num[i-1]这样的树层去重方法仅能用于有序的数组，相同的数字是排列在一起的。如果相同的数字不在一起呢？

//新的树层去重
//对于无序数组的子集问题的去重办法，在每一层的for循环之上，建立一个hashmap
//，记录这一层的path路径已经选择过的元素，如果已经选择过，则直接continue下一个
func findSubsequences(nums []int) [][]int {
	var res [][]int
	var path []int
	var backtracking func(startIndex int) //从nums【startIndex】开始选择
	backtracking = func(startIndex int) {
		if startIndex == len(nums) { //backtracking之前的状态已经到达叶子节点了，不要再往下和往右搜索了
			return
		}

		HasThisFloorEverAppeared := map[int]bool{} //本哈希表记录了这一层中path已经选择过的元素，就不要重复再选了
		for i := startIndex; i < len(nums); i++ {
			//对当前节点的处理 ，当前如果是第一层，那么在不重复的情况下写入path，但不把path写入res；否则往右找下一点
			//如果是后面的层次，在满足递增且不重复的情况下写入path，并将path写入res；否则继续往右找
			if len(path) == 0 {
				if HasThisFloorEverAppeared[nums[i]] == false {
					path = append(path, nums[i])
					HasThisFloorEverAppeared[nums[i]] = true
				} else {
					continue
				}
			} else {
				if nums[i] >= path[len(path)-1] && !HasThisFloorEverAppeared[nums[i]] { //满足递增子序列，写入path
					path = append(path, nums[i])
					tmp := make([]int, len(path))
					copy(tmp, path)
					res = append(res, tmp)
					HasThisFloorEverAppeared[nums[i]] = true
				} else {
					continue
				}
			}
			//当前是否已经是叶子节点了？ 如果i是len（nums）-1，那么就是叶子结点
			backtracking(i + 1)
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}
