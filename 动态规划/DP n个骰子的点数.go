package 动态规划

func dicesProbability(n int) []float64 {
	dp := make([][]float64, n+1)
	//dp[i][j]，骰子总数为i个时，骰子总和为j的概率为dp[i][j]
	//dp[i][j]={dp[i-1][j-1]+...+dp[i-1][j-6]}  * 1/6
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]float64, 6*n+1)
	}
	for j := 1; j <= 6; j++ {
		dp[1][j] = 1.0 / 6.0
	}
	for i := 2; i <= n; i++ {
		for j := i; j <= 6*i; j++ { //如果骰子个数为i的话，那么傻子总和最小为i，最大为6*i
			tmp := 0.0
			k := j - 1
			boundary := j - 6
			for ; k >= 1 && k >= boundary; k-- {
				tmp += dp[i-1][k]
			}
			dp[i][j] = tmp * 1.0 / 6.0
		}
	}
	return dp[n][n:]
}
