package 动态规划

import "sort"

func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	dp := make([][]int, n) //dp[i][j]表示i，j位置的下降路径最小和
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
	}
	//初始化dp的初始值
	for i := 0; i < n; i++ {
		dp[0][i] = matrix[0][i]
	}
	//下面开始实现动态规划的转移方程
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			if j == 0 {
				dp[i][j] = matrix[i][j] + min(dp[i-1][0], dp[i-1][1])
			} else if j == n-1 {
				dp[i][j] = matrix[i][j] + min(dp[i-1][n-1], dp[i-1][n-2])
			} else {
				dp[i][j] = matrix[i][j] + min3(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
			}
		}
	}
	x := dp[n-1]
	sort.Ints(x)
	return x[0]
}

func min3(a, b, c int) int {
	if a <= b && a <= c {
		return a
	}
	if b <= a && b <= c {
		return b
	}
	if c <= a && c <= b {
		return c
	} else {
		return c
	}

}
