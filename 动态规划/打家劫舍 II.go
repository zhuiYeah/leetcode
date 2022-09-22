package 动态规划

//你是个小偷，不能偷盗相邻的房屋（所有的房屋组成一个环），你能偷盗的最大数量财产是多少

////写这一题时，我在想打劫到最后一家时，如果选择打劫最后一家，就不能打劫第一家，就要删掉打劫第一家的金额，
////但是呢？我这时候怎么知道有没有打劫第一家？  其实算到dp[2]的时候，你已经知道了第一家是否被打劫了
//func rob1(nums []int) int {
//	n := len(nums) // 一共有n户人家
//	if n == 1 {
//		return nums[0]
//	}
//	dp := make([]int, n) //dp[i]:打劫0～i户人家，打劫最多的钱财为dp[i]
//	//最后一户单独讨论
//	//其余的情况下，dp[i]=max(dp[i-1],dp[i-2]+nums[i])
//
//	//初始化dp
//	dp[0] = nums[0]
//	dp[1] = max(nums[0], nums[1])
//	dp[2] = max(dp[1], dp[0]+nums[2])
//	var x bool                      //x标记了是否打劫第一户
//	if nums[1] >= nums[0]+nums[2] { //不选择打劫第一户
//		x = false
//	} else {
//		x = true
//	}
//	for i := 3; i < n-1; i++ {
//		dp[i] = max(dp[i-1], dp[i-2]+nums[i])
//	}
//
//	if x == false { //没有打劫第一家
//		dp[n-1] = max(dp[n-2], dp[n-3]+nums[n-1])
//	} else {
//		dp[n-1] = max(dp[n-2], dp[n-3]+nums[n-1]-nums[0])
//	}
//
//	return dp[n-1]
//}

//第1间与第n间是绝对排斥的 考虑1就绝对不考虑n 考虑n就绝对不考虑1
//考虑两种可能 ： 从1～n-1间偷窃 ， 从 2～n间偷窃 ，比较两种偷窃方案谁偷的更多
func rob1(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		return max(nums[0], nums[1])
	}
	var robberyPlan func([]int) int
	robberyPlan = func(nums []int) int {

		dp := make([]int, len(nums))
		dp[0] = nums[0]
		dp[1] = max(nums[0], nums[1])
		for i := 2; i < len(nums); i++ {
			dp[i] = max(dp[i-1], dp[i-2]+nums[i])
		}
		return dp[len(nums)-1]
	}
	return max(robberyPlan(nums[:len(nums)-1]), robberyPlan(nums[1:]))
}
