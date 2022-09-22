package 动态规划

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
func maximalSquare(matrix [][]byte) int {
	m := len(matrix)
	n := len(matrix[0])
	dp := make([][]int, m)
	maxArea := 0
	//dp[i][j] ： 必须选择i，j位置构成正方形，则此时构成的正方形的变长为dp[i][j]
	//dp[i][j]= {开根号：min(左，上，左上) +1}*2
	//初始化
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, n)
	}
	for j := 0; j < n; j++ {
		if matrix[0][j] == '1' {
			dp[0][j] = 1
			maxArea = 1
		}
	}
	for i := 0; i < m; i++ {
		if matrix[i][0] == '1' {
			dp[i][0] = 1
			maxArea = 1
		}
	}
	//开始动态规划
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if matrix[i][j] == '1' {
				sideLength := min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]))
				dp[i][j] = sideLength + 1
				x := dp[i][j]
				if x*x > maxArea {
					maxArea = x * x
				}
			}
		}
	}
	return maxArea
}
