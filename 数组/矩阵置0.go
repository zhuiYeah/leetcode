package 数组

func setZeroes(matrix [][]int) {
	row := map[int]int{}
	col := map[int]int{}
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				row[i] = 1
				col[j] = 1
			}
		}
	}
	for key, _ := range row {
		for j := 0; j < len(matrix[0]); j++ {
			matrix[key][j] = 0
		}
	}
	for key, _ := range col {
		for i := 0; i < len(matrix); i++ {
			matrix[i][key] = 0
		}
	}
}
