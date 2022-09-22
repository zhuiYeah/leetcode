package 数组

func isToeplitzMatrix(matrix [][]int) bool {
	m := len(matrix)
	n := len(matrix[0])
	count := max(m, n)
	for diff := 0; diff < count; diff++ {
		//diff现在作为横纵坐标之间的差值
		//i作为横坐标
		//i+diff作为纵坐标
		for i := 1; i < m && i+diff < n; i++ {
			if matrix[i][i+diff] != matrix[i-1][i-1+diff] {
				return false
			}
		}
		//diff现在作为横纵坐标之间的差值
		//j作为纵坐标
		//j+diff作为横坐标
		for j := 1; j+diff < m && j < n; j++ {
			if matrix[j+diff][j] != matrix[j+diff-1][j-1] {
				return false
			}
		}
	}
	return true
}

func isToeplitzMatrix0(matrix [][]int) bool {
	m := len(matrix)
	n := len(matrix[0])
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if matrix[i][j] != matrix[i-1][j-1] {
				return false
			}
		}
	}
	return true
}
