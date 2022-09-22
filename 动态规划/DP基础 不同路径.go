package 动态规划

//从一个m*n的网格左上角走到右下角，一共有多少种路径

func uniquePaths(m int, n int) int {

	dp := make([][]int, m) //dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	//递推方程：dp[i][j]=dp[i-1][j] + dp[i][j-1]

	//初始化dp数组
	//dp第零行全部为1
	for i := 0; i < n; i++ {
		dp[0][i] = 1
	}
	//dp数组第零列全部为1
	for i := 0; i < m; i++ {
		dp[i][0] = 0
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}

	return dp[m-1][n-1]
}
