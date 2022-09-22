package 动态规划

import "sort"

//三角形从顶走到底，他的最小路径之和

func minimumTotal(triangle [][]int) int {
	dp := make([][]int, len(triangle))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(triangle[i]))
	}
	//dp[i][j]表示走到i，j位置的最小开销
	//下面找到dp[i][j]的初始值和边界值
	dp[0][0] = triangle[0][0]
	for i := 1; i < len(dp); i++ { //从第一行开始，初始化每一行的第一个和最后一个元素（他们的路径是唯一的）
		dp[i][0] = dp[i-1][0] + triangle[i][0]
		dp[i][len(dp[i])-1] = dp[i-1][len(dp[i-1])-1] + triangle[i][len(triangle[i])-1]
	}

	for i := 2; i < len(dp); i++ { //为什么从第二行开始？自己画dp图出来就知道了
		for j := 1; j < len(dp[i])-1; j++ {
			dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j] //转移方程画图可知
		}
	}

	x := dp[len(dp)-1]

	sort.Ints(x)
	return x[0]
}
