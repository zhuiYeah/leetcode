package 动态规划

//每一列能接的雨水= min（左边最大列高度，右边最大列高度）- 当前列高度
//左边最大列高度dp1，右边最大列高度dp2，都可以用两次动态规划

func trap(height []int) int {
	n := len(height)
	dp1 := make([]int, n) //dp1[i]：height[i] 不包括下标i ，左边的最大高度
	dp2 := make([]int, n) //dp2[i]：height[i] 不包括下标i  右边的最大高度
	//dp1[i] = max(dp1[i-1],height[i-1])   从左往右遍历
	//dp2[j] = max(dp2[j+1],height[j+1])   从右往左遍历
	dp1[0] = 0   //第一个数左边的最大值肯定为0
	dp2[n-1] = 0 //最后一个数右边的最大值肯定为0
	for i := 1; i < len(dp1); i++ {
		dp1[i] = max(dp1[i-1], height[i-1])
	}
	for i := len(dp2) - 2; i >= 0; i-- {
		dp2[i] = max(dp2[i+1], height[i+1])
	}
	var res int
	for i := 1; i < len(height)-1; i++ { //第一列和最后一列必定接不了雨水
		x := min(dp1[i], dp2[i]) - height[i] //x就是当前i列能接的雨水容量
		if x > 0 {
			res += x
		}
	}
	return res
}
