package 回溯

//从1～9之中找到 k个数 使他们和为n （每个数只能使用一次）

func combinationSum3(k int, n int) [][]int {
	res = [][]int{}
	if n <= 0 || k <= 0 || k > 9 || n > 45 {
		return res
	}
	backtrack(k, n, 1, 0, []int{}) //找到k个数和为n，当前从1开始找，当前path为空,当前路径和为0
	return res
}

func backtrack(k, n, start int, sum int, path []int) {
	if len(path) == k { //叶子节点 写入搜索结果
		if sum == n {
			tmp := make([]int, k)
			copy(tmp, path)
			res = append(res, tmp)
		}
		return
	}
	if sum > n { //剪枝
		return
	}
	for i := start; i <= 9; i++ { //假设目前start是1
		//对节点的处理阶段
		sum += i
		path = append(path, i)
		//是否到达叶子结点，是否需要剪枝？
		backtrack(k, n, i+1, sum, path) //下一层从2 开始横向搜索 ，这个函数判断是否需要回溯
		//回溯阶段
		sum -= i
		path = path[:len(path)-1]
	}
}
