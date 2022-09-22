package 动态规划

import "fmt"

//01背包问题中，一维dp数组的两个for循环先后循序一定是 先遍历物品， 再遍历背包容量。

//所谓的状态压缩 ， 空间优化
func test_1_wei_bag_problem1(weight, value []int, bagweight int) int {
	dp := make([]int, bagweight+1) // dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
	//dp[j]= max(dp[j],dp[j-weight[i]+value[i]]) 一维数组 尼玛 引入了i？ 哦哦，原来i一样是值得第i个物品
	//dp 数组初始化
	dp[0] = 0
	//
	for i := 0; i < len(weight); i++ {

		//j不能从左到到右遍历的原因
		//当前dp数组保留了对于从0～i-1个物品最优装背包情况的历史状态
		//注意到dp[j]的推导用到了dp[j-weight[i]]，dp[j]的推导用到了它左边的元素
		//而用到的左边元素必须要求是历史状态的，即对于0～i-1这些物品的最优背包情况
		//如果从左到右遍历，那么左边的dp就会被更新为关于0～i物品的最优背包情况
		//一旦dp[j]需要参考dp[j-weight[i]]时，他参考的dp[j-weight[i]]已经不是原来的dp[j-weight[i]]了

		for j := bagweight; j >= 0; j-- {

			//对于物品i，当前的背包容量为j；你只有两个选择，放i和不放i
			//取dp[j]就是不放i，取dp[j-weight[i]]+value[i]就是放i
			if j < weight[i] { //这里代码还可以优化的
				dp[j] = dp[j]
			} else {
				dp[j] = max(dp[j], dp[j-weight[i]]+value[i])
			}
		}
		fmt.Printf("%v\n", dp)
	}

	return dp[bagweight]
}

func main() {
	weight := []int{1, 3, 4}
	value := []int{15, 20, 30}
	bagweight := 4
	test_1_wei_bag_problem1(weight, value, bagweight)

}
