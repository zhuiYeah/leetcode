package 动态规划

//同 DP 最长公共子序列

func maxUncrossedLines(nums1 []int, nums2 []int) int {
	dp := make([][]int, len(nums1)+1)
	//dp[i][j] :
	//当前nums1的下标为i-1，nums2的下标为j-1, 此时的最长公共子序列为dp[i][j]
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(nums2)+1)
	}
	for i := 1; i < len(dp); i++ { //遍历nums1
		for j := 1; j < len(dp[0]); j++ { //遍历nums2
			if nums1[i-1] == nums2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[len(nums1)][len(nums2)]
}
