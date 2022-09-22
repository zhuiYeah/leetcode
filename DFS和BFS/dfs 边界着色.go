package DFS和BFS

//将连通分量的边界着色
func colorBorder(grid [][]int, row int, col int, color int) [][]int {
	m := len(grid)
	n := len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}
	ConnectedComponentsSharedValue := grid[row][col]
	var dfs func(int, int)
	dfs = func(i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != ConnectedComponentsSharedValue || visited[i][j] {
			return
		}
		//能走到这里，说明grid[i][j]是连通分量的区域内，并且未被访问过
		visited[i][j] = true
		if i-1 < 0 || grid[i-1][j] != ConnectedComponentsSharedValue && !visited[i-1][j] { //检查上
			grid[i][j] = color
		}
		if j-1 < 0 || grid[i][j-1] != ConnectedComponentsSharedValue && !visited[i][j-1] { //检查左
			grid[i][j] = color
		}
		if i+1 >= m || grid[i+1][j] != ConnectedComponentsSharedValue && !visited[i+1][j] { //检查下
			grid[i][j] = color
		}
		if j+1 >= n || grid[i][j+1] != ConnectedComponentsSharedValue && !visited[i][j+1] { //检查左
			grid[i][j] = color
		}
		dfs(i-1, j)
		dfs(i+1, j)
		dfs(i, j-1)
		dfs(i, j+1)
	}
	dfs(row, col)
	return grid
}

func main() {
	grid := [][]int{}
	grid = append(grid, []int{1, 2, 2})
	grid = append(grid, []int{2, 3, 2})
	colorBorder(grid, 0, 1, 3)
}
