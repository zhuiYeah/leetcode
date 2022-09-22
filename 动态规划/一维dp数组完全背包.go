package 动态规划

import "fmt"

//完全背包问题，物品是无限的，可以无限放

//在完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序无所谓！（除了在求填满背包的排序总和/组合总和时）

func test_1_wei_bag_problem2(weight, value []int, bagweight int) int {
	dp := make([]int, bagweight+1) // dp[j]:背包容量为j时，背包所能容纳的最大价值
	// 当前遍历到物品i时，物品i放或者不放？放的话？放多少呢？
	//dp[j]= max(dp[j],dp[j-weight[i]+value[i]])
	//等式左边的dp[j],指的是物品0～i任意取，得到的j背包最大价值
	//等式右边的dp[j],指的是物品0～i-1任意取，得到的j背包最大价值（不放入物品i）
	//dp[j-weight[i]] 对背包容量的遍历采取从左到右，从小到大，
	//这使得用到的左边的dp[j-weight[i]]指的是物品0～i任意取，背包j-weight[i]的最大价值（背包j-weight[i]中可能已经放入物品i了），此时如果再放入物品i的话，就是多次放入物品i
	dp[0] = 0
	for i := 0; i < len(weight); i++ { //遍历物品
		for j := weight[i]; j <= bagweight; j++ { //从放的下物品i的背包开始由小到大遍历背包，放不下物品i的dp[j]不变
			dp[j] = max(dp[j], dp[j-weight[i]]+value[i])
		}
		fmt.Printf("%v\n", dp)
	}
	return dp[bagweight]
}

func main() {
	weight := []int{1, 3, 4}
	value := []int{15, 20, 30}
	bagweight := 4
	test_1_wei_bag_problem2(weight, value, bagweight)

}
