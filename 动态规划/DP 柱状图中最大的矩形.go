package 动态规划

//两次动态规划
func largestRectangleArea(heights []int) int {
	n := len(heights)
	dpLeftIndex := make([]int, n)  //当前柱子的下标为i，左边第一个比当前柱子矮的柱子的下标为dpLeftIndex[i] 从左往右遍历
	dpRightIndex := make([]int, n) //当前柱子的下标为i，右边第一个比当前柱子矮的柱子的下标为dpRightIndex[i] 从右往左遍历

	//求dpLeftIndex[i] : 先取t为i-1，如果height[t]<height[i] ,则dp[i]=t
	//如果height[t]>=height[i]   则t更新为dp[t] （找到i-1左边的第一个矮柱子），看看这个矮柱子比不比柱子i矮
	//如果矮的话，dp[i]=t ,
	//否则一直重复上面的步骤，直到height[t]<height[i]或者下标t越界

	dpLeftIndex[0] = -1                     //柱子0左边没有柱子，不存在左边的柱子会比他小
	for i := 1; i < len(dpLeftIndex); i++ { //从柱子1开始
		t := i - 1 //i左边的第一根柱子
		for t >= 0 && heights[t] >= heights[i] {
			t = dpLeftIndex[t]
		}
		dpLeftIndex[i] = t
	}

	dpRightIndex[len(dpRightIndex)-1] = len(heights) //最后一根柱子右边没有柱子
	for i := len(dpRightIndex) - 2; i >= 0; i-- {    //从倒数第二根柱子开始
		t := i + 1 //i右边的第一根柱子
		for t < len(heights) && heights[t] >= heights[i] {
			t = dpRightIndex[t]
		}
		dpRightIndex[i] = t
	}

	var res int
	for i := 0; i < len(heights); i++ {
		TheAreaOfThisColumnMustBeUsed := heights[i] * (dpRightIndex[i] - dpLeftIndex[i] - 1)
		res = max(res, TheAreaOfThisColumnMustBeUsed)
	}
	return res
}
