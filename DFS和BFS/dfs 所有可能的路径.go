package DFS和BFS

//这dfs跟回溯一模一样
func allPathsSourceTarget(graph [][]int) [][]int {
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
		//dfs第一次写到for循环
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

func main() {
	xx := [][]int{}
	xx = append(xx, []int{1, 2})
	xx = append(xx, []int{3})
	xx = append(xx, []int{3})
	xx = append(xx, []int{})
	allPathsSourceTarget(xx)
}
