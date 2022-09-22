package 回溯

func solveNQueens(n int) [][]string {
	var res [][]string
	checkerboard := make([][]int, n) //用二维数组模拟棋盘,n行
	//每一行都要分配n个空间 n列
	for i := 0; i < n; i++ {
		checkerboard[i] = make([]int, n)
	}
	var backtracking func(currentRow int)
	backtracking = func(currentRow int) {
		if currentRow == n { //叶子节点，本题叶子节点一定是n皇后的解，如果到不了任何一个叶子节点，则n皇后无解
			x := changeX(checkerboard)
			res = append(res, x)
			return
		}
		for i := 0; i < n; i++ {
			//从currentRow的n个位置中选取一个位置i放皇后
			//判断这个点放下去之后棋盘有效才能放，否则找这一行的下一个点，这保证了棋盘任何时刻都是有效的
			//如果一行中的所有位置都能不放置皇后，这个for循环直接结束，直接递归回到上一个backtracking，。。。回溯
			if isValid(checkerboard, currentRow, i) {
				checkerboard[currentRow][i] = 11
			} else {
				continue
			}
			//我要往下一层放皇后咯  但是当前是否到达叶子节点了呢？如果到达叶子结点的话，我要写入结果的，
			backtracking(currentRow + 1)
			//回溯
			checkerboard[currentRow][i] = 0
		}
	}
	backtracking(0)
	return res

}

func isValid(checkerboard [][]int, row int, col int) bool {
	n := len(checkerboard)
	//检查行 , 不需要检查行，自己想想为什么

	//检查列是否有皇后
	for i := 0; i < row; i++ {
		if checkerboard[i][col] == 11 {
			return false
		}
	}

	//检查左上方45度角是否有皇后
	for i, j := row-1, col-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
		if checkerboard[i][j] == 11 {
			return false
		}
	}

	//检查右上方135度角是否有皇后
	for i, j := row-1, col+1; i >= 0 && j < n; i, j = i-1, j+1 {
		if checkerboard[i][j] == 11 {
			return false
		}
	}

	return true
}

func changeX(x [][]int) []string {
	var ss []string
	for i := 0; i < len(x); i++ {
		var s string
		for j := 0; j < len(x); j++ {
			if x[i][j] == 0 {
				s += "."
			} else {
				s += "Q"
			}
		}
		ss = append(ss, s)
	}
	return ss
}

func main() {

}
