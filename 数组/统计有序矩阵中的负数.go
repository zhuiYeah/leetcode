package 数组

func countNegatives(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	num := 0
	for i := 0; i < m; i++ {
		for j := n - 1; j >= 0; j-- {
			if grid[i][j] < 0 {
				num++
			} else {
				break
			}
		}
	}
	return num
}
