package 动态规划

//路径上有障碍物，从左上角走到右下角的所有路径一共有几条？

func uniquePathsWithObstacles(obstacleGrid [][]int) int {

	dp := make([][]int, len(obstacleGrid)) //dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(obstacleGrid[0]))
	}
	//dp[i][j]表示走到i行j列一共有几条路径
	var i int
	for i = 0; i < len(obstacleGrid[0]); i++ { //搜索路径上第0行第i列是否有障碍物
		if obstacleGrid[0][i] == 1 {
			break
		}
	}
	//初始化dp的第0行
	for j := 0; j < i; j++ {
		dp[0][j] = 1
	}
	for i = 0; i < len(obstacleGrid); i++ { //搜索路径上第i行第0列是否有障碍物
		if obstacleGrid[i][0] == 1 {
			break
		}
	}
	//初始化dp的第0列
	for j := 0; j < i; j++ {
		dp[j][0] = 1
	}
	//开始动态规划
	for i = 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if obstacleGrid[i][j] == 1 { //如果i，j位置有障碍物的话，这个位置必不可能到达
				continue
			} else { // 如果i，j没有障碍物，那么他是有可能到达的
				dp[i][j] = dp[i-1][j] + dp[i][j-1]
			}
		}
	}
	return dp[len(obstacleGrid)-1][len(obstacleGrid[0])-1]

}
