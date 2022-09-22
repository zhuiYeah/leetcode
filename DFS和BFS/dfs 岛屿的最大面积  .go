package DFS和BFS

func maxAreaOfIsland(grid [][]int) int {
	maxArea := 0
	m := len(grid)    //行
	n := len(grid[0]) //列

	var countArea func(int, int) int

	countArea = func(i, j int) int {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
			return 0
		}
		grid[i][j] = 0 //淹没法
		return countArea(i-1, j) + countArea(i+1, j) + countArea(i, j-1) + countArea(i, j+1) + 1
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				maxArea = max(maxArea, countArea(i, j))
			}
		}
	}

	return maxArea
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
