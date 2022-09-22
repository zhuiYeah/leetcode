package 回溯

//生成n对合理的括号，给出所有的可能排列
func generateParenthesis(n int) []string {
	var res []string
	path := ""
	var backtracking func(int, int)
	backtracking = func(numOfLeft, numOfRight int) {
		//任何时刻，右括号的个数都不能大于左括号个数;任何时刻，左右括号的个数不能大于n
		if numOfRight > numOfLeft || numOfLeft > n || numOfRight > n {
			return
		}
		if len(path) == 2*n { //叶子节点
			tmp := path
			res = append(res, tmp)
			return
		}
		for i := 0; i < 2; i++ { //每层只有两个选择，0代表添加"（"，1代表添加"）"
			if i == 0 {
				path += "("
			} else {
				path += ")"
			}
			//往更深层去，是否到达叶子结点
			if i == 0 {
				backtracking(numOfLeft+1, numOfRight)
			} else {
				backtracking(numOfLeft, numOfRight+1)
			}
			//回溯
			path = path[:len(path)-1] ////path的回溯是必须的，即使是作为函数传递的参数，栈也并不能保存当前的path
		}
	}
	backtracking(0, 0)
	return res
}
