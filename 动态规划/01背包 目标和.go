package 动态规划

//对nums数组中的所有数进行+ -（不改变nums顺序），使得最后结果为target，一共有几种方案

//转化为01背包问题，找到一个正子集，剩下的数组成负子集，使得正子集负子集之和为target （正子集和负子集的大小其实已经固定）
//有一个容量为正子集大小的背包，恰好装满这个背包，一共有多少种方案

func findTargetSumWays(nums []int, target int) int {
	var sum int
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if abs(target) > sum {
		return 0
	}
	if (sum+target)%2 != 0 {
		return 0
	}
	bagCapacity := (sum + target) / 2 //任意从nums[]中取，有几种方法（相同的数不同的下标也可以）能把背包填满

	dp := make([]int, bagCapacity+1) // dp[j]：当前从nums[0]~nums[i]中任意取，当前背包容量为j，那么填满背包共有dp[j]种方案

	//当前遍历到物品i了。
	//如果放不下物品i，则填满背包是有dp[j]种方法（从0～i-1任选物品放满背包本来就有dp[j]种方法）；
	//如果能放下物品i，则填满背包有
	//dp[j] （不选择物品i，从0～i-1物品中任选物品放满背包本来就有dp[j]种方法） + dp[j-nums[i]] （选择物品i，背包容量还剩j-nums[i],从0～i-1物品中任选物品放入背包有dp[j-nums[i]种方法）
	//种方法

	//初始化dp数组
	dp[0] = 1                   //放满空背包有几种方法？
	if bagCapacity >= nums[0] { //当前背包仅能放nums[0],那么只有背包容量恰好为nums[0]时，放满背包才会有一种方法
		dp[nums[0]] += 1 //注意：当dp[0]=1时，如果nums[0]=0,那么放空背包有几种方法呢？一种是不放，一种是放0
	}

	//
	for i := 1; i < len(nums); i++ { //遍历物品
		//当前遍历到物品i,当前的dp[j]代表：背包容量为j时，从0～i-1任选物品，放满背包的方法有dp[j]种
		for j := bagCapacity; j >= nums[i]; j-- { //当背包j放得下物品i时，容量为j的背包装满的方案（0～i-1）还要加上放入nums[i]之后的那些方案dp[j-nums[i]]
			dp[j] = dp[j] + dp[j-nums[i]]
		} //如果背包j放不下物品i，那么容量为j的背包本来装满的方案有dp[j]种，你nums[i]对其不产生影响，在遍历完nums[i]之后，装满背包j的方案仍为dp[j]
	}

	return dp[bagCapacity]
}

func abs(x int) int {
	if x > 0 {
		return x
	} else {
		return -x
	}
}
