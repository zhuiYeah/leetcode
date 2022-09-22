package DFS和BFS

func numEnclaves(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var dfs func(int, int)
	dfs = func(i int, j int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
		if grid[i][j] == 0 { //这一边被水挡住了，这一边是封闭的
			return
		}
		//能走到这个位置grid[i][j]一定是1了，即还是陆地，是能接触到边缘的陆地
		grid[i][j] = 0
		//淹没这片陆地的上下左右
		dfs(i-1, j)
		dfs(i+1, j)
		dfs(i, j-1)
		dfs(i, j+1)
	}
	//淹没能接触到边缘的所有陆地
	for j := 0; j < n; j++ {
		if grid[0][j] == 1 {
			dfs(0, j)
		}
		if grid[m-1][j] == 1 {
			dfs(m-1, j)
		}
	}
	for i := 0; i < m; i++ {
		if grid[i][0] == 1 {
			dfs(i, 0)
		}
		if grid[i][n-1] == 1 {
			dfs(i, n-1)
		}
	}
	//接下来岛屿中所剩的所有陆地都是孤立陆地
	res := 0
	for i := 1; i < m-1; i++ {
		for j := 1; j < n-1; j++ {
			if grid[i][j] == 1 { //是陆地
				res++
			}
		}
	}
	return res
}
