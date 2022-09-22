package 动态规划

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的二叉搜索树 有多少种？

func numTrees(n int) int {
	dp := make([]int, n+1) // dp[i] : i个节点的二叉搜索树共有 dp[i]种互不相同的表达方式
	//递推方程: dp[i]= 求和（j从 0 to i - 1）dp[j]*dp[i-1-j] (纯自己推导的)
	dp[0] = 1 //别问为什么，自己想想
	dp[1] = 1
	for i := 2; i <= n; i++ {
		for j := 0; j <= i-1; j++ {
			dp[i] += dp[j] * dp[i-1-j]
		}
	}

	return dp[n]
}
