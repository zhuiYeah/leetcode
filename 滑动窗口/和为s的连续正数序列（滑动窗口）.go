package 滑动窗口

//找到所有和为target的连续数字序列

func findContinuousSequence(target int) [][]int {
	res := [][]int{}
	left, right := 1, 1 //构成了滑动窗口
	sum := 0
	for right < target {
		if sum == target {
			tmp := []int{}
			for i := left; i < right; i++ {
				tmp = append(tmp, i)
			}
			res = append(res, tmp)
			sum -= left
			left++
		} else if sum > target {
			sum -= left
			left++
		} else {
			sum += right
			right++
		}
	}
	return res
}
