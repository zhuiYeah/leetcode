package 动态规划

import (
	"math"
	"sort"
)

//本题存在着全新的概念 移动代价，每次往下移动一格，都要付出一定的额外代价

//本题动态规划转移方程 dp[i][j] = min{ dp[i-1][all] + moveCost[grid[i-1][all]][j] } + grid[i][j]

func minPathCost(grid [][]int, moveCost [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m) //dp[i][j]表示下沉到i，j位置付出的最小代价
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	//dp的一些初始值
	for i := 0; i < n; i++ {
		dp[0][i] = grid[0][i]
	}
	//开始动态规划！
	for i := 1; i < m; i++ {
		for j := 0; j < n; j++ {
			//当前位置在 i j ，当前任务是求出dp[i][j]
			x := math.MaxInt         //x储存上一层跳转到i，j的最小开销 即 min(跳转开销+到达i-1，k开销)
			for k := 0; k < n; k++ { //遍历上一层的所有 i-1 k
				//这里grid[i-1][k]就是i-1层中第k个元素的大小，
				//j表示上一层该k点要跳转至i层j列
				//moveCost[grid[i-1][k]][j]表示从i-1，k跳转至i，j的跳转开销
				cost := dp[i-1][k] + moveCost[grid[i-1][k]][j]
				x = min(x, cost)
			}
			dp[i][j] = grid[i][j] + x
		}
	}

	x := dp[m-1]
	sort.Ints(x)
	return x[0]
}
