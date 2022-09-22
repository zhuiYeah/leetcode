package 数组

//用1～n^2以螺旋的形式填满矩阵
func generateMatrix(n int) [][]int {
	mat := make([][]int, n)
	for i := 0; i < n; i++ {
		mat[i] = make([]int, n)
	}
	var nums []int
	for i := 2; i <= n*n; i++ {
		nums = append(nums, i)
	}
	var col int
	var row int
	var nextSetp func(int, int)

	nextSetp = func(i, j int) {
		if j+1 < n && mat[i][j+1] == 0 { ////right
			for col = j + 1; col < n && mat[i][col] == 0; col++ {
				mat[i][col] = nums[0]
				nums = append(nums[:0], nums[1:]...)
			}
			col--
			nextSetp(i, col)
		}
		if j-1 >= 0 && mat[i][j-1] == 0 { //left
			for col = j - 1; col >= 0 && mat[i][col] == 0; col-- {
				mat[i][col] = nums[0]
				nums = append(nums[:0], nums[1:]...)
			}
			col++
			nextSetp(i, col)
		}
		if i+1 < n && mat[i+1][j] == 0 { //down
			for row = i + 1; row < n && mat[row][j] == 0; row++ {
				mat[row][j] = nums[0]
				nums = append(nums[:0], nums[1:]...)
			}
			row--
			nextSetp(row, j)
		}
		if i-1 >= 0 && mat[i-1][j] == 0 { //up
			for row = i - 1; row >= 0 && mat[row][j] == 0; row-- {
				mat[row][j] = nums[0]
				nums = append(nums[:0], nums[1:]...)
			}
			row++
			nextSetp(row, j)
		}
	}
	mat[0][0] = 1
	nextSetp(0, 0)
	return mat
}
