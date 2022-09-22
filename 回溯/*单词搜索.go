package 回溯

//尼玛 写死老子了 才超越5%  矩阵中的路径
func exist0(board [][]byte, word string) bool {
	m := len(board)
	n := len(board[0])
	visit := InitVisit(m, n)
	var backtracking func(wordIndex int, i int, j int) bool
	backtracking = func(wordIndex int, i int, j int) bool {
		if wordIndex == len(word)-1 { //叶子结点
			return true
		}
		visit[i][j] = true
		var nextAreaAccessible []int
		if i-1 >= 0 {
			nextAreaAccessible = append(nextAreaAccessible, n*(i-1)+j)
		}
		if i+1 < m {
			nextAreaAccessible = append(nextAreaAccessible, n*(i+1)+j)
		}
		if j-1 >= 0 {
			nextAreaAccessible = append(nextAreaAccessible, n*i+j-1)
		}
		if j+1 < n {
			nextAreaAccessible = append(nextAreaAccessible, n*i+j+1)
		}
		for k := 0; k < len(nextAreaAccessible); k++ {
			row := nextAreaAccessible[k] / n
			col := nextAreaAccessible[k] % n
			if board[row][col] == word[wordIndex+1] && !visit[row][col] {
				visit[row][col] = true
				//到达叶子节点了吗 ，是否需要回溯
				if backtracking(wordIndex+1, row, col) {
					return true
				}
				//回溯,
				visit[row][col] = false

			}
		}
		return false
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == word[0] {
				visit = InitVisit(m, n)
				if backtracking(0, i, j) {
					return true
				}
			}
		}
	}

	return false
}

func InitVisit(m, n int) [][]bool {
	visit := make([][]bool, m)
	for i := 0; i < len(visit); i++ {
		visit[i] = make([]bool, n)
	}
	return visit
}

//回溯阶段放在for循环的下面  ，for循环中
//单词搜索   // 有点像黄金矿工？
func exist(board [][]byte, word string) bool {
	m := len(board)
	n := len(board[0])
	var matchedWordIndex int
	var backtracking func(i, j int) bool
	backtracking = func(i, j int) bool {
		if board[i][j] != word[matchedWordIndex] { //剪枝
			return false
		}
		//对当前节点的处理
		matchedWordIndex++
		if matchedWordIndex == len(word) {
			return true
		}
		tmp := board[i][j]
		board[i][j] = 0 //标记为已经访问过该位置
		//选择上下左右一个方向，向下深入
		for token := 0; token < len(dirs); token++ {
			nextRow := i + dirs[token].x
			nextCol := j + dirs[token].y
			if nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && board[nextRow][nextCol] != 0 {
				if backtracking(nextRow, nextCol) {
					return true
				}
			}
		}
		//回溯阶段
		//能走到这一步，说明上下左右都是死路，接下来要正常结束本backtracking函数回溯到上一步了，要将当前位置的已访问标记取
		//消，并且让已匹配的单词下标往回缩
		board[i][j] = tmp //取消当前位置的已访问标记
		matchedWordIndex--
		return false
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if backtracking(i, j) {
				return true
			}
		}
	}
	return false
}


