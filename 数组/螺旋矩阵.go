package 数组

//递归 顺时针打印矩阵
func spiralOrder(matrix [][]int) []int {
	var res []int
	m := len(matrix)
	n := len(matrix[0])
	visited := make([][]bool, m) //visit[i][j]为0表示矩阵中的i，j位置没有访问过
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}
	visited[0][0] = true
	var dfs func(int, int)
	dfs = func(i, j int) { //现在走到死路i，j了 下一步往哪走？
		if j+1 < n && !visited[i][j+1] { //右
			var col int
			for col = j + 1; col < n && !visited[i][col]; col++ {
				res = append(res, matrix[i][col])
				visited[i][col] = true
			}
			col--
			dfs(i, col)
		}

		if i+1 < m && !visited[i+1][j] { //down
			var row int
			for row = i + 1; row < m && !visited[row][j]; row++ {
				res = append(res, matrix[row][j])
				visited[row][j] = true
			}
			row--
			dfs(row, j)
		}

		if j-1 >= 0 && !visited[i][j-1] { //left
			var col int
			for col = j - 1; col >= 0 && !visited[i][col]; col-- {
				res = append(res, matrix[i][col])
				visited[i][col] = true
			}
			col++
			dfs(i, col)
		}

		if i-1 >= 0 && !visited[i-1][j] { //up
			var row int
			for row = i - 1; row >= 0 && !visited[row][j]; row-- {
				res = append(res, matrix[row][j])
				visited[row][j] = true
			}
			row++
			dfs(row, j)
		}
	}
	res = append(res, matrix[0][0])
	dfs(0, 0)
	return res
}

//func InitVisit(m, n int) [][]bool {
//	visit := make([][]bool, m)
//	for i := 0; i < len(visit); i++ {
//		visit[i] = make([]bool, n)
//	}
//	return visit
//}

func main() {
	mat := [][]int{}
	mat = append(mat, []int{1, 2, 3})
	mat = append(mat, []int{4, 5, 6})
	mat = append(mat, []int{7, 8, 9})

}
