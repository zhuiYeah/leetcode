package 回溯

//自己写，写了很久还是错的，问题就在于对于已经访问过节点的标记 和 回溯阶段对节点的取消标记 这一块没写好
//func getMaximumGold0(grid [][]int) int {
//	m := len(grid)
//	n := len(grid[0])
//	maxGold := 0
//	var visited [][]bool
//	var backtracking func(int, int, int)
//	backtracking = func(i, j int, curSum int) {
//		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j] == true { //剪枝，越界和空矿不走，回头
//			return
//		}
//		curSum += grid[i][j]
//		visited[i][j] = true
//		if curSum > maxGold {
//			maxGold = curSum
//		}
//		for token := 0; token < 4; token++ { //往上下左右四个方向走
//			if token == 0 {
//				backtracking(i-1, j, curSum)
//			} else if token == 1 {
//				backtracking(i+1, j, curSum)
//			} else if token == 2 {
//				backtracking(i, j-1, curSum)
//			} else {
//				backtracking(i, j+1, curSum)
//			}
//			//所有的curSum以及visited都被作为参数了 XXXXX本题visited不能作为参数
//			//回溯
//			if token == 0 && i-1 >= 0 {
//				visited[i-1][j] = false
//			} else if token == 1 && i+1 < m {
//				visited[i+1][j] = false
//			} else if token == 2 && j-1 >= 0 {
//				visited[i][j-1] = false
//			} else if token == 3 && j+1 < n {
//				visited[i][j+1] = false
//			}
//		}
//	}
//	for i := 0; i < m; i++ {
//		for j := 0; j < n; j++ {
//			if grid[i][j] != 0 {
//				visited = InitVisit(m, n)
//				backtracking(i, j, 0)
//			}
//		}
//	}
//	return maxGold
//}
//
//func main() {
//	grid := [][]int{}
//	grid = append(grid, []int{0, 6, 0})
//	grid = append(grid, []int{5, 8, 7})
//	grid = append(grid, []int{0, 9, 0})
//	getMaximumGold(grid)
//}

//节点处理阶段可以在for循环之上我是知道的
//回溯阶段可以放在for循环的下面我是第一次见
var dirs = []struct{ x, y int }{{-1, 0}, {1, 0}, {0, -1}, {0, 1}} //分别表示上下左右

func getMaximumGold0(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var ans int
	var dfs func(i, j, curSum int)
	dfs = func(i, j, curSum int) {
		//对当前节点的处理
		curSum += grid[i][j]
		if curSum > ans {
			ans = curSum
		}
		tmp := grid[i][j]
		grid[i][j] = 0 //标记当前位置已经走过
		//选择下一条路径往哪走，并进入更深一层，如果上下左右都是死路，那么本层dfs正常运行结束，回到上一层，本层也会被标记为未采过
		for token := 0; token < 4; token++ {
			nextRow := i + dirs[token].x
			nextCol := j + dirs[token].y
			if nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0 { //能走再走
				dfs(nextRow, nextCol, curSum)
			}
		}
		//回溯，恢复位置，标记该位置未被采过
		//能走到这一步，说明上下左右都是死路，接下来要回溯到上一步了，要将当前位置的 已走过标记 取消
		grid[i][j] = tmp
		curSum -= tmp
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] > 0 {
				dfs(i, j, 0)
			}
		}
	}
	return ans
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//陈佳明讲解版
func getMaximumGold(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	var res int
	var dfs func(i, j, curSum int)
	dfs = func(i, j, curSum int) {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
			return
		}
		tmp := grid[i][j]
		curSum += tmp
		if curSum > res {
			res = curSum
		}
		grid[i][j] = 0 //标记为访问过
		dfs(i-1, j, curSum)
		dfs(i+1, j, curSum)
		dfs(i, j-1, curSum)
		dfs(i, j+1, curSum)
		//走到这里说明上下左右都走完了，这条路径也要往上一步回溯了，那么对于grid[i][j]需要恢复原状
		grid[i][j] = tmp
		//curSum -= tmp  //这里加不加这一行都一样
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(i, j, 0)
		}
	}
	return res
}
