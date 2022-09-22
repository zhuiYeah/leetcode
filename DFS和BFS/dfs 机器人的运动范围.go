package DFS和BFS

func movingCount(m int, n int, k int) int {
	res := 0
	visited := make([][]bool, m)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, n)
	}
	var dfs func(i int, j int)
	dfs = func(i int, j int) {
		if i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true {
			return
		}
		if countNum(i, j) > k { //机器人的参数k到不了这个点
			visited[i][j] = true //即使到不了这个点，也标记一下，避免dfs调用countNum进行重复计算
			return
		}
		//现在机器人能到达这个点了
		visited[i][j] = true
		res++
		dfs(i-1, j)
		dfs(i+1, j)
		dfs(i, j-1)
		dfs(i, j+1)
	}
	dfs(0, 0)
	return res
}

func countNum(i, j int) int {
	res := 0
	for i != 0 {
		res += i % 10
		i /= 10
	}
	for j != 0 {
		res += j % 10
		j /= 10
	}
	return res
}
