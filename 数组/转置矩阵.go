package 数组

func transpose(matrix [][]int) [][]int {
	m := len(matrix)
	n := len(matrix[0])
	res := make([][]int, n)
	for i := 0; i < len(res); i++ {
		res[i] = make([]int, m)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			res[i][j] = matrix[j][i]
		}
	}
	return res
}
