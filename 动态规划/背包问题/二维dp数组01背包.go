package 背包问题

import "fmt"

func test_2_wei_bag_problem1(weight, value []int, bagweight int) int {
	dp := make([][]int, len(weight)) //dp[i][j] : 背包容量为j时，物品0～物品i 任意取，背包里能装的最大价值
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, bagweight+1)
	}
	//dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]])
	//初始化dp数组
	for j := bagweight; j >= weight[0]; j-- {
		dp[0][j] = value[0]
	}
	//从左到右，从上到下的遍历顺序的可行性：本质上要回归到dp的递推公式，dp[i][j]的推导使用了它上方的元素dp[i-1][j],左上方的元素dp[i-1][j-weight[i]]
	for i := 1; i < len(dp); i++ {
		for j := 1; j <= bagweight; j++ {

			if j < weight[i] { //当前背包装不下物品i
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = max(value[i]+dp[i-1][j-weight[i]], dp[i-1][j])
			}
		}
	}

	for i := 0; i < len(dp); i++ {
		fmt.Printf("%v\n", dp[i])
	}

	return dp[len(dp)-1][bagweight]
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	weight := []int{1, 3, 4}
	value := []int{15, 20, 30}
	bagweight := 4
	test_2_wei_bag_problem1(weight, value, bagweight)

}
