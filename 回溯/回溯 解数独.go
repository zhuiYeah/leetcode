package 回溯

//之前所有的回溯题目都是单层递归 ， 这里是二维递归
func solveSudoku(board [][]byte) {

	var backtracking func() bool
	backtracking = func() bool {
		//本题递归不用终止条件，解数独是要遍历整个树形结构寻找可能的叶子节点就立刻返回。
		for i := 0; i < 9; i++ {
			for j := 0; j < 9; j++ {
				if board[i][j] != '.' { //找到空棋盘再往里面填入数字1～9啊，不是空棋盘的话直接下一个
					continue
				}

				for k := '1'; k <= '9'; k++ {
					if isValidKK(i, j, byte(k), board) {
						//对当前节点的处理 ， k能放进当前空位,那就放
						board[i][j] = byte(k)
						//是否以及找到一组正确解啦？找到的话直接return；没找到的话回溯 说明上一步放置的k不对（虽然那么放是合法的，但是找不到解啊）
						//放入一个k到棋盘上之后，往下一个空位置继续放
						if backtracking() {
							return true
						}
						//回溯
						board[i][j] = '.'
					}
				}
				//对于board[i][j]这个空位，1～9这些数字都填过了，但是都没找到true正确解 ，说明前面的步骤填错了，需要回溯，那么就返回false，回到上一步backtracking，回溯后再深入
				return false
			}
		}
		//如果 9*9的棋盘都遍历完了，都填满了，那就找到正确解了
		return true
	}
	backtracking()
}

func isValidKK(row int, col int, k byte, broad [][]byte) bool { //在broad[row][col]位置放入k是否合适
	//检查行
	for i := 0; i < 9; i++ { //表示第row行第i列
		if broad[row][i] == k {
			return false
		}
	}
	//检查列
	for i := 0; i < 9; i++ { //表示第i行第col列
		if broad[i][col] == k {
			return false
		}
	}

	//检查九宫格
	x := row - row%3
	y := col - col%3
	for i := x; i < x+3; i++ {
		for j := y; j < y+3; j++ {
			if broad[i][j] == k {
				return false
			}
		}
	}

	return true
}
