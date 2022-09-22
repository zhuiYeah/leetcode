package 动态规划

//从矩阵左上角走到右下角的最小路径和

func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, n)
	}
	//dp[i][j]代表走到i，j位置的最小开销
	//找出初始值
	dp[0][0] = grid[0][0]
	for i := 1; i < n; i++ { //初始化dp的第0行
		dp[0][i] = dp[0][i-1] + grid[0][i]
	}
	for i := 1; i < m; i++ { //初始化dp的第0列
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	//开始动态规划
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j] //到当前位置的最小开销=min（到左边的最小开销，到上边的最小开销）+当前位置开销
		}
	}
	return dp[m-1][n-1]
}
