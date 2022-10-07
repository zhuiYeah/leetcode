package 背包问题

//一大堆石头相互湮灭，最后剩下的石头重量的最小值是多少

//转化为01背包问题，背包容量为 所有石头重量/2，尽量填满这个背包

func lastStoneWeightII(stones []int) int {
	var sum int //石头总重
	for i := 0; i < len(stones); i++ {
		sum += stones[i]
	}
	bagCapacity := sum / 2           //背包容量，用一堆石头尽量填满这个背包，才能使两堆石头的差值最小
	dp := make([]int, bagCapacity+1) //dp[j]:背包容量为j时，能装下的最大石头重量为d[j](从0～i中任取石头)
	//dp[j]=max[dp[j],dp[j-stone[i]+stone[i]]
	//初始化dp数组 i=0时(仅能决定是否取第0块石头时)
	for j := bagCapacity; j >= stones[0]; j-- {
		dp[j] = stones[0]
	}

	for i := 1; i < len(stones); i++ { //遍历石头
		for j := bagCapacity; j > 0; j-- { //遍历背包容量
			if j < stones[i] {
				dp[j] = dp[j]
			} else {
				dp[j] = max(dp[j], dp[j-stones[i]]+stones[i])
			}
		}
	}
	return (sum - dp[bagCapacity]) - dp[bagCapacity]
}
