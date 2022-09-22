package 递归

//数组 螺旋矩阵
func spiralOrder(matrix [][]int) []int {
	var res []int
	if len(matrix) == 0 {
		return res
	}
	m := len(matrix)
	n := len(matrix[0])
	visit := make([][]int, m) //visit[i][j]为0表示矩阵中的i，j位置没有访问过
	for i := 0; i < m; i++ {
		visit[i] = make([]int, n)
	}

	var nextStep func(int, int)
	nextStep = func(i int, j int) {
		if j+1 < n && visit[i][j+1] == 0 { //往右走
			var col int
			for col = j + 1; col < n && visit[i][col] == 0; col++ {
				res = append(res, matrix[i][col])
				visit[i][col] = 1
			}
			col--
			nextStep(i, col)
		}
		if i+1 < m && visit[i+1][j] == 0 { //往下走
			var row int
			for row = i + 1; row < m && visit[row][j] == 0; row++ {
				res = append(res, matrix[row][j])
				visit[row][j] = 1
			}
			row--
			nextStep(row, j)
		}
		if j-1 >= 0 && visit[i][j-1] == 0 { //往左走
			var col int
			for col = j - 1; col >= 0 && visit[i][col] == 0; col-- {
				res = append(res, matrix[i][col])
				visit[i][col] = 1
			}
			col++
			nextStep(i, col)
		}
		if i-1 >= 0 && visit[i-1][j] == 0 { //往上走
			var row int
			for row = i - 1; row >= 0 && visit[row][j] == 0; row-- {
				res = append(res, matrix[row][j])
				visit[row][j] = 1
			}
			row++
			nextStep(row, j)
		}
	}
	res = append(res, matrix[0][0])
	visit[0][0] = 1
	nextStep(0, 0)
	return res
}
