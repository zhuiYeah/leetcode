package DFS和BFS

func islandPerimeter(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var dfs func(i, j int) int
	dfs = func(i, j int) int {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 { //碰到湖水或者边界，能为岛屿的周长贡献1
			return 1
		}
		if grid[i][j] == 114514 { //表示已经访问过岛屿的这块区域了
			return 0
		}
		grid[i][j] = 114514 //标记为已访问
		return dfs(i-1, j) + dfs(i+1, j) + dfs(i, j-1) + dfs(i, j+1)
	}
	var res int
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				res = dfs(i, j)
				break
			}
		}
	}
	return res
}
