package 回溯

import "strconv"

func smallestNumber(pattern string) string {
	visited := make([]bool, 10) //用来标记1～9这几个数字是否被选择过
	var path []int
	var backtracking func(curIndex int) bool
	backtracking = func(curIndex int) bool {
		if len(path) == len(pattern)+1 {
			return true
		}
		if len(path) == 0 {
			for i := 1; i <= 9; i++ {
				path = append(path, i)
				visited[i] = true
				if backtracking(curIndex) {
					return true
				} else {
					path = path[:len(path)-1]
					visited[i] = false
				}
			}
			return false
		}
		if pattern[curIndex] == 'I' {
			for i := path[len(path)-1] + 1; i <= 9; i++ {
				if !visited[i] {
					visited[i] = true
					path = append(path, i)
					if backtracking(curIndex + 1) {
						return true
					} else {
						visited[i] = false
						path = path[:len(path)-1]
					}
				}
			}
			return false
		} else {
			for i := path[len(path)-1] - 1; i >= 1; i-- {
				if !visited[i] {
					visited[i] = true
					path = append(path, i)
					if backtracking(curIndex + 1) {
						return true
					} else {
						visited[i] = false
						path = path[:len(path)-1]
					}
				}
			}
			return false
		}
	}
	backtracking(0)
	var res string
	for i := 0; i < len(path); i++ {
		res += strconv.Itoa(path[i])
	}
	return res
}
