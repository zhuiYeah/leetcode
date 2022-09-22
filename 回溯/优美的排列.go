package 回溯

//时空复杂度都还不错
func countArrangement(n int) int {
	res := 0
	choosed := make([]bool, n+1)   //记录已经被填入prem排列里面的数字  as:choose[i]==true ，表示i已经被填入优美排列了
	var backtracking func(cur int) //cur：当前层需要向prem[cur]里填充数字以满足优美排列 ,cur是下标
	backtracking = func(cur int) {
		if cur == n+1 { //此时prem已经被一种排列填满了
			res++
			return
		}
		for i := 1; i <= n; i++ {
			if !choosed[i] && (i%cur == 0 || cur%i == 0) { //树层剪枝
				choosed[i] = true
			} else {
				continue
			}
			//
			backtracking(cur + 1)
			//回溯
			choosed[i] = false
		}
	}
	backtracking(1)
	return res
}
