package 数组

///升序的二维矩阵从右上角看就是一颗类二叉搜索树

func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])
	row := 0
	col := n - 1
	for row < m && col >= 0 {
		if target == matrix[row][col] {
			return true
		} else if target > matrix[row][col] {
			row++
		} else {
			col--
		}
	}
	return false
}
