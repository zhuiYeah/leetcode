package 二分查找

//二叉搜索树
func searchMatrix2(matrix [][]int, target int) bool {
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