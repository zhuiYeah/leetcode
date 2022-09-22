package 动态规划

func climbStairs(n int) int {
	dp := make([]int, n+2) //dp[i]： 爬到第i层楼梯，有dp[i]种方法
	//确定递推公式：dp[n]= dp[n-1] + dp[n-2] //爬到第n节楼梯，要么从n-1节爬上来，要么从n-2节爬上来
	//初始化dp数组
	dp[0] = 0
	dp[1] = 1
	dp[2] = 2
	//dp[1]=1  爬一层楼梯只有一种爬法
	//dp[2]=2  爬两层楼梯有两种爬法

	//开始动态规划
	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}

	return dp[n]
}
