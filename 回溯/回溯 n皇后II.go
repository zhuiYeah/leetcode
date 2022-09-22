package 回溯

func totalNQueens(n int) int {
	var res int
	//初始化棋盘
	checkerboard := make([][]int, n)
	for i := 0; i < n; i++ {
		checkerboard[i] = make([]int, n)
	}
	var backtracking func(currentRow int)
	backtracking = func(currentRow int) {
		if currentRow == n { //叶子节点
			res++
		}
		for i := 0; i < n; i++ {
			//
			if isValidC(checkerboard, currentRow, i) {
				checkerboard[currentRow][i] = 12
			} else {
				continue
			}
			//
			backtracking(currentRow + 1)
			//
			checkerboard[currentRow][i] = 0
		}
	}
	backtracking(0)

	return res
}

func isValidC(checkerboard [][]int, row, col int) bool {
	n := len(checkerboard)
	//检查列
	for i := row - 1; i >= 0; i-- {
		if checkerboard[i][col] == 12 {
			return false
		}
	}

	//检查左上方45度
	for i, j := row-1, col-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
		if checkerboard[i][j] == 12 {
			return false
		}
	}

	//检查右上方135度
	for i, j := row-1, col+1; i >= 0 && j < n; i, j = i-1, j+1 {
		if checkerboard[i][j] == 12 {
			return false
		}
	}
	return true
}
