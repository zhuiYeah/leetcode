package DFS和BFS

//超时了
func pacificAtlantic1(heights [][]int) [][]int {
	m := len(heights)
	n := len(heights[0])
	var pacific func(int, int) bool
	var atlantic func(int, int) bool
	pacific = func(i, j int) bool {
		visited := make([][]int, m)
		for i := 0; i < len(visited); i++ {
			visited[i] = make([]int, n)
		}
		queue := []int{n*i + j}
		for len(queue) != 0 {
			curP := queue[0]
			queue = queue[1:]
			row := curP / n
			col := curP % n
			visited[row][col] = 1
			if row == 0 || col == 0 {
				return true
			}
			if row-1 >= 0 && heights[row-1][col] <= heights[row][col] && visited[row-1][col] == 0 { //上
				queue = append(queue, n*(row-1)+col)
			}
			if row+1 < m && heights[row+1][col] <= heights[row][col] && visited[row+1][col] == 0 { //下
				queue = append(queue, n*(row+1)+col)
			}
			if col-1 >= 0 && heights[row][col-1] <= heights[row][col] && visited[row][col-1] == 0 { //左
				queue = append(queue, n*row+col-1)
			}
			if col+1 < n && heights[row][col+1] <= heights[row][col] && visited[row][col+1] == 0 { //右
				queue = append(queue, n*row+col+1)
			}
		}
		return false
	}
	atlantic = func(i, j int) bool {
		visited := make([][]int, m)
		for i := 0; i < len(visited); i++ {
			visited[i] = make([]int, n)
		}
		queue := []int{n*i + j}
		for len(queue) != 0 {
			curP := queue[0]
			queue = queue[1:]
			row := curP / n
			col := curP % n
			visited[row][col] = 1
			if row == m-1 || col == n-1 {
				return true
			}
			if row-1 >= 0 && heights[row-1][col] <= heights[row][col] && visited[row-1][col] == 0 { //上
				queue = append(queue, n*(row-1)+col)
			}
			if row+1 < m && heights[row+1][col] <= heights[row][col] && visited[row+1][col] == 0 { //下
				queue = append(queue, n*(row+1)+col)
			}
			if col-1 >= 0 && heights[row][col-1] <= heights[row][col] && visited[row][col-1] == 0 { //左
				queue = append(queue, n*row+col-1)
			}
			if col+1 < n && heights[row][col+1] <= heights[row][col] && visited[row][col+1] == 0 { //右
				queue = append(queue, n*row+col+1)
			}
		}
		return false
	}
	var res [][]int
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if pacific(i, j) && atlantic(i, j) {
				res = append(res, []int{i, j})
			}
		}
	}
	return res
}
