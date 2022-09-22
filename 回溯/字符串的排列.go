package 回溯

//以前写的
func permutation0(s string) []string {
	var res []string
	visited := make([]bool, len(s)) //记录目前已经被选过的s中的元素
	var backtracking func(path string)
	backtracking = func(path string) {
		if len(path) == len(s) { //叶子节点
			res = append(res, path)
			return
		}
		seen := map[byte]bool{} //避免在当前层选择重复的元素，树层去重
		for i := 0; i < len(s); i++ {
			if !visited[i] && !seen[s[i]] {
				path += string(s[i])
				visited[i] = true
				seen[s[i]] = true
			} else {
				continue
			}
			//是否到达叶子结点？是否需要回溯  进入树的更深层
			backtracking(path)
			//回溯，从树的深层回来啦
			visited[i] = false
			path = path[:len(path)-1] //对于path的回溯，不管path做不作为函数传递的参数，path的回溯都是必须的
			// ，除非path在for循环中根本没有变动？？这里存疑
		}
	}
	backtracking("")
	return res
}

//新写的  path不再作为参数传递，而作为全局变量，path不管做不作为参数传递，对path的回溯是必须的
func permutation(S string) []string {
	var res []string
	path := ""
	visited := make([]bool, len(S))
	var backtracking func()
	backtracking = func() {
		if len(path) == len(S) {
			res = append(res, path)
			return
		}
		for i := 0; i < len(S); i++ {
			if !visited[i] {
				visited[i] = true
				path += string(S[i])
			} else {
				continue
			}
			backtracking()
			visited[i] = false
			path = path[:len(path)-1] //对于path的回溯，不管path做不作为函数传递的参数，path的回溯都是必须的
		}
	}
	backtracking()
	return res
}
