package 动态规划

//s的子序列有多少种是 跟t完全一样的

func numDistinct(s string, t string) int {
	dp := make([][]int, len(s)+1)
	//dp[i][j] : 以i-1为结尾的s子序列 出现 以j-1结尾的t的个数 为  dp[i][j]
	//换句话说 s[:i]的子序列中出现 t[:j] 的个数为 dp[i][j]
	//dp[i][j] 当前遍历到s的下标i-1，和t的下标j-1啦

	///如果s[i-1]!=t[j-1] 那么你s多出来的这一个字母s[i-1]对于构造t[0]~t[j-1]子序列是毫无帮助的,有没有你s[i-1]都一样
	//dp[i][j]=dp[i-1][j]

	///如果s[i-1]==t[j-1]  那么你s多出来的这一个字母s[i-1]对于构造t[0]~t[j-1]子序列是一定能派上用场的，1⃣️选择用s[i-1]构造子序列，2⃣️不选择用s[i-1]构造子序列
	// dp[i][j]=dp[i-1][j-1] + dp[i-1][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(t)+1)
	}

	//初始化 dp数组 dp[i][0]全为1 比较难理解 构造出一个空序列只有一种办法？
	for i := 0; i < len(dp); i++ {
		dp[i][0] = 1
	}

	for i := 1; i < len(dp); i++ {
		for j := 1; j < len(dp[0]); j++ {
			if s[i-1] == t[j-1] {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return dp[len(s)][len(t)]
}
