package 动态规划

//找到一个 二进制数组 的最大子集，是的这个子集中0的数目小于m，1的数目小于n

//01背包问题，背包维度为m*n，对于每一个strs[i]更新一次背包

func findMaxForm(strs []string, m int, n int) int {
	dp := make([][]int, m+1) //dp[i][j]:当前背包0的上限为i，1的上限为j，从strs[0]~strs[k]任意放入字符串，放入的最多字符串个数为dp[i][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, n+1)
	}

	//对于字符串i，只有放入背包和不放入背包两种  其0的个数为zeroNum，1的个数为oneNum
	//放入背包：dp[i][j] = dp[i-zeroNum][j - oneNum] + 1
	//不放背包： 即使遍历完字符串i了，放入的最多字符串个数仍为dp[i][j]
	//so dp[i][j] = max(dp[i-zeroNum][j - oneNum] + 1,dp[i][j])

	//初始化 dp数组
	zeroNum, oneNum := getZeroOne(strs[0])
	for i := m; i >= zeroNum; i-- {
		for j := n; j >= oneNum; j-- {
			dp[i][j] = 1
		}
	}

	//
	for k := 1; k < len(strs); k++ { //遍历物品（字符串）
		zeroNum, oneNum = getZeroOne(strs[k])
		for i := m; i >= zeroNum; i-- { //只有放得下strs[k]字符串容量才需要讨论，对应的dp[i][j]才会被更新
			for j := n; j >= oneNum; j-- {
				dp[i][j] = max(dp[i][j], dp[i-zeroNum][j-oneNum]+1)
			}
		}
	}
	return dp[m][n]
}

func getZeroOne(s string) (int, int) {
	var x, y int
	for i := 0; i < len(s); i++ {
		if s[i] == '0' {
			x++
		} else if s[i] == '1' {
			y++
		}
	}
	return x, y
}
