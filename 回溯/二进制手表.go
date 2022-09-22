package 回溯

import "strconv"

func readBinaryWatch(turnedOn int) []string {
	var res []string
	if turnedOn > 8 {
		return res
	}
	hours := 0
	minutes := 0
	nums := []int{1, 2, 4, 8, 16, 32, 100, 200, 400, 800}
	var backtracking func(int)
	backtracking = func(startIndex int) {
		if hours > 1100 || minutes >= 60 { //剪枝
			return
		}
		if turnedOn == 0 { //叶子节点
			var tmp string
			if minutes < 10 {
				tmp = strconv.Itoa(hours/100) + ":0" + strconv.Itoa(minutes)
			} else {
				tmp = strconv.Itoa(hours/100) + ":" + strconv.Itoa(minutes)
			}
			res = append(res, tmp)
			return
		}
		for i := startIndex; i < len(nums); i++ {
			//对当前节点处理
			if nums[i] >= 100 {
				hours += nums[i]
			} else {
				minutes += nums[i]
			}
			turnedOn--
			//往更深层进发，是否已经到达叶子节点了呢，是否需要剪枝
			backtracking(i + 1)
			//回溯
			if nums[i] >= 100 {
				hours -= nums[i]
			} else {
				minutes -= nums[i]
			}
			turnedOn++
		}
	}
	backtracking(0)
	return res
}
