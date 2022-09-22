package 动态规划

//求长为n的绳子剪成m段之后的最大乘积
func cuttingRope(n int) int {
	dp := make([]int, n+1) //dp的含义不用我多逼逼了
	dp[2] = 1
	for i := 3; i <= n; i++ {
		localMaximum := 0
		for ropeLength := 1; ropeLength <= i/2; ropeLength++ {
			localMaximum = max(localMaximum, max(ropeLength*(i-ropeLength), ropeLength*dp[i-ropeLength]))
		}
		dp[i] = localMaximum
	}
	return dp[n]
}

//处理大数
func cuttingRop1e(n int) int {
	dp := make([]int, n+1) //dp的含义不用我多逼逼了
	dp[2] = 1
	for i := 3; i <= n; i++ {
		localMaximum := 0
		for ropeLength := 1; ropeLength <= i/2; ropeLength++ {
			x := (ropeLength * (i - ropeLength)) % (1e9 + 7)
			y := (ropeLength * dp[i-ropeLength]) % (1e9 + 7)
			localMaximum = max(localMaximum, max(x, y))
		}
		dp[i] = localMaximum
	}
	return dp[n]
}
