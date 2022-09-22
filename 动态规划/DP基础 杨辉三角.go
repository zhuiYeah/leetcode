package 动态规划

func generate(numRows int) [][]int {
	dp := make([][]int, numRows) //dp数组就是杨辉三角形
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, i+1)
	}
	//初始化dp数组
	for i := 0; i < len(dp); i++ {
		dp[i][0] = 1
		dp[i][len(dp[i])-1] = 1
	}
	//dp[i][j]=dp[i-1][j-1] + dp[i-1][j]
	for i := 2; i < len(dp); i++ {
		for j := 1; j < len(dp[i])-1; j++ {
			dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
		}
	}

	return dp
}
