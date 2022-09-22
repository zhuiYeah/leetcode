package 动态规划

//找到nums1和nums2中最长公共子数组的长度

func findLength(nums1 []int, nums2 []int) int {
	dp := make([][]int, len(nums1))
	//dp[i][j] : 当前位于nums1的下标i，nums2的下标j处，公共子数组的最后一个元素选取nums[i],nums[j],此时公共子数组的长度
	//如果nums[i]等于nums[j]，那么dp[i][j]=dp[i-1][j-1]+1
	//如果nums[i]不等于nums[j] 则dp[i][j]=0
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(nums2))
	}
	res := 0
	//初始化dp数组
	for j := 0; j < len(nums2); j++ { //遍历nums2,看看是否与nums1[0]相同，相同的话，可以构成一个长为1的公共子数组
		if nums2[j] == nums1[0] {
			dp[0][j] = 1
			res = 1
		}

	}
	for i := 0; i < len(nums1); i++ {
		if nums1[i] == nums2[0] {
			dp[i][0] = 1
			res = 1
		}
	}

	//
	for i := 1; i < len(nums1); i++ { //遍历nums1
		for j := 1; j < len(nums2); j++ { //遍历nums2
			if nums1[i] == nums2[j] {
				dp[i][j] = dp[i-1][j-1] + 1
			}
			if dp[i][j] > res {
				res = dp[i][j]
			}
		}
	}
	return res
}
