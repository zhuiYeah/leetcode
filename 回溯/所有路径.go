package 回溯

func allPathsSourceTarget(graph [][]int) [][]int {
	n := len(graph)
	var res [][]int
	var path []int
	var backtracking func(curPoint int)
	backtracking = func(curPoint int) {
		path = append(path, curPoint)
		if curPoint == n-1 { //叶子节点，找到一个结果啦
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}
		for i := 0; i < len(graph[curPoint]); i++ {
			//进入更深层
			backtracking(graph[curPoint][i])
			//回溯
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}

//
//之前写的一段dfs的代码与刚写的backtracking一模一样
func allPathsSourceTarget0(graph [][]int) [][]int {
	n := len(graph)
	var res [][]int
	var path []int
	var dfs func(curPoint int)
	dfs = func(curPoint int) {
		path = append(path, curPoint)
		if curPoint == n-1 {
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}
		for i := 0; i < len(graph[curPoint]); i++ {
			//
			dfs(graph[curPoint][i])
			//
			path = append(path[:len(path)-1], path[len(path):]...)
		}
	}
	dfs(0)
	return res
}
