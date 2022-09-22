package DFS和BFS

//不就是岛屿数量么？

func countBattleships(board [][]byte) int {
	m := len(board)
	n := len(board[0])
	count := 0
	var dfs func(int, int)
	dfs = func(i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '.' {
			return
		}
		board[i][j] = '.'
		dfs(i-1, j)
		dfs(i+1, j)
		dfs(i, j-1)
		dfs(i, j+1)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'X' {
				count++
				dfs(i, j)
			}
		}
	}
	return count
}
