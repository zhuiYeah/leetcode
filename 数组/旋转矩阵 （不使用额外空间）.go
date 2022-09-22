package 数组

func rotate(matrix [][]int) {
	n := len(matrix)
	//上下翻转
	for i := 0; i < len(matrix)/2; i++ {
		matrix[i], matrix[len(matrix)-1-i] = matrix[len(matrix)-1-i], matrix[i]
	}
	//主对角线翻转
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}

}
