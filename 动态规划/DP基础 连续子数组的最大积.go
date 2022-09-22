package 动态规划

func maxProduct(nums []int) int {

	dpMax := make([]int, len(nums)) //dpMax[i]: 当前到了nums[i],必须乘上nums[i]的话，目前的最大乘积为 dpMax[i]
	dpMin := make([]int, len(nums)) //dpMin[i] :当前到了nums[i],必须乘上nums[i]的话，目前最小乘积为 dpMin[i]
	//为什么要维护两个dp数组，因为当num[i]为负数时，我希望之前的子路径负的越多越好（越小越好），
	//当nums[i]为正数时，之前的子路径正的越多越好（越大越好）
	res := nums[0]
	dpMax[0], dpMin[0] = nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		dpMax[i] = max(nums[i], max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]))
		dpMin[i] = min(nums[i], min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]))
		if dpMax[i] > res {
			res = dpMax[i]
		}
	}
	return res
}
